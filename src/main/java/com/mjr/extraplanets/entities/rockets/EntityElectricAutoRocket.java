package com.mjr.extraplanets.entities.rockets;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.entity.IEntityNoisy;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IOrbitDimension;
import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.blocks.BlockLandingPadFull;
import micdoodle8.mods.galacticraft.core.client.sounds.SoundUpdaterRocket;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.event.EventLandingPadRemoval;
import micdoodle8.mods.galacticraft.core.network.PacketDynamic;
import micdoodle8.mods.galacticraft.core.tile.TileEntityLandingPad;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.block.Block;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.api.IPowerDock;
import com.mjr.extraplanets.api.IPoweredLandable;
import com.mjr.mjrlegendslib.inventory.IInventoryDefaults;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public abstract class EntityElectricAutoRocket extends EntityElectricSpaceshipBase implements IPoweredLandable, IInventoryDefaults, IEntityNoisy {
	public BlockPos targetVec;
	public int targetDimension;
	protected NonNullList<ItemStack> stacks;
	private IPowerDock landingPad;

	public String statusMessage;
	public String statusColour;
	public int statusMessageCooldown;
	public int lastStatusMessageCooldown;
	public boolean statusValid;
	protected double lastMotionY;
	protected double lastLastMotionY;
	private boolean waitForPlayer;
	protected ITickable rocketSoundUpdater;
	private boolean rocketSoundToStop = false;

	public EntityElectricAutoRocket(World world) {
		super(world);

		if (world != null && world.isRemote) {
			GalacticraftCore.packetPipeline.sendToServer(new PacketDynamic(this));
		}
	}

	public EntityElectricAutoRocket(World world, double posX, double posY, double posZ) {
		this(world);
		this.setSize(0.98F, 2F);
		this.setPosition(posX, posY, posZ);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = posX;
		this.prevPosY = posY;
		this.prevPosZ = posZ;
	}

	@Override
	public void onUpdate() {
		// Workaround for a weird bug (?) in vanilla 1.8.9 where - if client view distance is shorter
		// than the server's chunk loading distance - chunks will unload on the client, but the
		// entity will still be in the WorldClient.loadedEntityList. This results in an entity which
		// is in the world, not dead and still updating on both server and client, but not in any chunk's
		// chunk.entityLists. Also, it won't be reloaded into any chunk's entityLists when the chunk comes
		// back into viewing range - not sure why, maybe because it's already in the World.loadedEntityList?
		// Because it's now not in any chunk's entityLists, it cannot be iterated for rendering by RenderGlobal,
		// so it's gone invisible!

		// Tracing shows that Chunk.onChunkUnload() is called on the chunk clientside when the chunk goes
		// out of the view distance. However, even after Chunk.onChunkUnload() - which should remove
		// this entity from the WorldClient.loadedEntityList - this entity stays in the world loadedEntityList.
		// That's why an onUpdate() tick is active for it, still!
		// Weird, huh?
		if (this.world.isRemote && this.addedToChunk) {
			Chunk chunk = this.world.getChunkFromChunkCoords(this.chunkCoordX, this.chunkCoordZ);
			int cx = MathHelper.floor(this.posX) >> 4;
			int cz = MathHelper.floor(this.posZ) >> 4;
			if (chunk.isLoaded() && this.chunkCoordX == cx && this.chunkCoordZ == cz) {
				boolean thisfound = false;
				ClassInheritanceMultiMap<Entity> mapEntities = chunk.getEntityLists()[this.chunkCoordY];
				for (Entity ent : mapEntities) {
					if (ent == this) {
						thisfound = true;
						break;
					}
				}
				if (!thisfound) {
					chunk.addEntity(this);
				}
			}
		}

		if (this.launchPhase == EnumLaunchPhase.LANDING.ordinal() && this.hasValidPower()) {
			if (this.targetVec != null) {
				double yDiff = this.posY - this.getOnPadYOffset() - this.targetVec.getY();
				this.motionY = Math.max(-2.0, (yDiff - 0.04) / -55.0);

				// Some lateral motion in case not exactly on target (happens if rocket was moving laterally during launch)
				double diff = this.posX - this.targetVec.getX() - 0.5D;
				double motX, motZ;
				if (diff > 0D) {
					motX = Math.max(-0.1, diff / -100.0D);
				} else if (diff < 0D) {
					motX = Math.min(0.1, diff / -100.0D);
				} else
					motX = 0D;
				diff = this.posZ - this.targetVec.getZ() - 0.5D;
				if (diff > 0D) {
					motZ = Math.max(-0.1, diff / -100.0D);
				} else if (diff < 0D) {
					motZ = Math.min(0.1, diff / -100.0D);
				} else
					motZ = 0D;
				if (motZ != 0D || motX != 0D) {
					double angleYaw = Math.atan(motZ / motX);
					double signed = motX < 0 ? 50D : -50D;
					double anglePitch = Math.atan(Math.sqrt(motZ * motZ + motX * motX) / signed) * 100D;
					this.rotationYaw = (float) angleYaw * Constants.RADIANS_TO_DEGREES;
					this.rotationPitch = (float) anglePitch * Constants.RADIANS_TO_DEGREES;
				} else
					this.rotationPitch = 0F;

				if (yDiff > 1D && yDiff < 4D) {
					for (Object o : this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().offset(0D, -3D, 0D), EntityElectricSpaceshipBase.rocketSelector)) {
						if (o instanceof EntityElectricSpaceshipBase) {
							((EntityElectricSpaceshipBase) o).dropShipAsItem();
							((EntityElectricSpaceshipBase) o).setDead();
						}
					}
				}
				if (yDiff < 0.4) {
					int yMin = MathHelper.floor(this.getEntityBoundingBox().minY - this.getOnPadYOffset() - 0.45D) - 2;
					int yMax = MathHelper.floor(this.getEntityBoundingBox().maxY) + 1;
					int zMin = MathHelper.floor(this.posZ) - 1;
					int zMax = MathHelper.floor(this.posZ) + 1;
					for (int x = MathHelper.floor(this.posX) - 1; x <= MathHelper.floor(this.posX) + 1; x++) {
						for (int z = zMin; z <= zMax; z++) {
							// Doing y as the inner loop may help with cacheing of chunks
							for (int y = yMin; y <= yMax; y++) {
								if (this.world.getTileEntity(new BlockPos(x, y, z)) instanceof IPowerDock) {
									// Land the rocket on the pad found
									this.rotationPitch = 0F;
									this.failRocket();
								}
							}
						}
					}
				}
			}
		}

		super.onUpdate();

		if (!this.world.isRemote) {
			if (this.statusMessageCooldown > 0) {
				this.statusMessageCooldown--;
			}

			if (this.launchPhase >= EnumLaunchPhase.LAUNCHED.ordinal()) {
				this.setPad(null);
			}

			this.lastStatusMessageCooldown = this.statusMessageCooldown;
		}

		if (this.launchPhase >= EnumLaunchPhase.IGNITED.ordinal()) {
			if (this.rocketSoundUpdater != null) {
				this.rocketSoundUpdater.update();
				this.rocketSoundToStop = true;
			}
		} else {
			if (this.rocketSoundToStop) {
				this.stopRocketSound();
				this.rocketSoundUpdater = null;
			}
		}
	}

	@Override
	protected boolean shouldMoveClientSide() {
		return false;
	}

	public boolean igniteWithResult() {
		if (this.isPlayerRocket()) {
			super.ignite();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void ignite() {
		this.igniteWithResult();
	}

	public abstract boolean isPlayerRocket();

	@Override
	public void landEntity(BlockPos pos) {
		TileEntity tile = this.world.getTileEntity(pos);

		if (tile instanceof IPowerDock) {
			IPowerDock dock = (IPowerDock) tile;

			if (this.isDockValid(dock)) {
				if (!this.world.isRemote) {
					// Drop any existing rocket on the landing pad
					if (dock.getDockedEntity() instanceof EntityElectricSpaceshipBase && dock.getDockedEntity() != this) {
						((EntityElectricSpaceshipBase) dock.getDockedEntity()).dropShipAsItem();
						((EntityElectricSpaceshipBase) dock.getDockedEntity()).setDead();
					}

					this.setPad(dock);
				}

				this.onRocketLand(pos);
			}
		}
	}

	protected void onRocketLand(BlockPos pos) {
		this.setPositionAndRotation(pos.getX() + 0.5, pos.getY() + 0.4D + this.getOnPadYOffset(), pos.getZ() + 0.5, this.rotationYaw, 0.0F);
		this.stopRocketSound();
		this.rocketSoundUpdater = null; // Allow sound to be restarted again if it relaunches
	}

	public void stopRocketSound() {
		if (this.rocketSoundUpdater != null) {
			((SoundUpdaterRocket) this.rocketSoundUpdater).stopRocketSound();
		}
		this.rocketSoundToStop = false;
	}

	@Override
	public void setDead() {
		super.setDead();

		if (this.rocketSoundUpdater != null) {
			this.rocketSoundUpdater.update();
		}
	}

	@Override
	public void decodePacketdata(ByteBuf buffer) {
		if (!this.world.isRemote) {
			double clientPosY = buffer.readDouble();
			if (clientPosY != Double.NaN && this.hasValidPower()) {
				if (this.launchPhase == EnumLaunchPhase.LAUNCHED.ordinal()) {
					if (clientPosY > this.posY) {
						this.motionY += (clientPosY - this.posY) / 40D;
					}
				} else if (this.launchPhase == EnumLaunchPhase.LANDING.ordinal()) {
					if (clientPosY < this.posY) {
						this.motionY += (clientPosY - this.posY) / 40D;
					}
				}
			}
			return;
		}
		int launchPhaseLast = this.launchPhase;
		super.decodePacketdata(buffer);
		this.setCurrentPowerCapacity(buffer.readFloat());
		boolean landingNew = buffer.readBoolean();
		if (landingNew && launchPhaseLast != EnumLaunchPhase.LANDING.ordinal()) {
			this.rocketSoundUpdater = null; // Flag TickHandlerClient to restart it
		}

		if (buffer.readBoolean()) {
			this.targetVec = new BlockPos(buffer.readInt(), buffer.readInt(), buffer.readInt());
		}

		double motX = buffer.readDouble() / 8000.0D;
		double motY = buffer.readDouble() / 8000.0D;
		double motZ = buffer.readDouble() / 8000.0D;
		double lastMotY = buffer.readDouble() / 8000.0D;
		double lastLastMotY = buffer.readDouble() / 8000.0D;

		if (!this.hasValidPower()) {
			this.motionX = motX;
			this.motionY = motY;
			this.motionZ = motZ;
			this.lastMotionY = lastMotY;
			this.lastLastMotionY = lastLastMotY;
		}

		if (this.stacks == null) {
			this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		}

		this.setWaitForPlayer(buffer.readBoolean());

		this.statusMessage = ByteBufUtils.readUTF8String(buffer);
		this.statusMessage = this.statusMessage.equals("") ? null : this.statusMessage;
		this.statusMessageCooldown = buffer.readInt();
		this.lastStatusMessageCooldown = buffer.readInt();
		this.statusValid = buffer.readBoolean();

		// Update client with correct rider if needed
		if (this.world.isRemote) {
			int shouldBeMountedId = buffer.readInt();
			if (this.getPassengers().isEmpty()) {
				if (shouldBeMountedId > -1) {
					Entity e = FMLClientHandler.instance().getWorldClient().getEntityByID(shouldBeMountedId);
					if (e != null) {
						if (e.dimension != this.dimension) {
							if (e instanceof EntityPlayer) {
								e = WorldUtil.forceRespawnClient(this.dimension, e.world.getDifficulty().getDifficultyId(), e.world.getWorldInfo().getTerrainType().getName(), ((EntityPlayerMP) e).interactionManager.getGameType().getID());
								e.startRiding(this);
							}
						} else
							e.startRiding(this);
					}
				}
			} else if (this.getPassengers().get(0).getEntityId() != shouldBeMountedId) {
				if (shouldBeMountedId == -1) {
					this.removePassengers();
				} else {
					Entity e = FMLClientHandler.instance().getWorldClient().getEntityByID(shouldBeMountedId);
					if (e != null) {
						if (e.dimension != this.dimension) {
							if (e instanceof EntityPlayer) {
								e = WorldUtil.forceRespawnClient(this.dimension, e.world.getDifficulty().getDifficultyId(), e.world.getWorldInfo().getTerrainType().getName(), ((EntityPlayerMP) e).interactionManager.getGameType().getID());
								e.startRiding(this);
							}
						} else
							e.startRiding(this);
					}
				}
			}
		}
		this.statusColour = ByteBufUtils.readUTF8String(buffer);
		if (this.statusColour.equals(""))
			this.statusColour = null;
	}

	@Override
	public void getNetworkedData(ArrayList<Object> list) {
		if (this.world.isRemote) {
			if (this.getPassengers().contains(FMLClientHandler.instance().getClientPlayerEntity()) && this.hasValidPower()) {
				list.add(this.posY);
			} else {
				list.add(Double.NaN);
			}
		}
		super.getNetworkedData(list);

		list.add(this.currentPowerCapacity);
		list.add(this.launchPhase == EnumLaunchPhase.LANDING.ordinal());
		list.add(this.targetVec != null);

		if (this.targetVec != null) {
			list.add(this.targetVec.getX());
			list.add(this.targetVec.getY());
			list.add(this.targetVec.getZ());
		}

		list.add(this.motionX * 8000.0D);
		list.add(this.motionY * 8000.0D);
		list.add(this.motionZ * 8000.0D);
		list.add(this.lastMotionY * 8000.0D);
		list.add(this.lastLastMotionY * 8000.0D);

		list.add(this.getWaitForPlayer());

		list.add(this.statusMessage != null ? this.statusMessage : "");
		list.add(this.statusMessageCooldown);
		list.add(this.lastStatusMessageCooldown);
		list.add(this.statusValid);

		if (!this.world.isRemote) {
			list.add(this.getPassengers().isEmpty() ? -1 : this.getPassengers().get(0).getEntityId());
		}
		list.add(this.statusColour != null ? this.statusColour : "");
	}

	@Override
	protected void failRocket() {
		this.stopRocketSound();

		if (this.shouldCancelExplosion()) {
			for (int i = -3; i <= 3; i++) {
				BlockPos pos = new BlockPos((int) Math.floor(this.posX), (int) Math.floor(this.posY + i), (int) Math.floor(this.posZ));
				if (this.launchPhase == EnumLaunchPhase.LANDING.ordinal() && this.targetVec != null && this.world.getTileEntity(pos) instanceof IPowerDock && this.posY - this.targetVec.getY() < 5) {
					for (int x = MathHelper.floor(this.posX) - 1; x <= MathHelper.floor(this.posX) + 1; x++) {
						for (int y = MathHelper.floor(this.posY - 3.0D); y <= MathHelper.floor(this.posY) + 1; y++) {
							for (int z = MathHelper.floor(this.posZ) - 1; z <= MathHelper.floor(this.posZ) + 1; z++) {
								BlockPos pos1 = new BlockPos(x, y, z);
								TileEntity tile = this.world.getTileEntity(pos1);

								if (tile instanceof IPowerDock) {
									this.landEntity(pos1);
									return;
								}
							}
						}
					}
				}
			}
		}

		if (this.launchPhase >= EnumLaunchPhase.LAUNCHED.ordinal()) {
			super.failRocket();
		}
	}

	protected boolean shouldCancelExplosion() {
		return this.hasValidPower();
	}

	@Override
	public boolean hasValidPower() {
		return this.currentPowerCapacity > 0;
	}

	public void cancelLaunch() {
		this.setLaunchPhase(EnumLaunchPhase.UNIGNITED);
		this.timeUntilLaunch = 0;
		if (!this.world.isRemote && !this.getPassengers().isEmpty() && this.getPassengers().get(0) instanceof EntityPlayerMP) {
			this.getPassengers().get(0).sendMessage(new TextComponentString(TranslateUtilities.translate("gui.rocket.warning.nogyroscope")));
		}
	}

	public void failMessageLaunchController() {
		if (!this.world.isRemote && !this.getPassengers().isEmpty() && this.getPassengers().get(0) instanceof EntityPlayerMP) {
			((EntityPlayerMP) this.getPassengers().get(0)).sendMessage(new TextComponentString(TranslateUtilities.translate("gui.rocket.warning.launchcontroller")));
		}
	}

	public void failMessageInsufficientFuel() {
		if (!this.world.isRemote && !this.getPassengers().isEmpty() && this.getPassengers().get(0) instanceof EntityPlayerMP) {
			((EntityPlayerMP) this.getPassengers().get(0)).sendMessage(new TextComponentString(TranslateUtilities.translate("gui.rocket.warning.fuelinsufficient")));
		}
	}

	@Override
	public void onLaunch() {
		if (!(this.world.provider.getDimension() == GalacticraftCore.planetOverworld.getDimensionID() || this.world.provider instanceof IGalacticraftWorldProvider)) {
			if (ConfigManagerCore.disableRocketLaunchAllNonGC) {
				this.cancelLaunch();
				return;
			}

			// No rocket flight in the Nether, the End etc
			for (int i = ConfigManagerCore.disableRocketLaunchDimensions.length - 1; i >= 0; i--) {
				if (ConfigManagerCore.disableRocketLaunchDimensions[i] == this.world.provider.getDimension()) {
					this.cancelLaunch();
					return;
				}
			}

		}

		super.onLaunch();

		if (!this.world.isRemote) {
			GCPlayerStats stats = null;

			if (!this.getPassengers().isEmpty()) {
				for (Entity player : this.getPassengers()) {
					if (player instanceof EntityPlayerMP) {
						stats = GCPlayerStats.get(player);

						if (!(this.world.provider instanceof IOrbitDimension)) {
							stats.setCoordsTeleportedFromX(player.posX);
							stats.setCoordsTeleportedFromZ(player.posZ);
						}
					}
				}
			}

			int amountRemoved = 0;

			PADSEARCH: for (int x = MathHelper.floor(this.posX) - 1; x <= MathHelper.floor(this.posX) + 1; x++) {
				for (int y = MathHelper.floor(this.posY) - 3; y <= MathHelper.floor(this.posY) + 1; y++) {
					for (int z = MathHelper.floor(this.posZ) - 1; z <= MathHelper.floor(this.posZ) + 1; z++) {
						BlockPos pos = new BlockPos(x, y, z);
						final Block block = this.world.getBlockState(pos).getBlock();

						if (block != null && block instanceof BlockLandingPadFull) {
							if (amountRemoved < 9) {
								EventLandingPadRemoval event = new EventLandingPadRemoval(this.world, pos);
								MinecraftForge.EVENT_BUS.post(event);

								if (event.allow) {
									this.world.setBlockToAir(pos);
									amountRemoved = 9;
								}
								break PADSEARCH;
							}
						}
					}
				}
			}

			// Set the player's launchpad item for return on landing - or null if launchpads not removed
			if (stats != null) {
				stats.setLaunchpadStack(amountRemoved == 9 ? new ItemStack(GCBlocks.landingPad, 9, 0) : null);
			}

			this.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
		}
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);

		nbt.setFloat("currentPowerCapacity", this.currentPowerCapacity);

		if (this.getSizeInventory() > 0) {
			ItemStackHelper.saveAllItems(nbt, this.stacks);
		}

		nbt.setBoolean("TargetValid", this.targetVec != null);

		if (this.targetVec != null) {
			nbt.setDouble("targetTileX", this.targetVec.getX());
			nbt.setDouble("targetTileY", this.targetVec.getY());
			nbt.setDouble("targetTileZ", this.targetVec.getZ());
		}

		nbt.setBoolean("WaitingForPlayer", this.getWaitForPlayer());
		nbt.setBoolean("Landing", this.launchPhase == EnumLaunchPhase.LANDING.ordinal());
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);

		this.currentPowerCapacity = nbt.getFloat("currentPowerCapacity");

		if (this.getSizeInventory() > 0) {
			this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
			ItemStackHelper.loadAllItems(nbt, this.stacks);
		}

		if (nbt.getBoolean("TargetValid") && nbt.hasKey("targetTileX")) {
			this.targetVec = new BlockPos(MathHelper.floor(nbt.getDouble("targetTileX")), MathHelper.floor(nbt.getDouble("targetTileY")), MathHelper.floor(nbt.getDouble("targetTileZ")));
		}

		this.setWaitForPlayer(nbt.getBoolean("WaitingForPlayer"));
	}

	@Override
	public void setPad(IPowerDock pad) {
		// Called either when a rocket lands or when one is placed
		// Can also be called with null param when rocket leaves a pad
		this.landingPad = pad;
		if (pad != null) {
			pad.dockEntity(this);
			// NOTE: setPad() is called also when a world or chunk is loaded - if the rocket is Ignited (from NBT save data) do not change those settings
			if (!(this.launchPhase == EnumLaunchPhase.IGNITED.ordinal())) {
				this.setLaunchPhase(EnumLaunchPhase.UNIGNITED);
				this.targetVec = null;
			}
		}
	}

	@Override
	public IPowerDock getLandingPad() {
		return this.landingPad;
	}

	@Override
	public boolean isDockValid(IPowerDock dock) {
		return (dock instanceof TileEntityLandingPad);
	}

	@Override
	public EnumCargoLoadingState addCargo(ItemStack stack, boolean doAdd) {
		if (this.getSizeInventory() <= 3) {
			return EnumCargoLoadingState.NOINVENTORY;
		}

		int count = 0;

		for (count = 0; count < this.stacks.size() - 2; count++) {
			ItemStack stackAt = this.stacks.get(count);

			if (!stackAt.isEmpty() && stackAt.getItem() == stack.getItem() && stackAt.getItemDamage() == stack.getItemDamage() && stackAt.getCount() < stackAt.getMaxStackSize()) {
				if (stackAt.getCount() + stack.getCount() <= stackAt.getMaxStackSize()) {
					if (doAdd) {
						stackAt.grow(stack.getCount());
						this.markDirty();
					}

					return EnumCargoLoadingState.SUCCESS;
				} else {
					// Part of the stack can fill this slot but there will be some left over
					int origSize = stackAt.getCount();
					int surplus = origSize + stack.getCount() - stackAt.getMaxStackSize();

					if (doAdd) {
						stackAt.setCount(stackAt.getMaxStackSize());
						this.markDirty();
					}

					stack.setCount(surplus);
					if (this.addCargo(stack, doAdd) == EnumCargoLoadingState.SUCCESS) {
						return EnumCargoLoadingState.SUCCESS;
					}

					stackAt.setCount(origSize);
					return EnumCargoLoadingState.FULL;
				}
			}
		}

		for (count = 0; count < this.stacks.size() - 2; count++) {
			ItemStack stackAt = this.stacks.get(count);

			if (stackAt.isEmpty()) {
				if (doAdd) {
					this.stacks.set(count, stack);
					this.markDirty();
				}

				return EnumCargoLoadingState.SUCCESS;
			}
		}
		return EnumCargoLoadingState.FULL;
	}

	@Override
	public RemovalResult removeCargo(boolean doRemove) {
		for (int i = 0; i < this.stacks.size() - 2; i++) {
			ItemStack stackAt = this.stacks.get(i);

			if (!stackAt.isEmpty()) {
				ItemStack resultStack = stackAt.copy();
				resultStack.setCount(1);

				if (doRemove) {
					stackAt.shrink(1);
				}

				if (doRemove) {
					this.markDirty();
				}
				return new RemovalResult(EnumCargoLoadingState.SUCCESS, resultStack);
			}
		}
		return new RemovalResult(EnumCargoLoadingState.EMPTY, ItemStack.EMPTY);
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if (this.stacks == null) {
			return ItemStack.EMPTY;
		}

		return this.stacks.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		ItemStack itemstack = ItemStackHelper.getAndSplit(this.stacks, index, count);

		if (!itemstack.isEmpty()) {
			this.markDirty();
		}

		return itemstack;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.stacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.stacks.set(index, stack);

		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}

		this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer entityplayer) {
		return !this.isDead && entityplayer.getDistanceSq(this) <= 64.0D;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

	@Override
	public void markDirty() {
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stacks) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void onPadDestroyed() {
		if (!this.isDead && this.launchPhase < EnumLaunchPhase.LAUNCHED.ordinal()) {
			this.dropShipAsItem();
			this.setDead();
		}
	}

	@Override
	public List<ItemStack> getItemsDropped(List<ItemStack> droppedItemList) {
		if (this.stacks != null) {
			for (final ItemStack item : this.stacks) {
				if (item != null && !item.isEmpty()) {
					droppedItemList.add(item);
				}
			}
		}

		return droppedItemList;
	}

	public boolean getWaitForPlayer() {
		return this.waitForPlayer;
	}

	public void setWaitForPlayer(boolean waitForPlayer) {
		this.waitForPlayer = waitForPlayer;
	}

	public static enum EnumAutoLaunch {
		CARGO_IS_UNLOADED(0, "cargo_unloaded"), CARGO_IS_FULL(1, "cargo_full"), ROCKET_IS_POWERED(2, "fully_powered"), INSTANT(3, "instant"), TIME_10_SECONDS(4, "ten_sec"), TIME_30_SECONDS(5, "thirty_sec"), TIME_1_MINUTE(6, "one_min"), REDSTONE_SIGNAL(
				7, "redstone_sig");

		private final int index;
		private String title;

		private EnumAutoLaunch(int index, String title) {
			this.index = index;
			this.title = title;
		}

		public int getIndex() {
			return this.index;
		}

		public String getTitle() {
			return TranslateUtilities.translate("gui.message." + this.title + ".name");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ITickable getSoundUpdater() {
		return this.rocketSoundUpdater;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ISound setSoundUpdater(EntityPlayerSP player) {
		// this.rocketSoundUpdater = new SoundUpdaterRocket(player, this);
		return (ISound) this.rocketSoundUpdater;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isInRangeToRender3d(double x, double y, double z) {
		double d0 = this.posX - x;
		double d1 = this.posY - y;
		double d2 = this.posZ - z;
		double d3 = d0 * d0 + d1 * d1 + d2 * d2;
		return d3 < Constants.RENDERDISTANCE_LONG;
	}

	@Override
	public boolean inFlight() {
		return this.getLaunched();
	}

	/*
	 * Power System Methods ------------------------------------------------------------------------------------------------------
	 */
	public float getCurrentPowerCapacity() {
		return this.currentPowerCapacity;
	}

	public void setCurrentPowerCapacity(float currentPowerCapacity) {
		this.currentPowerCapacity = currentPowerCapacity;
	}

	public float getPowerMaxCapacity() {
		return this.powerMaxCapacity;
	}

	public void setPowerMaxCapacity(float powerMaxCapacity) {
		this.powerMaxCapacity = powerMaxCapacity;
	}

	@Override
	public float addPower(float amount, boolean doDrain) {
		float beforePower = this.getCurrentPowerCapacity();
		if (this.getCurrentPowerCapacity() >= this.getPowerMaxCapacity())
			this.setCurrentPowerCapacity(this.getPowerMaxCapacity());
		else
			this.setCurrentPowerCapacity(this.getCurrentPowerCapacity() + amount);
		return this.getCurrentPowerCapacity() - beforePower;
	}

	@Override
	public float removePower(float amount) {
		float beforePower = this.getCurrentPowerCapacity();
		if ((this.getCurrentPowerCapacity() - amount) <= 0)
			this.setCurrentPowerCapacity(0);
		else
			this.setCurrentPowerCapacity(this.getCurrentPowerCapacity() - amount);
		return beforePower - this.getCurrentPowerCapacity();
	}
}

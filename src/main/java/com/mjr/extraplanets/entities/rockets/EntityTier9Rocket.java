package com.mjr.extraplanets.entities.rockets;

import java.util.List;

import micdoodle8.mods.galacticraft.api.prefab.entity.EntitySpaceshipBase;
import micdoodle8.mods.galacticraft.api.prefab.entity.EntityTieredRocket;
import micdoodle8.mods.galacticraft.api.tile.IFuelDock;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IOrbitDimension;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.event.EventLandingPadRemoval;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import com.mjr.extraplanets.blocks.BlockCustomLandingPadFull;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.tile.TileEntityTier3LandingPad;

public class EntityTier9Rocket extends EntityTieredRocket {
	public EntityTier9Rocket(World par1World) {
		super(par1World);
		this.setSize(4.8F, 11.0F);
		this.yOffset = 1.5F;
	}

	public EntityTier9Rocket(World par1World, double par2, double par4, double par6, EnumRocketType rocketType) {
		super(par1World, par2, par4, par6);
		this.rocketType = rocketType;
		this.cargoItems = new ItemStack[this.getSizeInventory()];
		this.setSize(4.8F, 11.0F);
		this.yOffset = 1.5F;
	}

	@Override
	public void landEntity(int x, int y, int z) {
		TileEntity tile = this.worldObj.getTileEntity(x, y, z);

		if (tile instanceof IFuelDock) {
			IFuelDock dock = (IFuelDock) tile;

			if (this.isDockValid(dock)) {
				if (!this.worldObj.isRemote) {
					// Drop any existing rocket on the landing pad
					if (dock.getDockedEntity() instanceof EntitySpaceshipBase && dock.getDockedEntity() != this) {
						((EntitySpaceshipBase) dock.getDockedEntity()).dropShipAsItem();
						((EntitySpaceshipBase) dock.getDockedEntity()).setDead();
					}

					this.setPad(dock);
				}

				this.onRocketLand(x + 1, y, z + 1);
			}
		}
	}

	@Override
	protected void onRocketLand(int x, int y, int z) {
		this.setPositionAndRotation(x + 0.5, y + 2.0D, z + 0.5, this.rotationYaw, 0.0F);
		this.stopRocketSound();
	}

	@Override
	public double getMountedYOffset() {
		return 3.2D;
	}

	@Override
	public float getRotateOffset() {
		return -0.6F;
	}

	@Override
	public double getOnPadYOffset() {
		return 1.5D;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition target) {
		return new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, this.rocketType.getIndex());
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		int i;

		if (this.timeUntilLaunch >= 100) {
			i = Math.abs(this.timeUntilLaunch / 100);
		} else {
			i = 1;
		}

		if ((this.getLaunched() || this.launchPhase == EnumLaunchPhase.IGNITED.ordinal() && this.rand.nextInt(i) == 0) && !ConfigManagerCore.disableSpaceshipParticles && this.hasValidFuel()) {
			if (this.worldObj.isRemote) {
				this.spawnParticles(this.getLaunched());
			}
		}

		if (this.launchPhase == EnumLaunchPhase.LAUNCHED.ordinal() && this.hasValidFuel()) {
			if (!this.landing) {
				double d = this.timeSinceLaunch / 150;

				d = Math.min(d, 1);

				if (d != 0.0) {
					this.motionY = -d * 1.5D * Math.cos((this.rotationPitch - 180) * Math.PI / 180.0D);
				}
			} else {
				this.motionY -= 0.008D;
			}

			double multiplier = 1.0D;

			if (this.worldObj.provider instanceof IGalacticraftWorldProvider) {
				multiplier = ((IGalacticraftWorldProvider) this.worldObj.provider).getFuelUsageMultiplier();

				if (multiplier <= 0) {
					multiplier = 1;
				}
			}

			if (this.timeSinceLaunch % MathHelper.floor_double(2 * (1 / multiplier)) == 0) {
				this.removeFuel(1);

				if (!this.hasValidFuel()) {
					this.stopRocketSound();
				}
			}
		} else if (!this.hasValidFuel() && this.getLaunched() && !this.worldObj.isRemote) {
			if (Math.abs(Math.sin(this.timeSinceLaunch / 1000)) / 10 != 0.0) {
				this.motionY -= Math.abs(Math.sin(this.timeSinceLaunch / 1000)) / 20;
			}
		}
	}

	@Override
	public void onTeleport(EntityPlayerMP player) {
		final EntityPlayerMP playerBase = PlayerUtil.getPlayerBaseServerFromPlayer(player, false);

		if (playerBase != null) {
			GCPlayerStats stats = GCPlayerStats.get(playerBase);

			if (this.cargoItems == null || this.cargoItems.length == 0) {
				stats.rocketStacks = new ItemStack[2];
			} else {
				stats.rocketStacks = this.cargoItems;
			}

			stats.rocketType = this.rocketType.getIndex();
			stats.rocketItem = ExtraPlanets_Items.tier9Rocket;
			stats.fuelLevel = this.fuelTank.getFluidAmount();
		}
	}

	protected void spawnParticles(boolean launched) {
		if (!this.isDead) {
			final double x1 = 2.9 * Math.cos(this.rotationYaw * Math.PI / 180.0D) * Math.sin(this.rotationPitch * Math.PI / 180.0D);
			final double z1 = 2.9 * Math.sin(this.rotationYaw * Math.PI / 180.0D) * Math.sin(this.rotationPitch * Math.PI / 180.0D);
			final double y1 = 2.9 * Math.cos((this.rotationPitch - 180) * Math.PI / 180.0D);

			final double y = this.prevPosY + (this.posY - this.prevPosY) + y1;
			final double x2 = this.posX + x1;
			final double z2 = this.posZ + z1;
			final double x3 = x2 + x1 / 2D;
			final double y3 = y + y1 / 2D;
			final double z3 = z2 + z1 / 2D;
			final Vector3 motionVec = new Vector3(x1, y1, z1);

			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x2 + 0.4 - this.rand.nextDouble() / 10, y, z2 + 0.4 - this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x2 - 0.4 + this.rand.nextDouble() / 10, y, z2 + 0.4 - this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x2 - 0.4 + this.rand.nextDouble() / 10, y, z2 - 0.4 + this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x2 + 0.4 - this.rand.nextDouble() / 10, y, z2 - 0.4 + this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x2, y, z2), motionVec, new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x2 + 0.4, y, z2), motionVec, new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x2 - 0.4, y, z2), motionVec, new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x2, y, z2 + 0.4D), motionVec, new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x2, y, z2 - 0.4D), motionVec, new Object[] { this.riddenByEntity });
			// Larger flameball for T2 - positioned behind the smaller one
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 + 0.2 - this.rand.nextDouble() / 8, y3 + 0.4, z3 + 0.2 - this.rand.nextDouble() / 8), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 - 0.2 + this.rand.nextDouble() / 8, y3 + 0.4, z3 + 0.2 - this.rand.nextDouble() / 8), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 - 0.2 + this.rand.nextDouble() / 8, y3 + 0.4, z3 - 0.2 + this.rand.nextDouble() / 8), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 + 0.2 - this.rand.nextDouble() / 8, y3 + 0.4, z3 - 0.2 + this.rand.nextDouble() / 8), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 + 0.2 - this.rand.nextDouble() / 8, y3 - 0.4, z3 + 0.2 - this.rand.nextDouble() / 8), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 - 0.2 + this.rand.nextDouble() / 8, y3 - 0.4, z3 + 0.2 - this.rand.nextDouble() / 8), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 - 0.2 + this.rand.nextDouble() / 8, y3 - 0.4, z3 - 0.2 + this.rand.nextDouble() / 8), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 + 0.2 - this.rand.nextDouble() / 8, y3 - 0.4, z3 - 0.2 + this.rand.nextDouble() / 8), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 + 0.7 - this.rand.nextDouble() / 10, y3, z3 + 0.7 - this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 - 0.7 + this.rand.nextDouble() / 10, y3, z3 + 0.7 - this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 - 0.7 + this.rand.nextDouble() / 10, y3, z3 - 0.7 + this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 + 0.7 - this.rand.nextDouble() / 10, y3, z3 - 0.7 + this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 + 0.7 - this.rand.nextDouble() / 10, y3, z3 - this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 - 0.7 + this.rand.nextDouble() / 10, y3, z3 - this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 + this.rand.nextDouble() / 10, y3, z3 + 0.7 + this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle(this.getLaunched() ? "launchFlameLaunched" : "launchFlameIdle", new Vector3(x3 - this.rand.nextDouble() / 10, y3, z3 - 0.7 + this.rand.nextDouble() / 10), motionVec,
					new Object[] { this.riddenByEntity });
			GalacticraftCore.proxy.spawnParticle("blueflame", new Vector3(x2 - 0.8, y, z2), motionVec, new Object[] {});
			GalacticraftCore.proxy.spawnParticle("blueflame", new Vector3(x2 + 0.8, y, z2), motionVec, new Object[] {});
			GalacticraftCore.proxy.spawnParticle("blueflame", new Vector3(x2, y, z2 - 0.8), motionVec, new Object[] {});
			GalacticraftCore.proxy.spawnParticle("blueflame", new Vector3(x2, y, z2 + 0.8), motionVec, new Object[] {});
		}
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return this.isDead ? false : par1EntityPlayer.getDistanceSqToEntity(this) <= 64.0D;
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
	}

	@Override
	public void onPadDestroyed() {
		if (!this.isDead && this.launchPhase != EnumLaunchPhase.LAUNCHED.ordinal()) {
			this.dropShipAsItem();
			this.setDead();
		}
	}

	@Override
	public boolean isDockValid(IFuelDock dock) {
		return dock instanceof TileEntityTier3LandingPad;
	}

	@Override
	public int getRocketTier() {
		return 9;
	}

	@Override
	public int getFuelTankCapacity() {
		return 4000;
	}

	@Override
	public int getPreLaunchWait() {
		return 400;
	}

	@Override
	public List<ItemStack> getItemsDropped(List<ItemStack> droppedItems) {
		super.getItemsDropped(droppedItems);
		ItemStack rocket = new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, this.rocketType.getIndex());
		rocket.setTagCompound(new NBTTagCompound());
		rocket.getTagCompound().setInteger("RocketFuel", this.fuelTank.getFluidAmount());
		droppedItems.add(rocket);
		return droppedItems;
	}

	@Override
	public float getCameraZoom() {
		return 15.0F;
	}

	@Override
	public boolean defaultThirdPerson() {
		return true;
	}

	@Override
	public void onLaunch() {
		if (!(this.worldObj.provider.dimensionId == GalacticraftCore.planetOverworld.getDimensionID() || this.worldObj.provider instanceof IGalacticraftWorldProvider)) {
			if (ConfigManagerCore.disableRocketLaunchAllNonGC) {
				this.cancelLaunch();
				return;
			}

			// No rocket flight in the Nether, the End etc
			for (int i = ConfigManagerCore.disableRocketLaunchDimensions.length - 1; i >= 0; i--) {
				if (ConfigManagerCore.disableRocketLaunchDimensions[i] == this.worldObj.provider.dimensionId) {
					this.cancelLaunch();
					return;
				}
			}

		}

		super.onLaunch();

		if (!this.worldObj.isRemote) {
			GCPlayerStats stats = null;

			if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayerMP) {
				stats = GCPlayerStats.get((EntityPlayerMP) this.riddenByEntity);

				if (!(this.worldObj.provider instanceof IOrbitDimension)) {
					stats.coordsTeleportedFromX = this.riddenByEntity.posX;
					stats.coordsTeleportedFromZ = this.riddenByEntity.posZ;
				}
			}

			int amountRemoved = 0;
			this.posX++;
			this.posZ++;

			PADSEARCH: for (int x = MathHelper.floor_double(this.posX) - 3; x <= MathHelper.floor_double(this.posX) + 3; x++) {
				for (int y = MathHelper.floor_double(this.posY) - 3; y <= MathHelper.floor_double(this.posY) + 1; y++) {
					for (int z = MathHelper.floor_double(this.posZ) - 3; z <= MathHelper.floor_double(this.posZ) + 3; z++) {
						final Block block = this.worldObj.getBlock(x, y, z);

						if (block != null && block instanceof BlockCustomLandingPadFull) {
							if (amountRemoved < 25) {
								EventLandingPadRemoval event = new EventLandingPadRemoval(this.worldObj, x, y, z);
								MinecraftForge.EVENT_BUS.post(event);

								if (event.allow) {
									this.worldObj.setBlockToAir(x, y, z);
									amountRemoved = 25;
								}
								break PADSEARCH;
							}
						}
					}
				}
			}

			// Set the player's launchpad item for return on landing - or null if launchpads not removed
			if (stats != null) {
				stats.launchpadStack = new ItemStack(ExtraPlanets_Blocks.advancedLaunchPad, 25, 1);
			}

			this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
		}
	}
}
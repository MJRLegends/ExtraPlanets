package com.mjr.extraplanets.entities.rockets;

import java.util.List;

import micdoodle8.mods.galacticraft.api.entity.IRocketType;
import micdoodle8.mods.galacticraft.api.prefab.entity.EntityTieredRocket;
import micdoodle8.mods.galacticraft.api.tile.IFuelDock;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IOrbitDimension;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.player.GCCapabilities;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.event.EventLandingPadRemoval;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import com.mjr.extraplanets.blocks.BlockCustomLandingPadFull;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.tile.blocks.TileEntityTier2LandingPad;

public class EntityTier8Rocket extends EntityTieredRocket {
	public EntityTier8Rocket(World world) {
		super(world);
		setSize(1.8F, 6.0F);
	}

	public EntityTier8Rocket(World world, double x, double y, double z, IRocketType.EnumRocketType type) {
		super(world, x, y, z);
		this.rocketType = type;
		this.cargoItems = new ItemStack[this.getSizeInventory()];
	}

	public EntityTier8Rocket(World world, double x, double y, double z, IRocketType.EnumRocketType type, ItemStack[] inv) {
		this(world, x, y, z, type);
		this.cargoItems = inv;
	}

	@Override
	public double getYOffset() {
		return 1.5F;
	}

	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET, 1, this.rocketType.getIndex());
	}

	@Override
	public double getMountedYOffset() {
		return 1.75D;
	}

	@Override
	public float getRotateOffset() {
		return -0.6F;
	}

	@Override
	public double getOnPadYOffset() {
		return 0.8D;
	}

	@Override
	public void onLaunch() {
		if (!(this.worldObj.provider.getDimension() == GalacticraftCore.planetOverworld.getDimensionID() || this.worldObj.provider instanceof IGalacticraftWorldProvider)) {
			if (ConfigManagerCore.disableRocketLaunchAllNonGC) {
				this.cancelLaunch();
				return;
			}

			// No rocket flight in the Nether, the End etc
			for (int i = ConfigManagerCore.disableRocketLaunchDimensions.length - 1; i >= 0; i--) {
				if (ConfigManagerCore.disableRocketLaunchDimensions[i] == this.worldObj.provider.getDimension()) {
					this.cancelLaunch();
					return;
				}
			}

		}

		super.onLaunch();

		if (!this.worldObj.isRemote) {
			GCPlayerStats stats = null;

			if (!this.getPassengers().isEmpty() && this.getPassengers().get(0) instanceof EntityPlayerMP) {
				EntityPlayerMP player = (EntityPlayerMP) this.getPassengers().get(0);
				stats = GCPlayerStats.get(player);

				if (!(this.worldObj.provider instanceof IOrbitDimension)) {
					stats.setCoordsTeleportedFromX(player.posX);
					stats.setCoordsTeleportedFromZ(player.posZ);
				}
			}

			int amountRemoved = 0;

			PADSEARCH: for (int x = MathHelper.floor_double(this.posX) - 1; x <= MathHelper.floor_double(this.posX) + 1; x++) {
				for (int y = MathHelper.floor_double(this.posY) - 3; y <= MathHelper.floor_double(this.posY) + 1; y++) {
					for (int z = MathHelper.floor_double(this.posZ) - 1; z <= MathHelper.floor_double(this.posZ) + 1; z++) {
						BlockPos pos = new BlockPos(x, y, z);
						final Block block = this.worldObj.getBlockState(pos).getBlock();

						if (block != null && block instanceof BlockCustomLandingPadFull) {
							if (amountRemoved < 9) {
								EventLandingPadRemoval event = new EventLandingPadRemoval(this.worldObj, pos);
								MinecraftForge.EVENT_BUS.post(event);

								if (event.allow) {
									this.worldObj.setBlockToAir(pos);
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
				stats.setLaunchpadStack(new ItemStack(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD, 25, 0));
			}

			this.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
		}
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

		if (this.launchPhase >= EnumLaunchPhase.LAUNCHED.ordinal() && this.hasValidFuel()) {
			if (this.launchPhase == EnumLaunchPhase.LAUNCHED.ordinal()) {
				double d = this.timeSinceLaunch / 150;

				d = Math.min(d, 1);

				if (d != 0.0) {
					this.motionY = -d * 2.5D * Math.cos((this.rotationPitch - 180) / 57.2957795D);
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
		EntityPlayerMP playerBase = PlayerUtil.getPlayerBaseServerFromPlayer(player, false);

		if (playerBase != null) {
			GCPlayerStats stats = playerBase.getCapability(GCCapabilities.GC_STATS_CAPABILITY, null);

			if (this.cargoItems == null || this.cargoItems.length == 0) {
				stats.setRocketStacks(new ItemStack[2]);
			} else {
				stats.setRocketStacks(this.cargoItems);
			}

			stats.setRocketType(this.rocketType.getIndex());
			stats.setRocketItem(ExtraPlanets_Items.TIER_8_ROCKET);
			stats.setFuelLevel(this.fuelTank.getFluidAmount());
		}
	}

	protected void spawnParticles(boolean launched) {
		if (!this.isDead) {
			double x1 = 3.2 * Math.cos(this.rotationYaw / 57.2957795D) * Math.sin(this.rotationPitch / 57.2957795D);
			double z1 = 3.2 * Math.sin(this.rotationYaw / 57.2957795D) * Math.sin(this.rotationPitch / 57.2957795D);
			double y1 = 3.2 * Math.cos((this.rotationPitch - 180) / 57.2957795D);
			if (this.launchPhase == EnumLaunchPhase.LANDING.ordinal() && this.targetVec != null) {
				double modifier = this.posY - this.targetVec.getY();
				modifier = Math.max(modifier, 1.0);
				x1 *= modifier / 60.0D;
				y1 *= modifier / 60.0D;
				z1 *= modifier / 60.0D;
			}

			final double y2 = this.prevPosY + (this.posY - this.prevPosY) + y1;

			final double x2 = this.posX + x1;
			final double z2 = this.posZ + z1;
			Vector3 motionVec = new Vector3(x1, y1, z1);
			Vector3 d1 = new Vector3(y1 * 0.1D, -x1 * 0.1D, z1 * 0.1D).rotate(315 - this.rotationYaw, motionVec);
			Vector3 d2 = new Vector3(x1 * 0.1D, -z1 * 0.1D, y1 * 0.1D).rotate(315 - this.rotationYaw, motionVec);
			Vector3 d3 = new Vector3(-y1 * 0.1D, x1 * 0.1D, z1 * 0.1D).rotate(315 - this.rotationYaw, motionVec);
			Vector3 d4 = new Vector3(x1 * 0.1D, z1 * 0.1D, -y1 * 0.1D).rotate(315 - this.rotationYaw, motionVec);
			Vector3 mv1 = motionVec.clone().translate(d1);
			Vector3 mv2 = motionVec.clone().translate(d2);
			Vector3 mv3 = motionVec.clone().translate(d3);
			Vector3 mv4 = motionVec.clone().translate(d4);
			// T3 - Four flameballs which spread
			makeFlame(x2 + d1.x, y2 + d1.y, z2 + d1.z, mv1, this.getLaunched());
			makeFlame(x2 + d2.x, y2 + d2.y, z2 + d2.z, mv2, this.getLaunched());
			makeFlame(x2 + d3.x, y2 + d3.y, z2 + d3.z, mv3, this.getLaunched());
			makeFlame(x2 + d4.x, y2 + d4.y, z2 + d4.z, mv4, this.getLaunched());
		}
	}

	private void makeFlame(double x2, double y2, double z2, Vector3 motionVec, boolean getLaunched) {
		EntityLivingBase riddenByEntity = this.getPassengers().isEmpty() || !(this.getPassengers().get(0) instanceof EntityLivingBase) ? null : (EntityLivingBase) this.getPassengers().get(0);

		if (getLaunched) {
			GalacticraftCore.proxy.spawnParticle("launchFlameLaunched", new Vector3(x2 + 0.4 - this.rand.nextDouble() / 10, y2, z2 + 0.4 - this.rand.nextDouble() / 10), motionVec, new Object[] { riddenByEntity });
			GalacticraftCore.proxy.spawnParticle("launchFlameLaunched", new Vector3(x2 - 0.4 + this.rand.nextDouble() / 10, y2, z2 + 0.4 - this.rand.nextDouble() / 10), motionVec, new Object[] { riddenByEntity });
			GalacticraftCore.proxy.spawnParticle("launchFlameLaunched", new Vector3(x2 - 0.4 + this.rand.nextDouble() / 10, y2, z2 - 0.4 + this.rand.nextDouble() / 10), motionVec, new Object[] { riddenByEntity });
			GalacticraftCore.proxy.spawnParticle("launchFlameLaunched", new Vector3(x2 + 0.4 - this.rand.nextDouble() / 10, y2, z2 - 0.4 + this.rand.nextDouble() / 10), motionVec, new Object[] { riddenByEntity });
			GalacticraftCore.proxy.spawnParticle("launchFlameLaunched", new Vector3(x2, y2, z2), motionVec, new Object[] { riddenByEntity });
			GalacticraftCore.proxy.spawnParticle("launchFlameLaunched", new Vector3(x2 + 0.4, y2, z2), motionVec, new Object[] { riddenByEntity });
			GalacticraftCore.proxy.spawnParticle("launchFlameLaunched", new Vector3(x2 - 0.4, y2, z2), motionVec, new Object[] { riddenByEntity });
			GalacticraftCore.proxy.spawnParticle("launchFlameLaunched", new Vector3(x2, y2, z2 + 0.4D), motionVec, new Object[] { riddenByEntity });
			GalacticraftCore.proxy.spawnParticle("launchFlameLaunched", new Vector3(x2, y2, z2 - 0.4D), motionVec, new Object[] { riddenByEntity });
			return;
		}

		double x1 = motionVec.x;
		double y1 = motionVec.y;
		double z1 = motionVec.z;
		GalacticraftCore.proxy.spawnParticle("launchFlameIdle", new Vector3(x2 + 0.4 - this.rand.nextDouble() / 10, y2, z2 + 0.4 - this.rand.nextDouble() / 10), new Vector3(x1 + 0.5D, y1 - 0.3D, z1 + 0.5D), new Object[] { riddenByEntity });
		GalacticraftCore.proxy.spawnParticle("launchFlameIdle", new Vector3(x2 - 0.4 + this.rand.nextDouble() / 10, y2, z2 + 0.4 - this.rand.nextDouble() / 10), new Vector3(x1 - 0.5D, y1 - 0.3D, z1 + 0.5D), new Object[] { riddenByEntity });
		GalacticraftCore.proxy.spawnParticle("launchFlameIdle", new Vector3(x2 - 0.4 + this.rand.nextDouble() / 10, y2, z2 - 0.4 + this.rand.nextDouble() / 10), new Vector3(x1 - 0.5D, y1 - 0.3D, z1 - 0.5D), new Object[] { riddenByEntity });
		GalacticraftCore.proxy.spawnParticle("launchFlameIdle", new Vector3(x2 + 0.4 - this.rand.nextDouble() / 10, y2, z2 - 0.4 + this.rand.nextDouble() / 10), new Vector3(x1 + 0.5D, y1 - 0.3D, z1 - 0.5D), new Object[] { riddenByEntity });
		GalacticraftCore.proxy.spawnParticle("launchFlameIdle", new Vector3(x2 + 0.4, y2, z2), new Vector3(x1 + 0.8D, y1 - 0.3D, z1), new Object[] { riddenByEntity });
		GalacticraftCore.proxy.spawnParticle("launchFlameIdle", new Vector3(x2 - 0.4, y2, z2), new Vector3(x1 - 0.8D, y1 - 0.3D, z1), new Object[] { riddenByEntity });
		GalacticraftCore.proxy.spawnParticle("launchFlameIdle", new Vector3(x2, y2, z2 + 0.4D), new Vector3(x1, y1 - 0.3D, z1 + 0.8D), new Object[] { riddenByEntity });
		GalacticraftCore.proxy.spawnParticle("launchFlameIdle", new Vector3(x2, y2, z2 - 0.4D), new Vector3(x1, y1 - 0.3D, z1 - 0.8D), new Object[] { riddenByEntity });
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return !this.isDead && par1EntityPlayer.getDistanceSqToEntity(this) <= 64.0D;
	}

	@Override
	public void onPadDestroyed() {
		if (!this.isDead && this.launchPhase != EnumLaunchPhase.LAUNCHED.ordinal()) {
			this.dropShipAsItem();
			this.setDead();
		}
	}

	@Override
	public int getRocketTier() {
		return 8;
	}

	@Override
	public int getFuelTankCapacity() {
		return 1500;
	}

	@Override
	public int getPreLaunchWait() {
		return 400;
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
	public List<ItemStack> getItemsDropped(List<ItemStack> droppedItems) {
		super.getItemsDropped(droppedItems);
		ItemStack rocket = new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET, 1, this.rocketType.getIndex());
		rocket.setTagCompound(new NBTTagCompound());
		rocket.getTagCompound().setInteger("RocketFuel", this.fuelTank.getFluidAmount());
		droppedItems.add(rocket);
		return droppedItems;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {

	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {

	}

	@Override
	public float getRenderOffsetY() {
		return 1.1F;
	}

	@Override
	public boolean isDockValid(IFuelDock dock) {
		return (dock instanceof TileEntityTier2LandingPad);
	}
	
	@Override
	public String getName() {
		return GCCoreUtil.translate("entity.extraplanets.EntityTier8Rocket.name");
	}
}

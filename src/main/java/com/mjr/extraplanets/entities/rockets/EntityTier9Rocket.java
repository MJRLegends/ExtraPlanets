package com.mjr.extraplanets.entities.rockets;

import java.util.List;

import micdoodle8.mods.galacticraft.api.prefab.entity.EntitySpaceshipBase;
import micdoodle8.mods.galacticraft.api.prefab.entity.EntityTieredRocket;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
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

				if (this.worldObj.provider instanceof WorldProviderSpace && !((WorldProviderSpace) this.worldObj.provider).hasAtmosphere()) {
					d = Math.min(d * 1.2, 1.8);
				} else {
					d = Math.min(d, 1.2);
				}

				if (d != 0.0) {
					this.motionY = -d * 2.0D * Math.cos((this.rotationPitch - 180) * Math.PI / 180.0D);
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

	protected void spawnParticles(boolean launched)
    {
        if (!this.isDead)
        {
            double x1 = 3.2 * Math.cos(this.rotationYaw / 57.2957795D) * Math.sin(this.rotationPitch / 57.2957795D);
            double z1 = 3.2 * Math.sin(this.rotationYaw / 57.2957795D) * Math.sin(this.rotationPitch / 57.2957795D);
            double y1 = 3.2 * Math.cos((this.rotationPitch - 180) / 57.2957795D);
            if (this.landing && this.targetVec != null)
            {
                double modifier = this.posY - this.targetVec.y;
                modifier = Math.max(modifier, 180.0);
                x1 *= modifier / 200.0D;
                y1 *= Math.min(modifier / 200.0D, 2.5D);
                z1 *= modifier / 200.0D;
            }

            final double y2 = this.prevPosY + (this.posY - this.prevPosY) + y1 - 0.75 * this.motionY - 0.3;

            final double x2 = this.posX + x1 + this.motionX;
            final double z2 = this.posZ + z1 + this.motionZ;
            Vector3 motionVec = new Vector3(x1 + this.motionX, y1 + this.motionY, z1 + this.motionZ);
            Vector3 d1 = new Vector3(y1 * 0.1D, -x1 * 0.1D, z1 * 0.1D).rotate(315 - this.rotationYaw, motionVec);
            Vector3 d2 = new Vector3(x1 * 0.1D, -z1 * 0.1D, y1 * 0.1D).rotate(315 - this.rotationYaw, motionVec);
            Vector3 d3 = new Vector3(-y1 * 0.1D, x1 * 0.1D, z1 * 0.1D).rotate(315 - this.rotationYaw, motionVec);
            Vector3 d4 = new Vector3(x1 * 0.1D, z1 * 0.1D, -y1 * 0.1D).rotate(315 - this.rotationYaw, motionVec);
            Vector3 mv1 = motionVec.clone().translate(d1);
            Vector3 mv2 = motionVec.clone().translate(d2);
            Vector3 mv3 = motionVec.clone().translate(d3);
            Vector3 mv4 = motionVec.clone().translate(d4);
            //T3 - Four flameballs which spread
            makeFlame(x2 + d1.x, y2 + d1.y, z2 + d1.z, mv1, this.getLaunched());
            makeFlame(x2 + d2.x, y2 + d2.y, z2 + d2.z, mv2, this.getLaunched());
            makeFlame(x2 + d3.x, y2 + d3.y, z2 + d3.z, mv3, this.getLaunched());
            makeFlame(x2 + d4.x, y2 + d4.y, z2 + d4.z, mv4, this.getLaunched());
        }
    }

    private void makeFlame(double x2, double y2, double z2, Vector3 motionVec, boolean getLaunched)
    {
        if (getLaunched)
        {
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
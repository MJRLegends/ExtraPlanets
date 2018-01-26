package com.mjr.extraplanets.entities.rockets;

import io.netty.buffer.ByteBuf;

import java.lang.reflect.Field;
import java.util.ArrayList;

import micdoodle8.mods.galacticraft.api.entity.ICameraZoomEntity;
import micdoodle8.mods.galacticraft.api.entity.IRocketType;
import micdoodle8.mods.galacticraft.api.entity.IWorldTransferCallback;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.network.PacketSimple;
import micdoodle8.mods.galacticraft.core.network.PacketSimple.EnumSimplePacket;
import micdoodle8.mods.galacticraft.core.util.GCLog;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.api.IPoweredDockable;
import com.mjr.extraplanets.network.PacketSimpleEP;

/**
 * Do not include this prefab class in your released mod download.
 */
public abstract class EntityElectricRocketBase extends EntityElectricAutoRocket implements IRocketType, IPoweredDockable, IWorldTransferCallback, ICameraZoomEntity {
	public EnumRocketType rocketType;
	public float rumble;
	public int launchCooldown;
	static Field marsConfigAllDimsAllowed;

	static {
		try {
			Class<?> marsConfig = Class.forName("micdoodle8.mods.galacticraft.planets.mars.ConfigManagerMars");
			marsConfigAllDimsAllowed = marsConfig.getField("launchControllerAllDims");
		} catch (Exception ignore) {
		}
	}

	public EntityElectricRocketBase(World par1World) {
		super(par1World);
		this.setSize(0.98F, 4F);
		// this.yOffset = this.height / 2.0F;
	}

	public EntityElectricRocketBase(World world, double posX, double posY, double posZ) {
		super(world, posX, posY, posZ);
	}

	public void igniteCheckingCooldown() {
		if (!this.worldObj.isRemote && this.launchCooldown <= 0) {
			this.ignite();
		}
	}

	@Override
	public void onUpdate() {
		if (this.getWaitForPlayer()) {
			if (this.riddenByEntity != null) {
				if (this.ticks >= 40) {
					if (!this.worldObj.isRemote) {
						Entity e = this.riddenByEntity;
						e.mountEntity(null);
						e.mountEntity(this);
						GCLog.debug("Remounting player in rocket.");
					}

					this.setWaitForPlayer(false);
					this.motionY = -0.5D;
				} else {
					this.motionX = this.motionY = this.motionZ = 0.0D;
					this.riddenByEntity.motionX = this.riddenByEntity.motionY = this.riddenByEntity.motionZ = 0;
				}
			} else {
				this.motionX = this.motionY = this.motionZ = 0.0D;
			}
		}

		super.onUpdate();

		if (!this.worldObj.isRemote) {
			if (this.launchCooldown > 0) {
				this.launchCooldown--;
			}
		}

		if (this.rumble > 0) {
			this.rumble--;
		} else if (this.rumble < 0) {
			this.rumble++;
		}

		if (this.riddenByEntity != null) {
			final double rumbleAmount = this.rumble / (double) (37 - 5 * Math.max(this.getRocketTier(), 5));
			this.riddenByEntity.posX += rumbleAmount;
			this.riddenByEntity.posZ += rumbleAmount;
		}

		if (this.launchPhase >= EnumLaunchPhase.IGNITED.ordinal()) {
			this.performHurtAnimation();

			this.rumble = (float) this.rand.nextInt(3) - 3;
		}

		if (!this.worldObj.isRemote) {
			this.lastLastMotionY = this.lastMotionY;
			this.lastMotionY = this.motionY;
		}
	}

	@Override
	public void decodePacketdata(ByteBuf buffer) {
		this.rocketType = EnumRocketType.values()[buffer.readInt()];
		super.decodePacketdata(buffer);

		if (buffer.readBoolean()) {
			this.posX = buffer.readDouble() / 8000.0D;
			this.posY = buffer.readDouble() / 8000.0D;
			this.posZ = buffer.readDouble() / 8000.0D;
		}
	}

	@Override
	public void getNetworkedData(ArrayList<Object> list) {
		if (this.worldObj.isRemote) {
			return;
		}
		list.add(this.rocketType != null ? this.rocketType.getIndex() : 0);
		super.getNetworkedData(list);

		boolean sendPosUpdates = this.ticks < 25 || this.launchPhase < EnumLaunchPhase.LAUNCHED.ordinal();
		list.add(sendPosUpdates);

		if (sendPosUpdates) {
			list.add(this.posX * 8000.0D);
			list.add(this.posY * 8000.0D);
			list.add(this.posZ * 8000.0D);
		}
	}

	@Override
	public void onReachAtmosphere() {
		// Not launch controlled
		if (!this.worldObj.isRemote) {
			if (this.riddenByEntity instanceof EntityPlayerMP) {
				EntityPlayerMP player = (EntityPlayerMP) this.riddenByEntity;

				this.onTeleport(player);
				GCPlayerStats stats = GCPlayerStats.get(player);
				WorldUtil.toCelestialSelection(player, stats, this.getRocketTier());
			}

			// Destroy any rocket which reached the top of the atmosphere and is not controlled by a Launch Controller
			this.setDead();
		}

		// Client side, non-launch controlled, do nothing - no reason why it can't continue flying until the GUICelestialSelection activates
	}

	@Override
	protected boolean shouldCancelExplosion() {
		return this.hasValidPower() && Math.abs(this.lastLastMotionY) < 4;
	}

	public void onTeleport(EntityPlayerMP player) {
	}

	@Override
	protected void onRocketLand(BlockPos pos) {
		super.onRocketLand(pos);
		this.launchCooldown = 40;
	}

	@Override
	public void onLaunch() {
		super.onLaunch();
	}

	@Override
	protected boolean shouldMoveClientSide() {
		return true;
	}

	@Override
	public boolean interactFirst(EntityPlayer par1EntityPlayer) {
		if (this.launchPhase >= EnumLaunchPhase.LAUNCHED.ordinal()) {
			return false;
		}

		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayerMP) {
			if (!this.worldObj.isRemote && this.riddenByEntity == par1EntityPlayer) {
				GalacticraftCore.packetPipeline.sendTo(new PacketSimple(EnumSimplePacket.C_RESET_THIRD_PERSON, this.worldObj.provider.getDimensionId(), new Object[] {}), (EntityPlayerMP) par1EntityPlayer);
				GCPlayerStats stats = GCPlayerStats.get(par1EntityPlayer);
				stats.setChatCooldown(0);
				// Prevent player being dropped from the top of the rocket...
				float heightBefore = this.height;
				this.height = this.height / 2.0F;
				par1EntityPlayer.mountEntity(null);
				this.height = heightBefore;
			}
			return true;
		} else if (par1EntityPlayer instanceof EntityPlayerMP) {
			if (!this.worldObj.isRemote) {
				ExtraPlanets.packetPipeline.sendTo(new PacketSimpleEP(com.mjr.extraplanets.network.PacketSimpleEP.EnumSimplePacket.C_DISPLAY_ROCKET_CONTROLS, this.worldObj.provider.getDimensionId(), new Object[] {}), (EntityPlayerMP) par1EntityPlayer);
				GCPlayerStats stats = GCPlayerStats.get(par1EntityPlayer);
				stats.setChatCooldown(0);
				par1EntityPlayer.mountEntity(this);
			}

			return true;
		}

		return false;
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt) {
		if (worldObj.isRemote)
			return;
		nbt.setInteger("Type", this.rocketType.getIndex());
		super.writeEntityToNBT(nbt);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt) {
		this.rocketType = EnumRocketType.values()[nbt.getInteger("Type")];
		super.readEntityFromNBT(nbt);
	}

	@Override
	public EnumRocketType getType() {
		return this.rocketType;
	}

	@Override
	public int getSizeInventory() {
		if (this.rocketType == null)
			return 2;
		return this.rocketType.getInventorySpace();
	}

	@Override
	public void onWorldTransferred(World world) {
		if (this.targetVec != null) {
			this.setPosition(this.targetVec.getX() + 0.5F, this.targetVec.getY() + 800, this.targetVec.getZ() + 0.5F);
			this.setLaunchPhase(EnumLaunchPhase.LANDING);
			this.setWaitForPlayer(true);
			this.motionX = this.motionY = this.motionZ = 0.0D;
		} else {
			this.setDead();
		}
	}

	@Override
	public float getRotateOffset() {
		return -1.5F;
	}

	@Override
	public boolean isPlayerRocket() {
		return true;
	}
}

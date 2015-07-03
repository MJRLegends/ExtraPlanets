package com.mjr.extraplanets.entities.bosses;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.IBoss;
import micdoodle8.mods.galacticraft.core.network.PacketSimple;
import micdoodle8.mods.galacticraft.core.network.PacketSimple.EnumSimplePacket;
import micdoodle8.mods.galacticraft.core.tile.TileEntityDungeonSpawner;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

import com.mjr.extraplanets.items.ExtraPlanetsItems;
import com.mjr.extraplanets.tile.TileEntityT6TreasureChest;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;

public class EntityEvolvedMagmaCubeBoss extends EntityMob implements IEntityBreathable, IBossDisplayData, IBoss {
    protected long ticks = 0;
    private TileEntityDungeonSpawner spawner;

    public Entity targetEntity;
    public int deathTicks = 0;

    public int entitiesWithin;
    public int entitiesWithinLast;

    private Vector3 roomCoords;
    private Vector3 roomSize;

    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    private int slimeJumpDelay;

    public EntityEvolvedMagmaCubeBoss(World par1World) {
	super(par1World);
	this.setSlimeSize(10);
	this.isImmuneToFire = true;
	this.tasks.addTask(1, new EntityAISwimming(this));
	this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
	this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	this.tasks.addTask(3, new EntityAILookIdle(this));
	this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }
    @Override
    protected void applyEntityAttributes() {
	super.applyEntityAttributes();
	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0F * ConfigManagerCore.dungeonBossHealthMod);
	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.05F);
    }

    public EntityEvolvedMagmaCubeBoss(World world, Vector3 vec) {
	this(world);
	this.setPosition(vec.x, vec.y, vec.z);
    }

    @Override
    public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
    }

    @Override
    public boolean isAIEnabled() {
	return true;
    }

    @Override
    public boolean canBePushed() {
	return false;
    }

    @Override
    protected String getLivingSound() {
	return null;
    }

    @Override
    protected String getHurtSound() {
	return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }

    @Override
    protected String getDeathSound() {
	return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onDeathUpdate() {
	++this.deathTicks;

	if (this.deathTicks >= 180 && this.deathTicks <= 200) {
	    final float f = (this.rand.nextFloat() - 0.5F) * 1.5F;
	    final float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F;
	    final float f2 = (this.rand.nextFloat() - 0.5F) * 1.5F;
	    this.worldObj.spawnParticle("hugeexplosion", this.posX + f, this.posY + 2.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
	}

	int i;
	int j;

	if (!this.worldObj.isRemote) {
	    if (this.deathTicks >= 180 && this.deathTicks % 5 == 0) {
		GalacticraftCore.packetPipeline.sendToAllAround(new PacketSimple(EnumSimplePacket.C_PLAY_SOUND_EXPLODE, new Object[] {}),
			new TargetPoint(this.worldObj.provider.dimensionId, this.posX, this.posY, this.posZ, 40.0D));
		// PacketDispatcher.sendPacketToAllAround(this.posX, this.posY,
		// this.posZ, 40.0, this.worldObj.provider.dimensionId,
		// PacketUtil.createPacket(GalacticraftCore.CHANNEL,
		// EnumPacketClient.PLAY_SOUND_EXPLODE, new Object[] { 0 }));
	    }

	    if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
		i = 30;

		while (i > 0) {
		    j = EntityXPOrb.getXPSplit(i);
		    i -= j;
		    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
		}
	    }

	    if (this.deathTicks == 1) {
		GalacticraftCore.packetPipeline.sendToAllAround(
			new PacketSimple(EnumSimplePacket.C_PLAY_SOUND_BOSS_DEATH, new Object[] {}), new TargetPoint(
				this.worldObj.provider.dimensionId, this.posX, this.posY, this.posZ, 40.0D));
		// PacketDispatcher.sendPacketToAllAround(this.posX, this.posY,
		// this.posZ, 40.0, this.worldObj.provider.dimensionId,
		// PacketUtil.createPacket(GalacticraftCore.CHANNEL,
		// EnumPacketClient.PLAY_SOUND_BOSS_DEATH, new Object[] { 0 }));
	    }
	}

	this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
	this.renderYawOffset = this.rotationYaw += 20.0F;

	if (this.deathTicks == 200 && !this.worldObj.isRemote) {
	    i = 20;

	    while (i > 0) {
		j = EntityXPOrb.getXPSplit(i);
		i -= j;
		this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
	    }

	    for (final TileEntity tile : (List<TileEntity>) this.worldObj.loadedTileEntityList) {
		if (tile instanceof TileEntityT6TreasureChest) {
		    final double d3 = tile.xCoord + 0.5D - this.posX;
		    final double d4 = tile.yCoord + 0.5D - this.posY;
		    final double d5 = tile.zCoord + 0.5D - this.posZ;
		    final double dSq = d3 * d3 + d4 * d4 + d5 * d5;
		    TileEntityT6TreasureChest chest = (TileEntityT6TreasureChest) tile;

		    if (dSq < 10000) {
			if (!chest.locked) {
			    chest.locked = true;
			}

			for (int k = 0; k < chest.getSizeInventory(); k++) {
			    chest.setInventorySlotContents(k, null);
			}

			ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);

			// Generate three times, since it's an extra extra
			// special chest
			WeightedRandomChestContent.generateChestContents(this.rand, info.getItems(this.rand), chest,
				info.getCount(this.rand));
			WeightedRandomChestContent.generateChestContents(this.rand, info.getItems(this.rand), chest,
				info.getCount(this.rand));
			WeightedRandomChestContent.generateChestContents(this.rand, info.getItems(this.rand), chest,
				info.getCount(this.rand));

			chest.setInventorySlotContents(this.rand.nextInt(chest.getSizeInventory()), this.getGuaranteedLoot(this.rand));

			break;
		    }
		}
	    }

	    this.entityDropItem(new ItemStack(ExtraPlanetsItems.T6key, 1, 0), 0.5F);

	    super.setDead();

	    if (this.spawner != null) {
		this.spawner.isBossDefeated = true;
		this.spawner.boss = null;
		this.spawner.spawned = false;
	    }
	}
    }

    @Override
    public void setDead() {
	if (this.spawner != null) {
	    this.spawner.isBossDefeated = false;
	    this.spawner.boss = null;
	    this.spawner.spawned = false;
	}

	super.setDead();
    }

    protected void setSlimeSize(int p_70799_1_)
    {
	this.setSize(0.6F * p_70799_1_, 0.6F * p_70799_1_);
	this.setPosition(this.posX, this.posY, this.posZ);
	this.experienceValue = p_70799_1_;
    }

    public int getSlimeSize() {
	return (int) (0.6F * 10);
    }

    @Override
    public void onLivingUpdate() {
	if (this.ticks >= Long.MAX_VALUE) {
	    this.ticks = 1;
	}

	this.ticks++;

	this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
	this.prevSquishFactor = this.squishFactor;
	boolean flag = this.onGround;
	int i;

	if (this.onGround && !flag) {
	    i = this.getSlimeSize();

	    for (int j = 0; j < i * 8; ++j) {
		float f = this.rand.nextFloat() * (float) Math.PI * 2.0F;
		float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
		float f2 = MathHelper.sin(f) * i * 0.5F * f1;
		float f3 = MathHelper.cos(f) * i * 0.5F * f1;
		this.worldObj.spawnParticle(this.getSlimeParticle(), this.posX + f2, this.boundingBox.minY, this.posZ
			+ f3, 0.0D, 0.0D, 0.0D);
	    }

	    if (this.makesSoundOnLand()) {
		this.playSound(this.getJumpSound(), this.getSoundVolume(),
			((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
	    }

	    this.squishAmount = -0.5F;
	} else if (!this.onGround && flag) {
	    this.squishAmount = 1.0F;
	}

	final EntityPlayer player = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 20.0);

	if (player != null && !player.equals(this.targetEntity)) {
	    if (this.getDistanceSqToEntity(player) < 400.0D) {
		this.getNavigator().getPathToEntityLiving(player);
		this.targetEntity = player;
	    }
	} else {
	    this.targetEntity = null;
	}

	new Vector3(this);

	if (this.roomCoords != null && this.roomSize != null) {
	    @SuppressWarnings("unchecked")
	    List<Entity> entitiesWithin = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(
		    this.roomCoords.intX() - 1, this.roomCoords.intY() - 1, this.roomCoords.intZ() - 1, this.roomCoords.intX()
		    + this.roomSize.intX(), this.roomCoords.intY() + this.roomSize.intY(),
		    this.roomCoords.intZ() + this.roomSize.intZ()));

	    this.entitiesWithin = entitiesWithin.size();

	    if (this.entitiesWithin == 0 && this.entitiesWithinLast != 0) {
		@SuppressWarnings("unchecked")
		List<EntityPlayer> entitiesWithin2 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(
			this.roomCoords.intX() - 11, this.roomCoords.intY() - 11, this.roomCoords.intZ() - 11, this.roomCoords.intX()
			+ this.roomSize.intX() + 10, this.roomCoords.intY() + this.roomSize.intY() + 10, this.roomCoords.intZ()
			+ this.roomSize.intZ() + 10));

		for (EntityPlayer p : entitiesWithin2) {
		    p.addChatMessage(new ChatComponentText(GCCoreUtil.translate("gui.skeletonBoss.message")));
		}

		this.setDead();

		if (this.spawner != null) {
		    this.spawner.playerCheated = true;
		}

		return;
	    }

	    this.entitiesWithinLast = this.entitiesWithin;
	}

	super.onLivingUpdate();
    }

    protected boolean makesSoundOnLand()
    {
	return this.getSlimeSize() > 2;
    }

    protected String getSlimeParticle() {
	return "slime";
    }

    protected String getJumpSound() {
	return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }

    @Override
    protected Item getDropItem() {
	return Items.arrow;
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
    }

    @Override
    public EntityItem entityDropItem(ItemStack par1ItemStack, float par2) {
	final EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY + par2, this.posZ, par1ItemStack);
	entityitem.motionY = -2.0D;
	entityitem.delayBeforeCanPickup = 10;
	if (this.captureDrops) {
	    this.capturedDrops.add(entityitem);
	} else {
	    this.worldObj.spawnEntityInWorld(entityitem);
	}
	return entityitem;
    }

    @Override
    protected void dropRareDrop(int par1) {
	if (par1 > 0) {
	    final ItemStack var2 = new ItemStack(Items.bow);
	    EnchantmentHelper.addRandomEnchantment(this.rand, var2, 5);
	    this.entityDropItem(var2, 0.0F);
	} else {
	    this.dropItem(Items.bow, 1);
	}
    }

    @Override
    public boolean canBreath() {
	return true;
    }

    public ItemStack getGuaranteedLoot(Random rand) {
	List<ItemStack> stackList = GalacticraftRegistry.getDungeonLoot(6);
	return stackList.get(rand.nextInt(stackList.size())).copy();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
	super.writeEntityToNBT(nbt);

	if (this.roomCoords != null) {
	    nbt.setDouble("roomCoordsX", this.roomCoords.x);
	    nbt.setDouble("roomCoordsY", this.roomCoords.y);
	    nbt.setDouble("roomCoordsZ", this.roomCoords.z);
	    nbt.setDouble("roomSizeX", this.roomSize.x);
	    nbt.setDouble("roomSizeY", this.roomSize.y);
	    nbt.setDouble("roomSizeZ", this.roomSize.z);
	}
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
	super.readEntityFromNBT(nbt);
	this.roomCoords = new Vector3();
	this.roomCoords.x = nbt.getDouble("roomCoordsX");
	this.roomCoords.y = nbt.getDouble("roomCoordsY");
	this.roomCoords.z = nbt.getDouble("roomCoordsZ");
	this.roomSize = new Vector3();
	this.roomSize.x = nbt.getDouble("roomSizeX");
	this.roomSize.y = nbt.getDouble("roomSizeY");
	this.roomSize.z = nbt.getDouble("roomSizeZ");
    }

    @Override
    public void setRoom(Vector3 roomCoords, Vector3 roomSize) {
	this.roomCoords = roomCoords;
	this.roomSize = roomSize;
    }

    @Override
    public void onBossSpawned(TileEntityDungeonSpawner spawner) {
	this.spawner = spawner;
    }
}

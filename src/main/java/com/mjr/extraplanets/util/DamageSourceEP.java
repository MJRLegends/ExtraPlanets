package com.mjr.extraplanets.util;

import net.minecraft.util.DamageSource;

public class DamageSourceEP extends DamageSource {
	public static final DamageSourceEP radiation = (DamageSourceEP) new DamageSourceEP("radiation").setDamageBypassesArmor();
	public static final DamageSourceEP pressure = (DamageSourceEP) new DamageSourceEP("pressure").setDamageBypassesArmor();
	public static final DamageSourceEP hypothermia = (DamageSourceEP) new DamageSourceEP("hypothermia").setDamageBypassesArmor();
	public static final DamageSourceEP magma = (DamageSourceEP) new DamageSourceEP("magma").setDamageBypassesArmor().setFireDamage();
	public static final DamageSourceEP radiationLiquid = (DamageSourceEP) new DamageSourceEP("radiationLiquid").setDamageBypassesArmor().setMagicDamage();
	public static final DamageSourceEP infection = (DamageSourceEP) new DamageSourceEP("infection").setDamageBypassesArmor().setMagicDamage();

	public DamageSourceEP(String damageType) {
		super(damageType);
	}
}
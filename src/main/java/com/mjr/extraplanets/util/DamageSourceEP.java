package com.mjr.extraplanets.util;

import net.minecraft.util.DamageSource;

public class DamageSourceEP extends DamageSource
{
    public static final DamageSourceEP radiation = (DamageSourceEP) new DamageSourceEP("radiation").setDamageBypassesArmor();
    public static final DamageSourceEP pressure = (DamageSourceEP) new DamageSourceEP("pressure").setDamageBypassesArmor();

    public DamageSourceEP(String damageType)
    {
        super(damageType);
    }
}
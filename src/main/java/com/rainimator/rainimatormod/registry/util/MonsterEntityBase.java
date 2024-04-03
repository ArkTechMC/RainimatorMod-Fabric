package com.rainimator.rainimatormod.registry.util;

import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class MonsterEntityBase extends HostileEntity {
    private final EntityGroup mobType;

    protected MonsterEntityBase(EntityType<? extends HostileEntity> p_33002_, World p_33003_, EntityGroup mobType) {
        super(p_33002_, p_33003_);
        this.mobType = mobType;
        this.setAiDisabled(false);
    }

    @Override
    public EntityGroup getGroup() {
        return this.mobType;
    }
}

package dev.rainimator.mod.item.sword;

import com.iafenvoy.mcrconvertlib.item.SwordItemBase;
import com.iafenvoy.mcrconvertlib.item.ToolMaterialUtil;
import com.iafenvoy.mcrconvertlib.misc.RandomHelper;
import dev.rainimator.mod.registry.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;

public class RedGoldDaggerItem extends SwordItemBase {
    public RedGoldDaggerItem() {
        super(ToolMaterialUtil.of(1000, 4.0F, 6.0F, 0, 3, ModItems.RUBY), 3, -2.0F, new Settings());
    }

    @Override
    public boolean postHit(ItemStack itemtack, LivingEntity entity, LivingEntity sourceentity) {
        boolean ret_val = super.postHit(itemtack, entity, sourceentity);
        if (entity instanceof MobEntity _entity)
            _entity.setTarget(sourceentity);
        if (Math.random() < 0.4D)
            entity.setOnFireFor(5);
        if (Math.random() < 0.2D)
            sourceentity.setHealth(sourceentity.getHealth() + RandomHelper.nextInt(1, 2));
        return ret_val;
    }
}

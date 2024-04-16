package com.rainimator.rainimatormod.item.armor;

import com.iafenvoy.mcrconvertlib.item.ItemBase;
import net.minecraft.item.Item;

public class KingNormalCrownItem extends ItemBase {
    public KingNormalCrownItem(Item.Settings properties) {
        super(p -> properties);
    }

    public static class Helmet extends KingNormalCrownItem {
        public Helmet() {
            super(new Settings());
        }
    }
}


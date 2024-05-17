package dev.rainimator.mod.compat;

public enum ElectricitySource {
    //使用Mana代替电力系统（默认）
    NONE,
    //使用内置电力系统
    INTERNAL,
    //自动检测，如无法找到其他提供的Mod则自动使用内置
    AUTO,
    //使用[TR]科技复兴的能量单位
    TR,
    //使用[AE2]应用能源的能量单位
    AE2
}

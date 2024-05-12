package com.rainimator.rainimatormod.item.block.entity;

import com.rainimator.rainimatormod.item.block.DarkObsidianBlock;
import com.rainimator.rainimatormod.registry.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

public class DarkObsidianBlockEntity extends BlockEntity {
    private RegistryKey<Biome> biome;

    public DarkObsidianBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DARK_OBSIDIAN_BLOCK, pos, state);
    }

    public RegistryKey<Biome> getBiome() {
        return this.biome;
    }

    public void setBiome(RegistryKey<Biome> biome) {
        this.biome = biome;
    }

    public void setBiome(ItemStack itemStack, RegistryEntry<Biome> current) {
        NbtCompound compound = itemStack.getOrCreateNbt();
        String name = compound.getString(DarkObsidianBlock.NBT_KEY);
        if (name.isBlank())
            this.setBiome(current.getKey().orElse(RegistryKey.of(RegistryKeys.BIOME, null)));
        else
            this.setBiome(RegistryKey.of(RegistryKeys.BIOME, new Identifier(name)));
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        String biomeKey = nbt.getString(DarkObsidianBlock.NBT_KEY);
        if (!biomeKey.isBlank())
            this.setBiome(RegistryKey.of(RegistryKeys.BIOME, new Identifier(biomeKey)));
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (this.biome != null)
            nbt.putString(DarkObsidianBlock.NBT_KEY, this.biome.getValue().toString());
    }
}

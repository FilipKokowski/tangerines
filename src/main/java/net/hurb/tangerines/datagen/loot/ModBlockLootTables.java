package net.hurb.tangerines.datagen.loot;

import net.hurb.tangerines.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Iterator;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider{
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate(){
        this.dropSelf(ModBlocks.ORANGEWOOD_LOG.get());
        this.dropSelf(ModBlocks.ORANGEWOOD_WOOD.get());
        this.dropSelf(ModBlocks.ORANGEWOOD_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_ORANGEWOOD_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ORANGEWOOD_LOG.get());

        this.dropSelf(ModBlocks.ORANGEWOOD_SAPLING.get());

        this.add(ModBlocks.ORANGEWOOD_LEAVES.get(),
                block -> createLeavesDrops(block, ModBlocks.ORANGEWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

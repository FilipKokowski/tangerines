package net.hurb.tangerines.datagen;

import net.hurb.tangerines.McMod;
import net.hurb.tangerines.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, McMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ORANGEWOOD_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ORANGEWOOD_LOG.get().asItem())
                .add(ModBlocks.ORANGEWOOD_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ORANGEWOOD_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.ORANGEWOOD_PLANKS.get().asItem());

    }
}

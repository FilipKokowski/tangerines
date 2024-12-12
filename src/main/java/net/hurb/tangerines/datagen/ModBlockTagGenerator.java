package net.hurb.tangerines.datagen;

import net.hurb.tangerines.McMod;
import net.hurb.tangerines.block.ModBlocks;
import net.hurb.tangerines.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, McMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.DROPS_TANGERINES)
                .add(ModBlocks.ORANGEWOOD_LEAVES.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ORANGEWOOD_LOG.get())
                .add(ModBlocks.STRIPPED_ORANGEWOOD_LOG.get())
                .add(ModBlocks.ORANGEWOOD_WOOD.get())
                .add(ModBlocks.STRIPPED_ORANGEWOOD_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.ORANGEWOOD_PLANKS.get());

    }
}

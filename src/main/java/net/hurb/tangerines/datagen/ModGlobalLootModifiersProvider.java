package net.hurb.tangerines.datagen;

import net.hurb.tangerines.McMod;
import net.hurb.tangerines.block.ModBlocks;
import net.hurb.tangerines.item.ModItems;
import net.hurb.tangerines.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, McMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("tangerine_from_orangewood_leaves", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ORANGEWOOD_LEAVES.get()).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.TANGERINE.get()));

        add("diamonds_from_dirt", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("blocks/dirt")).build()}, Items.DIAMOND));

    }
}

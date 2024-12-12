package net.hurb.tangerines.datagen;

import net.hurb.tangerines.McMod;
import net.hurb.tangerines.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, McMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.TANGERINE);
        simpleItem(ModItems.PEELED_TANGERINE);
        simpleItem(ModItems.TANGERINE_CAP);
        simpleItem(ModItems.TANGERINE_PEEL);
        simpleItem(ModItems.TANGERINE_PEEL_FABRIC);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(McMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}

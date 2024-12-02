package net.hurb.tangerine_expansion.custom_armor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.Minecraft;

public class CustomArmorItem extends ArmorItem {

    public CustomArmorItem(ArmorMaterial material, Type slot, Item.Properties properties) {
        super(material, slot, properties);
    }

    // Modify this method to use your TangerineCapModel
    public TangerineCapModel<LivingEntity> getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
        // Bake the layer of the armor model to create the correct model parts
        ModelPart part = Minecraft.getInstance().getEntityModels().bakeLayer(ModModelLayers.TANGERINE_CAP);

        // Return a new model with the baked part (the model needs to extend EntityModel<LivingEntity>)
        return new TangerineCapModel<>(part); // This model should now be an instance of a model that extends EntityModel
    }


    // Set the texture for the armor item
    public ResourceLocation getArmorTexture(ItemStack stack, LivingEntity entity, EquipmentSlot slot, String type) {
        // Correct the path to match the location of your texture
        return new ResourceLocation("tangerine_expansion", "textures/item/tangerine_cap_3d.png");
    }
}

package net.hurb.tangerine_expansion.item;

import net.hurb.tangerine_expansion.McMod;
import net.hurb.tangerine_expansion.custom_armor.CustomArmorItem;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
     public static final DeferredRegister<Item> ITEMS =
             DeferredRegister.create(ForgeRegistries.ITEMS, McMod.MOD_ID);

     public static final RegistryObject<Item> TANGERINE = ITEMS.register("tangerine",
             () -> new Item(new Item.Properties().food(ModFoods.TANGERINE)));

     public static final RegistryObject<Item> PEELED_TANGERINE = ITEMS.register("peeled_tangerine",
             () -> new Item(new Item.Properties().food(ModFoods.PEELED_TANGERINE)));

     public static final RegistryObject<Item> TANGERINE_PEEL = ITEMS.register("tangerine_peel",
             () -> new Item(new Item.Properties()));

     public static final RegistryObject<Item> TANGERINE_PEEL_FABRIC = ITEMS.register("tangerine_peel_fabric",
             () -> new Item(new Item.Properties()));

     /*public static final RegistryObject<Item> TANGERINE_CAP = ITEMS.register("tangerine_cap",
             () -> new ArmorItem(ModArmorMaterials.TANGERINE_PEEL, ArmorItem.Type.HELMET, new Item.Properties()));*/

     public static final RegistryObject<Item> TANGERINE_CAP = ITEMS.register("tangerine_cap",
             () -> new CustomArmorItem(ModArmorMaterials.TANGERINE_PEEL, ArmorItem.Type.HELMET, new Item.Properties()));

     public static void register(IEventBus eventBus) {
          ITEMS.register(eventBus);
     }
}

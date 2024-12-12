package net.hurb.tangerines.item;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.network.chat.Component;


public class OnFoodConsumed {
    @SubscribeEvent
    public static void onItemConsumed(LivingEntityUseItemEvent.Finish event){
        if(event.getEntity() instanceof Player player){
            if(event.getItem().getItem() == ModItems.TANGERINE.get()) {
                ItemStack tangerine_peel = new ItemStack(ModItems.TANGERINE_PEEL.get());

                if(!player.getInventory().add(tangerine_peel)) {
                    Level level = player.level();
                    ItemEntity itemEntity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), tangerine_peel);

                    level.addFreshEntity(itemEntity);
                }

            }


        }
    }
}

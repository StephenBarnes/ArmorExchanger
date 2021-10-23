package com.stebars.armorexchanger;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;


@EventBusSubscriber
public class ModEventHandler {

	@SubscribeEvent
	public static void headBump(final PlayerInteractEvent.RightClickItem event) {
		ItemStack stack = event.getItemStack();
		Item item = stack.getItem();
		if (!(item instanceof ArmorItem)) return;

		PlayerEntity player = event.getPlayer();

		EquipmentSlotType equipmentslottype = MobEntity.getEquipmentSlotForItem(stack);
		ItemStack worn = player.getItemBySlot(equipmentslottype);
		player.setItemSlot(equipmentslottype, stack.copy());
		stack.setCount(0);
		if (!worn.isEmpty()) {
			player.setItemInHand(event.getHand(), worn.copy());
		}
	}

}
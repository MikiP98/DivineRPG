package divinerpg.events;

import divinerpg.attachments.*;
import divinerpg.config.CommonConfig;
import divinerpg.registries.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.*;
import net.neoforged.neoforge.event.entity.EntityTravelToDimensionEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class VetheaInventorySwapEvent {
	public static final String OVERWORLD_INVENTORY = "drpg_regular_inventory", VETHEA_INVENTORY = "drpg_dream_inventory";
	@SubscribeEvent
	public void onClone(PlayerEvent.Clone event) {
		Player original = event.getOriginal(), clone = event.getEntity();
		AttachmentRegistry.GROGLIN_REPUTATION.clone(original, clone);
		AttachmentRegistry.GRUZZORLUG_REPUTATION.clone(original, clone);
		AttachmentRegistry.ICEIKA_MERCHANT_REPUTATION.clone(original, clone);
		AttachmentRegistry.DIMENSIONAL_INVENTORY.clone(original, clone);
		AttachmentRegistry.MAX_ARCANA.clone(original, clone);
	}
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onDeath(LivingDeathEvent event) {
		if(!event.isCanceled() && event.getEntity() instanceof Player player) {
			if(!CommonConfig.Values.SAFER_VETHEA) {
				DimensionalInventory d = AttachmentRegistry.DIMENSIONAL_INVENTORY.get(player);
				if(player.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
					if(player.level().dimension().equals(LevelRegistry.VETHEA)) d.saveInventory(player, VETHEA_INVENTORY);
					else d.saveInventory(player, OVERWORLD_INVENTORY);
				} else if(player.level().dimension().equals(LevelRegistry.VETHEA)) d.clearInventory(VETHEA_INVENTORY);
				else d.clearInventory(OVERWORLD_INVENTORY);
			} ArmorAbilitiesEvent.updateAbilities(player.level().dimension(), player);
		}
	}
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
		Player player = event.getEntity();
		if(!CommonConfig.Values.SAFER_VETHEA && !event.isEndConquered()) {
			DimensionalInventory d = AttachmentRegistry.DIMENSIONAL_INVENTORY.get(player);
			if(player.level().dimension().equals(LevelRegistry.VETHEA)) d.loadInventory(player, VETHEA_INVENTORY);
			else d.loadInventory(player, OVERWORLD_INVENTORY);
			player.inventoryMenu.broadcastChanges();
		} ArmorAbilitiesEvent.updateAbilities(player.level().dimension(), player);
	}
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onDimensionChange(EntityTravelToDimensionEvent event) {
		if(!event.isCanceled() && event.getEntity() instanceof Player player) {
			if(!CommonConfig.Values.SAFER_VETHEA) {
				boolean from = player.level().dimension().equals(LevelRegistry.VETHEA), to = event.getDimension().equals(LevelRegistry.VETHEA);
				DimensionalInventory d = AttachmentRegistry.DIMENSIONAL_INVENTORY.get(player);
				if(from ^ to) {
					if(from) {
						d.saveInventory(player, VETHEA_INVENTORY);
						d.loadInventory(player, OVERWORLD_INVENTORY);
					} else {
						d.saveInventory(player, OVERWORLD_INVENTORY);
						d.loadInventory(player, VETHEA_INVENTORY);
					} player.removeAllEffects();
				} else if(from && to) d.saveInventory(player, VETHEA_INVENTORY);
				else d.saveInventory(player,  OVERWORLD_INVENTORY);
			} ArmorAbilitiesEvent.updateAbilities(event.getDimension(), player);
		}
	}
}
package com.example.examplemod.client.renderer.armor;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.item.WolfArmorItem;
import com.example.examplemod.registry.ItemRegistry;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.base.GeoRenderer;

import java.util.Set;

/**
 * Example {@link GeoRenderer} for the {@link WolfArmorItem} example item
 */
public final class WolfArmorRenderer<R extends HumanoidRenderState & GeoRenderState> extends GeoArmorRenderer<WolfArmorItem, R> {
	public WolfArmorRenderer() {
		super(new DefaultedItemGeoModel<>(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "armor/wolf_armor")));
	}

	// Capture the worn stack data for later
	@Override
	public void addRenderData(WolfArmorItem animatable, RenderData relatedObject, R renderState) {
		Set<Item> wornArmor = new ObjectOpenHashSet<>(4);

		boolean fullSetEffect = false;

		if (!(relatedObject.entity() instanceof ArmorStand)) {
			for (EquipmentSlot slot : EquipmentSlot.values()) {
				if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)
					wornArmor.add(relatedObject.entity().getItemBySlot(slot).getItem());
			}

			fullSetEffect = wornArmor.containsAll(ObjectArrayList.of(
					ItemRegistry.WOLF_ARMOR_BOOTS.get(),
					ItemRegistry.WOLF_ARMOR_LEGGINGS.get(),
					ItemRegistry.WOLF_ARMOR_CHESTPLATE.get(),
					ItemRegistry.WOLF_ARMOR_HELMET.get()));
		}

		renderState.addGeckolibData(WolfArmorItem.HAS_FULL_SET_EFFECT, fullSetEffect);
	}
}

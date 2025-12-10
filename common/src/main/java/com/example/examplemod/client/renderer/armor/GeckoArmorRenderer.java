package com.example.examplemod.client.renderer.armor;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.item.GeckoArmorItem;
import com.example.examplemod.item.WolfArmorItem;
import com.example.examplemod.registry.ItemRegistry;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.base.GeoRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

import java.util.Set;

/**
 * Example {@link GeoRenderer} for the {@link WolfArmorItem} example item
 */
public final class GeckoArmorRenderer<R extends HumanoidRenderState & GeoRenderState> extends GeoArmorRenderer<GeckoArmorItem, R> {
	public GeckoArmorRenderer() {
		super(new DefaultedItemGeoModel<>(Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "armor/gecko_armor")));

		withRenderLayer(AutoGlowingGeoLayer::new);
	}

	// Capture the worn stack data for later
	@Override
    public void addRenderData(GeckoArmorItem animatable, RenderData relatedObject, R renderState, float partialTick) {
		Set<Item> wornArmor = new ObjectOpenHashSet<>(4);

		boolean fullSetEffect = false;

		if (!(relatedObject.entity() instanceof ArmorStand)) {
			for (EquipmentSlot slot : EquipmentSlot.values()) {
				if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)
					wornArmor.add(relatedObject.entity().getItemBySlot(slot).getItem());
			}

			fullSetEffect = wornArmor.containsAll(ObjectArrayList.of(
					ItemRegistry.GECKO_ARMOR_BOOTS.get(),
					ItemRegistry.GECKO_ARMOR_LEGGINGS.get(),
					ItemRegistry.GECKO_ARMOR_CHESTPLATE.get(),
					ItemRegistry.GECKO_ARMOR_HELMET.get()));
		}

		renderState.addGeckolibData(GeckoArmorItem.HAS_FULL_SET_EFFECT, fullSetEffect);
	}
}

package com.example.examplemod.client.renderer.armor;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.item.WolfArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;

/**
 * Example {@link GeoRenderer} for the {@link WolfArmorItem} example item
 */
public final class WolfArmorRenderer extends GeoArmorRenderer<WolfArmorItem> {
	public WolfArmorRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(ExampleModCommon.MODID, "armor/wolf_armor")));
	}
}

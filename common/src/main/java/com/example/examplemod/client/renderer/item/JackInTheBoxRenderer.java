package com.example.examplemod.client.renderer.item;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.item.JackInTheBoxItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/**
 * Example {@link software.bernie.geckolib.renderer.GeoItemRenderer} for {@link JackInTheBoxItem}
 */
public class JackInTheBoxRenderer extends GeoItemRenderer<JackInTheBoxItem> {
	public JackInTheBoxRenderer() {
		super(new DefaultedItemGeoModel<>(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "jack_in_the_box")));
	}
}

package com.example.examplemod.client.renderer.item;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.item.JackInTheBoxItem;
import net.minecraft.resources.Identifier;
import com.geckolib.model.DefaultedItemGeoModel;
import com.geckolib.renderer.GeoItemRenderer;

/**
 * Example {@link com.geckolib.renderer.GeoItemRenderer} for {@link JackInTheBoxItem}
 */
public class JackInTheBoxRenderer extends GeoItemRenderer<JackInTheBoxItem> {
	public JackInTheBoxRenderer() {
		super(new DefaultedItemGeoModel<>(Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "jack_in_the_box")));
	}
}

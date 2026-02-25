package com.geckolib.example.examplemod.client.renderer.item;

import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.item.JackInTheBoxItem;
import com.geckolib.model.DefaultedItemGeoModel;
import com.geckolib.renderer.GeoItemRenderer;
import net.minecraft.resources.Identifier;

/**
 * Example {@link com.geckolib.renderer.GeoItemRenderer} for {@link JackInTheBoxItem}
 */
public class JackInTheBoxRenderer extends GeoItemRenderer<JackInTheBoxItem> {
	public JackInTheBoxRenderer() {
		super(new DefaultedItemGeoModel<>(Identifier.fromNamespaceAndPath(ModConstants.MODID, "jack_in_the_box")));
	}
}

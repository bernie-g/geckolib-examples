package com.example.examplemod.client.model.block;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.block.entity.GeckoHabitatBlockEntity;
import com.example.examplemod.client.renderer.block.GeckoHabitatBlockRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link GeckoHabitatBlockEntity}
 * @see GeckoHabitatBlockEntity
 * @see GeckoHabitatBlockRenderer
 */
public class GeckoHabitatModel extends DefaultedBlockGeoModel<GeckoHabitatBlockEntity> {
	public GeckoHabitatModel() {
		super(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "gecko_habitat"));
	}

	@Override
	public RenderType getRenderType(GeckoHabitatBlockEntity animatable, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureResource(animatable));
	}
}
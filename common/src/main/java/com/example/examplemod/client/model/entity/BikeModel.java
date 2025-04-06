package com.example.examplemod.client.model.entity;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.client.renderer.entity.BikeRenderer;
import com.example.examplemod.entity.BikeEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Example {@link GeoModel} for the {@link BikeEntity}
 * @see BikeRenderer
 */
public class BikeModel extends DefaultedEntityGeoModel<BikeEntity> {
	public BikeModel() {
		super(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "bike"));
	}

	// We want this entity to have a translucent render
	@Override
	public @Nullable RenderType getRenderType(GeoRenderState renderState, ResourceLocation texture) {
		return RenderType.entityTranslucent(texture);
	}
}

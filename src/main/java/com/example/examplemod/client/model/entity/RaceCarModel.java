package com.example.examplemod.client.model.entity;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.client.renderer.entity.RaceCarRenderer;
import com.example.examplemod.entity.RaceCarEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link RaceCarEntity}
 * @see RaceCarRenderer
 */
public class RaceCarModel extends DefaultedEntityGeoModel<RaceCarEntity> {
	public RaceCarModel() {
		super(new ResourceLocation(ExampleMod.MODID, "race_car"));
	}

	// We want our model to render using the translucent render type
	@Override
	public RenderType getRenderType(RaceCarEntity animatable, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureResource(animatable));
	}
}
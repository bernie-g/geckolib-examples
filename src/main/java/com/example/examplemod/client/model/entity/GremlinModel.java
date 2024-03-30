package com.example.examplemod.client.model.entity;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.DynamicExampleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link DynamicExampleEntity}
 * @see software.bernie.example.client.renderer.entity.GremlinRenderer
 */
public class GremlinModel extends DefaultedEntityGeoModel<DynamicExampleEntity> {
	public GremlinModel() {
		super(new ResourceLocation(ExampleMod.MODID, "gremlin"));
	}
}
package com.geckolib.example.examplemod.client.model.entity;

import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.entity.DynamicExampleEntity;
import com.geckolib.model.DefaultedEntityGeoModel;
import com.geckolib.model.GeoModel;
import net.minecraft.resources.Identifier;

/**
 * Example {@link GeoModel} for the {@link DynamicExampleEntity}
 * @see com.geckolib.example.examplemod.client.renderer.entity.GremlinRenderer GremlinRenderer
 */
public class GremlinModel extends DefaultedEntityGeoModel<DynamicExampleEntity> {
	public GremlinModel() {
		super(Identifier.fromNamespaceAndPath(ModConstants.MODID, "gremlin"));
	}
}
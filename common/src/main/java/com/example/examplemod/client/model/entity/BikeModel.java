package com.example.examplemod.client.model.entity;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.client.renderer.entity.BikeRenderer;
import com.example.examplemod.entity.BikeEntity;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link BikeEntity}
 * @see BikeRenderer
 */
public class BikeModel extends DefaultedEntityGeoModel<BikeEntity> {
	public BikeModel() {
		super(Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "bike"));
	}
}

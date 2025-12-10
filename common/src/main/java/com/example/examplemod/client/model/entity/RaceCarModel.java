package com.example.examplemod.client.model.entity;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.client.renderer.entity.RaceCarRenderer;
import com.example.examplemod.entity.RaceCarEntity;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link RaceCarEntity}
 * @see RaceCarRenderer
 */
public class RaceCarModel extends DefaultedEntityGeoModel<RaceCarEntity> {
	public RaceCarModel() {
		super(Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "race_car"));
	}
}
package com.geckolib.example.examplemod.client.model.entity;

import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.client.renderer.entity.RaceCarRenderer;
import com.geckolib.example.examplemod.entity.RaceCarEntity;
import com.geckolib.model.DefaultedEntityGeoModel;
import com.geckolib.model.GeoModel;
import net.minecraft.resources.Identifier;

/**
 * Example {@link GeoModel} for the {@link RaceCarEntity}
 * @see RaceCarRenderer
 */
public class RaceCarModel extends DefaultedEntityGeoModel<RaceCarEntity> {
	public RaceCarModel() {
		super(Identifier.fromNamespaceAndPath(ModConstants.MODID, "race_car"));
	}
}
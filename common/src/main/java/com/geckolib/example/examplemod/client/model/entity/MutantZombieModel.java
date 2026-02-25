package com.geckolib.example.examplemod.client.model.entity;

import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.client.renderer.entity.MutantZombieRenderer;
import com.geckolib.example.examplemod.entity.DynamicExampleEntity;
import com.geckolib.model.DefaultedEntityGeoModel;
import com.geckolib.model.GeoModel;
import net.minecraft.resources.Identifier;

/**
 * Example {@link GeoModel} for the {@link DynamicExampleEntity}
 * @see MutantZombieRenderer
 */
public class MutantZombieModel extends DefaultedEntityGeoModel<DynamicExampleEntity> {
	public MutantZombieModel() {
		super(Identifier.fromNamespaceAndPath(ModConstants.MODID, "mutant_zombie"));
	}
}
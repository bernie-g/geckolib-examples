package com.example.examplemod.client.model.entity;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.client.renderer.entity.ParasiteRenderer;
import com.example.examplemod.entity.ParasiteEntity;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link ParasiteEntity}
 * @see ParasiteRenderer
 */
public class ParasiteModel extends DefaultedEntityGeoModel<ParasiteEntity> {
	public ParasiteModel() {
		super(Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "parasite"));
	}
}
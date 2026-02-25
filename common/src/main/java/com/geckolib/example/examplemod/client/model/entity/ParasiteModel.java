package com.geckolib.example.examplemod.client.model.entity;

import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.client.renderer.entity.ParasiteRenderer;
import com.geckolib.example.examplemod.entity.ParasiteEntity;
import com.geckolib.model.DefaultedEntityGeoModel;
import com.geckolib.model.GeoModel;
import net.minecraft.resources.Identifier;

/**
 * Example {@link GeoModel} for the {@link ParasiteEntity}
 * @see ParasiteRenderer
 */
public class ParasiteModel extends DefaultedEntityGeoModel<ParasiteEntity> {
	public ParasiteModel() {
		super(Identifier.fromNamespaceAndPath(ModConstants.MODID, "parasite"));
	}
}
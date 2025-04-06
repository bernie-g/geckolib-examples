package com.example.examplemod.client.model.entity;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.client.renderer.entity.MutantZombieRenderer;
import com.example.examplemod.entity.DynamicExampleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Example {@link GeoModel} for the {@link DynamicExampleEntity}
 * @see MutantZombieRenderer
 */
public class MutantZombieModel extends DefaultedEntityGeoModel<DynamicExampleEntity> {
	public MutantZombieModel() {
		super(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "mutant_zombie"));
	}

	@Override
	public void addAdditionalStateData(DynamicExampleEntity animatable, GeoRenderState renderState) {
		renderState.addGeckolibData(DynamicExampleEntity.MAINHAND_ITEM, animatable.getMainHandItem());
		renderState.addGeckolibData(DynamicExampleEntity.OFFHAND_ITEM, animatable.getOffhandItem());
		renderState.addGeckolibData(DynamicExampleEntity.LEFT_HANDED, animatable.isLeftHanded());
	}
}
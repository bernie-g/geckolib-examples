package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.client.model.entity.RaceCarModel;
import com.example.examplemod.entity.RaceCarEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.base.GeoRenderer;

/**
 * Example {@link GeoRenderer} implementation of an entity
 * @see RaceCarModel
 * @see RaceCarEntity
 */
public class RaceCarRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<RaceCarEntity, R> {
	public RaceCarRenderer(EntityRendererProvider.Context context) {
		super(context, new RaceCarModel());
	}
}
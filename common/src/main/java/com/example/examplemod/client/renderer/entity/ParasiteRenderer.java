package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.client.model.entity.ParasiteModel;
import com.example.examplemod.entity.ParasiteEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Example {@link GeoEntityRenderer} implementation of an entity
 * @see ParasiteModel
 * @see ParasiteEntity
 */
public class ParasiteRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<ParasiteEntity, R> {
	public ParasiteRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ParasiteModel());
	}
}

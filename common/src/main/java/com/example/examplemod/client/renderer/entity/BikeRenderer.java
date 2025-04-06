package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.client.model.entity.BikeModel;
import com.example.examplemod.entity.BikeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.base.GeoRenderer;

/**
 * Example {@link GeoRenderer} for {@link BikeEntity}
 * @see BikeModel
 */
public class BikeRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<BikeEntity, R> {
	public BikeRenderer(EntityRendererProvider.Context context) {
		super(context, new BikeModel());
	}
}

package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.client.model.entity.FakeGlassModel;
import com.example.examplemod.entity.FakeGlassEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.layer.CustomBoneTextureGeoLayer;

/**
 * Example multi-layered {@link GeoEntityRenderer} implementation that handles per-bone texturing
 * @see FakeGlassEntity
 * @see FakeGlassModel
 */
public class FakeGlassRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<FakeGlassEntity, R> {
	private static final Identifier WHITE_STAINED_GLASS_TEXTURE =
			Identifier.withDefaultNamespace("textures/block/white_stained_glass.png");

	public FakeGlassRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FakeGlassModel());

		withRenderLayer(new CustomBoneTextureGeoLayer<>(this, "outer_glass", WHITE_STAINED_GLASS_TEXTURE) {
			@Override
			protected RenderType getRenderType(R renderState, Identifier texture) {
				return RenderTypes.entityTranslucent(texture);
			}
		});
	}
}
package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.client.model.entity.FakeGlassModel;
import com.example.examplemod.entity.FakeGlassEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

/**
 * Example multi-layered {@link GeoEntityRenderer} implementation that handles per-bone texturing
 * @see FakeGlassEntity
 * @see FakeGlassModel
 */
public class FakeGlassRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<FakeGlassEntity, R> {
	private static final ResourceLocation WHITE_STAINED_GLASS_TEXTURE =
			ResourceLocation.withDefaultNamespace("textures/block/white_stained_glass.png");

	public FakeGlassRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FakeGlassModel());

		addRenderLayer(new GeoRenderLayer<>(this) {
			@Override
			public void preRender(R renderState, PoseStack poseStack, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, int packedOverlay, int renderColor) {
				bakedModel.getBone("outer_glass").ifPresent(bone -> bone.setHidden(true));
			}

			@Override
			public void render(R renderState, PoseStack poseStack, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, int packedOverlay, int renderColor) {
				renderType = RenderType.entityTranslucent(WHITE_STAINED_GLASS_TEXTURE);

				bakedModel.getBone("inner_cube").ifPresent(bone -> bone.setHidden(true));
				bakedModel.getBone("outer_glass").ifPresent(bone -> bone.setHidden(false));
				getRenderer().reRender(renderState, poseStack, bakedModel, bufferSource, renderType, bufferSource.getBuffer(renderType), 15728640, packedOverlay, renderColor);
				bakedModel.getBone("inner_cube").ifPresent(bone -> bone.setHidden(false));
			}
		});
	}
}
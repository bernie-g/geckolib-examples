package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.client.model.entity.ReplacedCreeperModel;
import com.example.examplemod.entity.ReplacedCreeperEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Creeper;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

/**
 * Example replacement renderer for a {@link Creeper}.<br>
 * This functionally replaces the model and animations of an existing entity without needing to replace the entity entirely
 * @see GeoReplacedEntityRenderer
 * @see ReplacedCreeperEntity
 */
public class ReplacedCreeperRenderer extends GeoReplacedEntityRenderer<Creeper, ReplacedCreeperEntity> {
	public ReplacedCreeperRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ReplacedCreeperModel(), new ReplacedCreeperEntity());
	}

	@Override
	public void preRender(PoseStack poseStack, ReplacedCreeperEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
		super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);

		float swellFactor = this.currentEntity.getSwelling(partialTick);
		float swellMod = 1 + Mth.sin(swellFactor * 100f) * swellFactor * 0.01f;
		swellFactor = (float)Math.pow(Mth.clamp(swellFactor, 0f, 1f), 3);
		float horizontalSwell = (1 + swellFactor * 0.4f) * swellMod;
		float verticalSwell = (1 + swellFactor * 0.1f) / swellMod;

		poseStack.scale(horizontalSwell, verticalSwell, horizontalSwell);
	}

	@Override
	public int getPackedOverlay(ReplacedCreeperEntity animatable, float u, float partialTick) {
		return super.getPackedOverlay(animatable, getSwellOverlay(this.currentEntity, u), partialTick);
	}

	protected float getSwellOverlay(Creeper entity, float u) {
		float swell = entity.getSwelling(u);

		return (int) (swell * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(swell, 0.5F, 1.0F);
	}
}

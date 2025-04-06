package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.client.model.entity.ReplacedCreeperModel;
import com.example.examplemod.entity.ReplacedCreeperEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.CreeperRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Creeper;
import org.jetbrains.annotations.ApiStatus;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Example replacement renderer for a {@link Creeper}.<br>
 * This functionally replaces the model and animations of an existing entity without needing to replace the entity entirely
 * @see GeoReplacedEntityRenderer
 * @see ReplacedCreeperEntity
 */
public class ReplacedCreeperRenderer<R extends CreeperRenderState & GeoRenderState> extends GeoReplacedEntityRenderer<ReplacedCreeperEntity, Creeper, R> {
	public ReplacedCreeperRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ReplacedCreeperModel(), new ReplacedCreeperEntity());
	}

	@Override
	public void scaleModelForRender(R renderState, float widthScale, float heightScale, PoseStack poseStack, BakedGeoModel model, boolean isReRender) {
		super.scaleModelForRender(renderState, widthScale, heightScale, poseStack, model, isReRender);

		float swellFactor = renderState.swelling;
		float swellMod = 1 + Mth.sin(swellFactor * 100f) * swellFactor * 0.01f;
		swellFactor = (float)Math.pow(Mth.clamp(swellFactor, 0f, 1f), 3);
		float horizontalSwell = (1 + swellFactor * 0.4f) * swellMod;
		float verticalSwell = (1 + swellFactor * 0.1f) / swellMod;

		poseStack.scale(horizontalSwell, verticalSwell, horizontalSwell);
	}

	@Override
	public int getPackedOverlay(ReplacedCreeperEntity animatable, Creeper replacedEntity, float u, float partialTick) {
		return super.getPackedOverlay(animatable, replacedEntity, getSwellOverlay(replacedEntity, u), partialTick);
	}

	protected float getSwellOverlay(Creeper entity, float u) {
		float swell = entity.getSwelling(u);

		return (int) (swell * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(swell, 0.5F, 1.0F);
	}

	@Override
	protected R createBaseRenderState(Creeper entity) {
		return (R)new CreeperRenderState();
	}

	@ApiStatus.Internal
	@Override
	public void extractRenderState(Creeper entity, R renderState, float partialTick) {
		super.extractRenderState(entity, renderState, partialTick);

		renderState.swelling = entity.getSwelling(partialTick);
		renderState.isPowered = entity.isPowered();
	}
}

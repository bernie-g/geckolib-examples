package com.geckolib.example.examplemod.client.renderer.entity;

import com.geckolib.example.examplemod.client.model.entity.ReplacedCreeperModel;
import com.geckolib.example.examplemod.entity.ReplacedCreeperEntity;
import com.geckolib.renderer.GeoReplacedEntityRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.base.RenderPassInfo;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.CreeperRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Creeper;
import org.jetbrains.annotations.ApiStatus;

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
    public void scaleModelForRender(RenderPassInfo<R> renderPassInfo, float widthScale, float heightScale) {
        super.scaleModelForRender(renderPassInfo, widthScale, heightScale);

        float swellFactor = renderPassInfo.renderState().swelling;
        float swellMod = 1 + Mth.sin(swellFactor * 100f) * swellFactor * 0.01f;
        swellFactor = (float)Math.pow(Mth.clamp(swellFactor, 0f, 1f), 3);
        float horizontalSwell = (1 + swellFactor * 0.4f) * swellMod;
        float verticalSwell = (1 + swellFactor * 0.1f) / swellMod;

        renderPassInfo.poseStack().scale(horizontalSwell, verticalSwell, horizontalSwell);
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
    public R createRenderState(ReplacedCreeperEntity animatable, Creeper relatedObject) {
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

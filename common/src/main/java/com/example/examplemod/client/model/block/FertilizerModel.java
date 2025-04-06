package com.example.examplemod.client.model.block;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.block.entity.FertilizerBlockEntity;
import com.example.examplemod.client.renderer.block.FertilizerBlockRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Example {@link GeoModel} for the {@link FertilizerBlockEntity}
 * @see FertilizerBlockEntity
 * @see FertilizerBlockRenderer
 */
public class FertilizerModel extends DefaultedBlockGeoModel<FertilizerBlockEntity> {
	private final ResourceLocation BOTARIUM_MODEL = buildFormattedModelPath(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "botarium"));
	private final ResourceLocation BOTARIUM_TEXTURE = buildFormattedTexturePath(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "botarium"));
	private final ResourceLocation BOTARIUM_ANIMATIONS = buildFormattedAnimationPath(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "botarium"));

	public FertilizerModel() {
		super(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "fertilizer"));
	}

	// We add the `examplemod_is_raining` DataTicket so it can be used later
	@Override
	public void addAdditionalStateData(FertilizerBlockEntity animatable, GeoRenderState renderState) {
		renderState.addGeckolibData(FertilizerBlockEntity.IS_RAINING, animatable.getLevel().isRaining());
	}

	/**
	 * Return the fertilizer animation path if it's raining, or the botarium animation path if not.
	 */
	@Override
	public ResourceLocation getAnimationResource(FertilizerBlockEntity animatable) {
		if (animatable.getLevel().isRaining()) {
			return super.getAnimationResource(animatable);
		}
		else {
			return BOTARIUM_ANIMATIONS;
		}
	}

	/**
	 * Return the fertilizer model path if it's raining, or the botarium model path if not.
	 */
	@Override
	public ResourceLocation getModelResource(GeoRenderState renderState) {
		if (renderState.getGeckolibData(FertilizerBlockEntity.IS_RAINING)) {
			return super.getModelResource(renderState);
		}
		else {
			return BOTARIUM_MODEL;
		}
	}

	/**
	 * Return the fertilizer texture path if it's raining, or the botarium texture path if not.
	 */
	@Override
	public ResourceLocation getTextureResource(GeoRenderState renderState) {
		if (renderState.getGeckolibData(FertilizerBlockEntity.IS_RAINING)) {
			return super.getTextureResource(renderState);
		}
		else {
			return BOTARIUM_TEXTURE;
		}
	}

	@Override
	public @Nullable RenderType getRenderType(GeoRenderState renderState, ResourceLocation texture) {
		return RenderType.entityTranslucent(texture);
	}
}
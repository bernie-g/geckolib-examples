package com.example.examplemod.client.model.block;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.block.entity.FertilizerBlockEntity;
import com.example.examplemod.client.renderer.block.FertilizerBlockRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link FertilizerBlockEntity}
 * @see FertilizerBlockEntity
 * @see FertilizerBlockRenderer
 */
public class FertilizerModel extends DefaultedBlockGeoModel<FertilizerBlockEntity> {
	private final ResourceLocation BOTARIUM_MODEL = buildFormattedModelPath(new ResourceLocation(ExampleModCommon.MODID, "botarium"));
	private final ResourceLocation BOTARIUM_TEXTURE = buildFormattedTexturePath(new ResourceLocation(ExampleModCommon.MODID, "botarium"));
	private final ResourceLocation BOTARIUM_ANIMATIONS = buildFormattedAnimationPath(new ResourceLocation(ExampleModCommon.MODID, "botarium"));

	public FertilizerModel() {
		super(new ResourceLocation(ExampleModCommon.MODID, "fertilizer"));
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
	public ResourceLocation getModelResource(FertilizerBlockEntity animatable) {
		if (animatable.getLevel().isRaining()) {
			return super.getModelResource(animatable);
		}
		else {
			return BOTARIUM_MODEL;
		}
	}

	/**
	 * Return the fertilizer texture path if it's raining, or the botarium texture path if not.
	 */
	@Override
	public ResourceLocation getTextureResource(FertilizerBlockEntity animatable) {
		if (animatable.getLevel().isRaining()) {
			return super.getTextureResource(animatable);
		}
		else {
			return BOTARIUM_TEXTURE;
		}
	}

	@Override
	public RenderType getRenderType(FertilizerBlockEntity animatable, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureResource(animatable));
	}
}
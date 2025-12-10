package com.example.examplemod.client.model.block;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.block.entity.FertilizerBlockEntity;
import com.example.examplemod.client.renderer.block.FertilizerBlockRenderer;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Example {@link GeoModel} for the {@link FertilizerBlockEntity}
 * @see FertilizerBlockEntity
 * @see FertilizerBlockRenderer
 */
public class FertilizerModel extends DefaultedBlockGeoModel<FertilizerBlockEntity> {
	private final Identifier BOTARIUM_MODEL = buildFormattedModelPath(Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "botarium"));
	private final Identifier BOTARIUM_TEXTURE = buildFormattedTexturePath(Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "botarium"));
	private final Identifier BOTARIUM_ANIMATIONS = buildFormattedAnimationPath(Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "botarium"));

	public FertilizerModel() {
		super(Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "fertilizer"));
	}

	// We add the `examplemod_is_raining` DataTicket so it can be used later
	@Override
	public void addAdditionalStateData(FertilizerBlockEntity animatable, Object relatedObject, GeoRenderState renderState) {
		renderState.addGeckolibData(FertilizerBlockEntity.IS_RAINING, animatable.getLevel().isRaining());
	}

	/**
	 * Return the fertilizer animation path if it's raining, or the botarium animation path if not.
	 */
	@Override
	public Identifier getAnimationResource(FertilizerBlockEntity animatable) {
		if (animatable.getLevel().isRaining())
			return super.getAnimationResource(animatable);

        return BOTARIUM_ANIMATIONS;
	}

	/**
	 * Return the fertilizer model path if it's raining, or the botarium model path if not.
	 */
	@Override
	public Identifier getModelResource(GeoRenderState renderState) {
		if (renderState.getGeckolibData(FertilizerBlockEntity.IS_RAINING))
			return super.getModelResource(renderState);

        return BOTARIUM_MODEL;
	}

	/**
	 * Return the fertilizer texture path if it's raining, or the botarium texture path if not.
	 */
	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		if (renderState.getGeckolibData(FertilizerBlockEntity.IS_RAINING))
			return super.getTextureResource(renderState);

        return BOTARIUM_TEXTURE;
	}
}
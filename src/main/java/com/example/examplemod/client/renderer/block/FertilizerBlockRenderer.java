package com.example.examplemod.client.renderer.block;

import com.example.examplemod.block.entity.FertilizerBlockEntity;
import com.example.examplemod.client.model.block.FertilizerModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/**
 * Example {@link net.minecraft.world.level.block.entity.BlockEntity} renderer for {@link FertilizerBlockEntity}
 * @see FertilizerModel
 * @see FertilizerBlockEntity
 */
public class FertilizerBlockRenderer extends GeoBlockRenderer<FertilizerBlockEntity> {
	public FertilizerBlockRenderer() {
		super(new FertilizerModel());
	}
}

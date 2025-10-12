package com.example.examplemod.client.renderer.block;

import com.example.examplemod.block.entity.FertilizerBlockEntity;
import com.example.examplemod.client.model.block.FertilizerModel;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Example {@link net.minecraft.world.level.block.entity.BlockEntity} renderer for {@link FertilizerBlockEntity}
 * @see FertilizerModel
 * @see FertilizerBlockEntity
 */
public class FertilizerBlockRenderer<R extends BlockEntityRenderState & GeoRenderState> extends GeoBlockRenderer<FertilizerBlockEntity, R> {
	public FertilizerBlockRenderer() {
		super(new FertilizerModel());
	}
}

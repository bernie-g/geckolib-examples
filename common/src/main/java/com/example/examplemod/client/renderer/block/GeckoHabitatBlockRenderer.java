package com.example.examplemod.client.renderer.block;

import com.example.examplemod.block.entity.GeckoHabitatBlockEntity;
import com.example.examplemod.client.model.block.GeckoHabitatModel;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Example {@link net.minecraft.world.level.block.entity.BlockEntity BlockEntity} renderer for {@link GeckoHabitatBlockEntity}
 * @see GeckoHabitatModel
 * @see GeckoHabitatBlockEntity
 */
public class GeckoHabitatBlockRenderer<R extends BlockEntityRenderState & GeoRenderState> extends GeoBlockRenderer<GeckoHabitatBlockEntity, R> {
	public GeckoHabitatBlockRenderer() {
		super(new GeckoHabitatModel());
	}
}

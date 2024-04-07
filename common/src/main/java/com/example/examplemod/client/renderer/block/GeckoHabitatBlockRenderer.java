package com.example.examplemod.client.renderer.block;

import com.example.examplemod.block.entity.GeckoHabitatBlockEntity;
import com.example.examplemod.client.model.block.GeckoHabitatModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/**
 * Example {@link net.minecraft.world.level.block.entity.BlockEntity BlockEntity} renderer for {@link GeckoHabitatBlockEntity}
 * @see GeckoHabitatModel
 * @see GeckoHabitatBlockEntity
 */
public class GeckoHabitatBlockRenderer extends GeoBlockRenderer<GeckoHabitatBlockEntity> {
	public GeckoHabitatBlockRenderer() {
		super(new GeckoHabitatModel());
	}
}

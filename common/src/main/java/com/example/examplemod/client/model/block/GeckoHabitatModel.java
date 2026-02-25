package com.example.examplemod.client.model.block;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.block.entity.GeckoHabitatBlockEntity;
import com.example.examplemod.client.renderer.block.GeckoHabitatBlockRenderer;
import com.example.examplemod.registry.BlockRegistry;
import net.minecraft.resources.Identifier;
import com.geckolib.model.DefaultedBlockGeoModel;
import com.geckolib.model.GeoModel;
import com.geckolib.renderer.base.GeoRenderState;

/**
 * Example {@link GeoModel} for the {@link GeckoHabitatBlockEntity}
 * @see GeckoHabitatBlockEntity
 * @see GeckoHabitatBlockRenderer
 */
public class GeckoHabitatModel extends DefaultedBlockGeoModel<GeckoHabitatBlockEntity> {
	public GeckoHabitatModel() {
		super(BlockRegistry.GECKO_HABITAT.get());
	}

	// We add the `examplemod_day_time` DataTicket so it can be used later
	@Override
	public void addAdditionalStateData(GeckoHabitatBlockEntity animatable, Object relatedObject, GeoRenderState renderState) {
		renderState.addGeckolibData(GeckoHabitatBlockEntity.DAY_TIME, animatable.getLevel().getDefaultClockTime());
	}
}
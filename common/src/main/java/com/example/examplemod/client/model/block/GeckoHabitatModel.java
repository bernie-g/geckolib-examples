package com.example.examplemod.client.model.block;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.block.entity.GeckoHabitatBlockEntity;
import com.example.examplemod.client.renderer.block.GeckoHabitatBlockRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Example {@link GeoModel} for the {@link GeckoHabitatBlockEntity}
 * @see GeckoHabitatBlockEntity
 * @see GeckoHabitatBlockRenderer
 */
public class GeckoHabitatModel extends DefaultedBlockGeoModel<GeckoHabitatBlockEntity> {
	public GeckoHabitatModel() {
		super(ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "gecko_habitat"));
	}

	// We add the `examplemod_day_time` DataTicket so it can be used later
	@Override
	public void addAdditionalStateData(GeckoHabitatBlockEntity animatable, GeoRenderState renderState) {
		renderState.addGeckolibData(GeckoHabitatBlockEntity.DAY_TIME, animatable.getLevel().dayTime());
	}

	@Nullable
	@Override
	public RenderType getRenderType(GeoRenderState renderState, ResourceLocation texture) {
		return RenderType.entityTranslucent(texture);
	}
}
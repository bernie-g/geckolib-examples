package com.example.examplemod.client.model.entity;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.client.renderer.entity.FakeGlassRenderer;
import com.example.examplemod.entity.FakeGlassEntity;
import net.minecraft.resources.Identifier;
import com.geckolib.model.DefaultedEntityGeoModel;
import com.geckolib.model.GeoModel;
import com.geckolib.renderer.base.GeoRenderState;

/**
 * Example {@link GeoModel} for the {@link FakeGlassEntity}
 * @see FakeGlassRenderer
 */
public class FakeGlassModel extends DefaultedEntityGeoModel<FakeGlassEntity> {
	private static final Identifier REDSTONE_BLOCK_TEXTURE =
			Identifier.withDefaultNamespace("textures/block/redstone_block.png");

	public FakeGlassModel() {
		super(Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "fake_glass"));
	}

	// We just want our texture to be the Redstone Block texture
	@Override
	public Identifier getTextureResource(GeoRenderState renderState) {
		return REDSTONE_BLOCK_TEXTURE;
	}
}

package com.example.examplemod.client.renderer.block;

import com.example.examplemod.block.entity.GeckoHabitatBlockEntity;
import com.example.examplemod.client.model.block.GeckoHabitatModel;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.Nullable;
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

    @Nullable
    @Override
    public RenderType getRenderType(R renderState, Identifier texture) {
        // Our texture is transparent, so we need a transparent RenderType
        return RenderTypes.entityTranslucent(texture);
    }
}

package com.geckolib.example.examplemod.client.renderer.block;

import com.geckolib.example.examplemod.block.entity.FertilizerBlockEntity;
import com.geckolib.example.examplemod.client.model.block.FertilizerModel;
import com.geckolib.renderer.GeoBlockRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.Nullable;

/**
 * Example {@link net.minecraft.world.level.block.entity.BlockEntity} renderer for {@link FertilizerBlockEntity}
 * @see FertilizerModel
 * @see FertilizerBlockEntity
 */
public class FertilizerBlockRenderer<R extends BlockEntityRenderState & GeoRenderState> extends GeoBlockRenderer<FertilizerBlockEntity, R> {
	public FertilizerBlockRenderer(BlockEntityRendererProvider.Context context) {
		super(context, new FertilizerModel());
	}

    @Nullable
    @Override
    public RenderType getRenderType(R renderState, Identifier texture) {
        // Our texture is transparent, so we need a transparent RenderType
        return RenderTypes.entityTranslucent(texture);
    }
}

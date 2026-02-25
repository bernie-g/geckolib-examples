package com.geckolib.example.examplemod.client.renderer.entity;

import com.geckolib.example.examplemod.client.model.entity.BikeModel;
import com.geckolib.example.examplemod.entity.BikeEntity;
import com.geckolib.renderer.GeoEntityRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.base.GeoRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.Nullable;

/**
 * Example {@link GeoRenderer} for {@link BikeEntity}
 * @see BikeModel
 */
public class BikeRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<BikeEntity, R> {
	public BikeRenderer(EntityRendererProvider.Context context) {
		super(context, new BikeModel());
	}

    // We want this entity to have a translucent render
    @Override
    public @Nullable RenderType getRenderType(R renderState, Identifier texture) {
        return RenderTypes.entityTranslucent(texture);
    }
}

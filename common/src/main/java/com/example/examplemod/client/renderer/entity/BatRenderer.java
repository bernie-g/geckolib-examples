package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.client.model.entity.BatModel;
import com.example.examplemod.entity.BatEntity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.base.GeoRenderer;
import software.bernie.geckolib.renderer.base.RenderPassInfo;
import software.bernie.geckolib.renderer.layer.builtin.AutoGlowingGeoLayer;

/**
 * Example {@link GeoRenderer} for {@link BatEntity}
 * @see BatModel
 */
public class BatRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<BatEntity, R> {
	public BatRenderer(EntityRendererProvider.Context context) {
		super(context, new BatModel());

		// Add the glow layer to the bat so that it can live out its dreams of being rudolph
		withRenderLayer(AutoGlowingGeoLayer::new);
	}

    @Override
    public void preRenderPass(RenderPassInfo<R> renderPassInfo, SubmitNodeCollector renderTasks) {
        super.preRenderPass(renderPassInfo, renderTasks);

        // We're going to capture the ear bone's position and store it in the bat's animatable data
        renderPassInfo.model().getBone("leftear").ifPresent(bone -> {
            renderPassInfo.addBonePositionListener(bone, (worldPos, modelPos, localPos) -> {
                if (worldPos != null)
                    renderPassInfo.getGeckolibData(DataTickets.ANIMATABLE_MANAGER).setAnimatableData(BatEntity.EAR_POS_TICKET, worldPos);
            });
        });
    }
}

package com.geckolib.example.examplemod.client.renderer.entity;

import com.geckolib.constant.DataTickets;
import com.geckolib.constant.DefaultAnimations;
import com.geckolib.example.examplemod.client.model.entity.BatModel;
import com.geckolib.example.examplemod.entity.BatEntity;
import com.geckolib.renderer.GeoEntityRenderer;
import com.geckolib.renderer.base.BoneSnapshots;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.base.GeoRenderer;
import com.geckolib.renderer.base.RenderPassInfo;
import com.geckolib.renderer.layer.builtin.AutoGlowingGeoLayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

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
    public void adjustModelBonesForRender(RenderPassInfo<R> renderPassInfo, BoneSnapshots snapshots) {
        // Add in a hardcoded head rotation animation
        // Really you should be doing this as an animation in your animation.json (see the javadoc on #hardcodedHeadRotation)
        DefaultAnimations.hardcodedHeadRotation(renderPassInfo, snapshots, "head");
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

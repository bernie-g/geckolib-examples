package com.geckolib.example.examplemod.client.renderer.entity;

import com.geckolib.constant.DefaultAnimations;
import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.client.model.entity.GremlinModel;
import com.geckolib.example.examplemod.entity.DynamicExampleEntity;
import com.geckolib.renderer.GeoEntityRenderer;
import com.geckolib.renderer.base.BoneSnapshots;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.base.RenderPassInfo;
import com.geckolib.renderer.layer.builtin.CustomBoneTextureGeoLayer;
import com.geckolib.renderer.layer.builtin.ItemArmorGeoLayer;
import com.geckolib.renderer.layer.builtin.ItemInHandGeoLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

import java.util.List;

/**
 * Example multi-layered {@link GeoEntityRenderer} implementation
 * @see DynamicExampleEntity
 */
public class GremlinRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<DynamicExampleEntity, R> {
	// Pre-define our bone names for easy and consistent reference later
	private static final String LEFT_HAND = "bipedHandLeft";
	private static final String RIGHT_HAND = "bipedHandRight";
	private static final String LEFT_BOOT = "armorBipedLeftFoot";
	private static final String RIGHT_BOOT = "armorBipedRightFoot";
	private static final String LEFT_ARMOR_LEG = "armorBipedLeftLeg";
	private static final String RIGHT_ARMOR_LEG = "armorBipedRightLeg";
	private static final String CHESTPLATE = "armorBipedBody";
	private static final String RIGHT_SLEEVE = "armorBipedRightArm";
	private static final String LEFT_SLEEVE = "armorBipedLeftArm";
	private static final String HELMET = "armorBipedHead";

	protected final Identifier CAPE_TEXTURE = Identifier.fromNamespaceAndPath(ModConstants.MODID, "textures/entity/dynamic_entity_cape.png");

	public GremlinRenderer(EntityRendererProvider.Context context) {
		super(context, new GremlinModel());

		// Add some armor rendering
		withRenderLayer(new ItemArmorGeoLayer<>(this, context) {
			private final List<RenderData> BONES = List.of(RenderData.head(HELMET), RenderData.body(CHESTPLATE),
														   RenderData.leftArm(LEFT_SLEEVE), RenderData.rightArm(RIGHT_SLEEVE),
														   RenderData.leftLeg(LEFT_ARMOR_LEG), RenderData.rightLeg(RIGHT_ARMOR_LEG),
														   RenderData.leftFoot(LEFT_BOOT), RenderData.rightFoot(RIGHT_BOOT));

            @Override
            protected List<RenderData> getRelevantBones(RenderPassInfo<R> renderPassInfo) {
                return BONES;
            }
        });

		// Add some held item rendering
		withRenderLayer(new ItemInHandGeoLayer<>(this, RIGHT_HAND, LEFT_HAND));

		// Add a custom texture for the cape
		withRenderLayer(new CustomBoneTextureGeoLayer<>(this, "bipedCape", CAPE_TEXTURE));
	}

	@Override
	public void adjustModelBonesForRender(RenderPassInfo<R> renderPassInfo, BoneSnapshots snapshots) {
		DefaultAnimations.hardcodedHeadRotation(renderPassInfo, snapshots, "bipedHead");
	}
}
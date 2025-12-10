package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.client.model.entity.GremlinModel;
import com.example.examplemod.entity.DynamicExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.internal.RenderPassInfo;
import software.bernie.geckolib.renderer.layer.CustomBoneTextureGeoLayer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;
import software.bernie.geckolib.renderer.layer.ItemInHandGeoLayer;

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

	protected final Identifier CAPE_TEXTURE = Identifier.fromNamespaceAndPath(ExampleModCommon.MODID, "textures/entity/dynamic_entity_cape.png");

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
}
package com.example.examplemod.client.renderer.entity;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.client.model.entity.GremlinModel;
import com.example.examplemod.entity.DynamicExampleEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

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

	protected final ResourceLocation CAPE_TEXTURE = ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, "textures/entity/dynamic_entity_cape.png");

	public GremlinRenderer(EntityRendererProvider.Context context) {
		super(context, new GremlinModel());

		// Add some armor rendering
		addRenderLayer(new ItemArmorGeoLayer<>(this, context.getEquipmentRenderer()) {
			@Nullable
			@Override
			protected ItemStack getArmorItemForBone(GeoBone bone, R renderState) {
				// Return the items relevant to the bones being rendered for additional rendering
				return switch (bone.getName()) {
					case LEFT_BOOT, RIGHT_BOOT -> getStackForSlot(EquipmentSlot.FEET, renderState);
					case LEFT_ARMOR_LEG, RIGHT_ARMOR_LEG -> getStackForSlot(EquipmentSlot.LEGS, renderState);
					case CHESTPLATE, RIGHT_SLEEVE, LEFT_SLEEVE -> getStackForSlot(EquipmentSlot.CHEST, renderState);
					case HELMET -> getStackForSlot(EquipmentSlot.HEAD, renderState);
					default -> null;
				};
			}

			// Return the equipment slot relevant to the bone we're using
			@NotNull
			@Override
			protected EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, R renderState) {
				return switch (bone.getName()) {
					case LEFT_BOOT, RIGHT_BOOT -> EquipmentSlot.FEET;
					case LEFT_ARMOR_LEG, RIGHT_ARMOR_LEG -> EquipmentSlot.LEGS;
					case RIGHT_SLEEVE -> !renderState.getGeckolibData(DynamicExampleEntity.LEFT_HANDED) ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
					case LEFT_SLEEVE -> renderState.getGeckolibData(DynamicExampleEntity.LEFT_HANDED) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
					case CHESTPLATE -> EquipmentSlot.CHEST;
					case HELMET -> EquipmentSlot.HEAD;
					default -> super.getEquipmentSlotForBone(bone, stack, renderState);
				};
			}

			// Return the ModelPart responsible for the armor pieces we want to render
			@NotNull
			@Override
			protected ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, R renderState, HumanoidModel<?> baseModel) {
				return switch (bone.getName()) {
					case LEFT_BOOT, LEFT_ARMOR_LEG -> baseModel.leftLeg;
					case RIGHT_BOOT, RIGHT_ARMOR_LEG -> baseModel.rightLeg;
					case RIGHT_SLEEVE -> baseModel.rightArm;
					case LEFT_SLEEVE -> baseModel.leftArm;
					case CHESTPLATE -> baseModel.body;
					case HELMET -> baseModel.head;
					default -> super.getModelPartForBone(bone, slot, stack, renderState, baseModel);
				};
			}
		});

		// Add some held item rendering
		addRenderLayer(new BlockAndItemGeoLayer<>(this) {
			@Nullable
			@Override
			protected ItemStack getStackForBone(GeoBone bone, R renderState) {
				// Retrieve the items in the entity's hands for the relevant bone
				return switch (bone.getName()) {
					case LEFT_HAND -> renderState.getGeckolibData(DynamicExampleEntity.LEFT_HANDED) ?
									  renderState.getGeckolibData(DynamicExampleEntity.MAINHAND_ITEM) :
									  renderState.getGeckolibData(DynamicExampleEntity.OFFHAND_ITEM);
					case RIGHT_HAND -> renderState.getGeckolibData(DynamicExampleEntity.LEFT_HANDED) ?
									   renderState.getGeckolibData(DynamicExampleEntity.OFFHAND_ITEM) :
									   renderState.getGeckolibData(DynamicExampleEntity.MAINHAND_ITEM);
					default -> null;
				};
			}

			@Override
			protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, R renderState) {
				// Apply the camera transform for the given hand
				return switch (bone.getName()) {
					case LEFT_HAND, RIGHT_HAND -> ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
					default -> ItemDisplayContext.NONE;
				};
			}

			// Do some quick render modifications depending on what the item is
			@Override
			protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, R renderState, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
				if (stack == renderState.getGeckolibData(DynamicExampleEntity.MAINHAND_ITEM)) {
					poseStack.mulPose(Axis.XP.rotationDegrees(-90f));

					if (stack.getItem() instanceof ShieldItem)
						poseStack.translate(0, 0.125, -0.25);
				}
				else if (stack == renderState.getGeckolibData(DynamicExampleEntity.OFFHAND_ITEM)) {
					poseStack.mulPose(Axis.XP.rotationDegrees(-90f));

					if (stack.getItem() instanceof ShieldItem) {
						poseStack.translate(0, 0.125, 0.25);
						poseStack.mulPose(Axis.YP.rotationDegrees(180));
					}
				}

				super.renderStackForBone(poseStack, bone, stack, renderState, bufferSource, packedLight, packedOverlay);
			}
		});
	}
}
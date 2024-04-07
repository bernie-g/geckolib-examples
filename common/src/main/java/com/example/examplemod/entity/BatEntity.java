package com.example.examplemod.entity;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.ClientUtil;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Example {@link GeoAnimatable} implementation of an entity
 * @see com.example.examplemod.client.renderer.entity.BatRenderer BatRenderer
 * @see com.example.examplemod.client.model.entity.BatModel BatModel
 */
public class BatEntity extends PathfinderMob implements GeoEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	private boolean isFlying = false;

	public BatEntity(EntityType<? extends PathfinderMob> type, Level level) {
		super(type, level);
	}

	// Have the bat look at the player
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 12.0F));
		super.registerGoals();
	}

	// Adds a right-click toggle that turns on/off its animating pose
	@Override
	public InteractionResult interactAt(Player player, Vec3 hitPos, InteractionHand hand) {
		if (hand == InteractionHand.MAIN_HAND)
			this.isFlying = !this.isFlying;

		return super.interactAt(player, hitPos, hand);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(
				// Add our flying animation controller
				new AnimationController<>(this, 10, state -> state.setAndContinue(this.isFlying ? DefaultAnimations.FLY : DefaultAnimations.IDLE))
						// Handle the custom instruction keyframe that is part of our animation json
						.setCustomInstructionKeyframeHandler(state -> {
							Player player = ClientUtil.getClientPlayer();

							if (player != null)
								player.displayClientMessage(Component.literal("KeyFraming"), true);
						}),
				// Add our generic living animation controller
				DefaultAnimations.genericLivingController(this)
		);
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}

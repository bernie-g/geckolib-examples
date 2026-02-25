package com.geckolib.example.examplemod.entity;

import com.geckolib.animatable.GeoAnimatable;
import com.geckolib.animatable.GeoEntity;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.animation.AnimationController;
import com.geckolib.constant.DefaultAnimations;
import com.geckolib.constant.dataticket.DataTicket;
import com.geckolib.util.ClientUtil;
import com.geckolib.util.GeckoLibUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * Example {@link GeoAnimatable} implementation of an entity
 * @see com.geckolib.example.examplemod.client.renderer.entity.BatRenderer BatRenderer
 * @see com.geckolib.example.examplemod.client.model.entity.BatModel BatModel
 */
public class BatEntity extends PathfinderMob implements GeoEntity {
    public static final DataTicket<Vec3> EAR_POS_TICKET = DataTicket.create("examplemod_bat_ear_pos", Vec3.class);
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
	protected InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (hand == InteractionHand.MAIN_HAND)
			this.isFlying = !this.isFlying;

		return super.mobInteract(player, hand);
	}

    @Override
    public void tick() {
        super.tick();

        if (level().isClientSide()) {
            // We retrieve the ear position ticket we stored in BatRenderer and use it here for particles
            Vec3 earPos = getAnimatableInstanceCache().getManagerForId(getId()).getAnimatableData(EAR_POS_TICKET);

            if (earPos != null) {
                level().addParticle(ParticleTypes.PORTAL,
                                    earPos.x(),
                                    earPos.y(),
                                    earPos.z(),
                                    this.random.nextDouble() - 0.5D,
                                    -this.random.nextDouble(),
                                    this.random.nextDouble() - 0.5D);
            }
        }
    }

    @Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(
				// Add our flying animation controller
				new AnimationController<>("Main", 10, state -> state.setAndContinue(this.isFlying ? DefaultAnimations.FLY : DefaultAnimations.IDLE))
						// Handle the custom instruction keyframe that is part of our animation json
						.setCustomInstructionKeyframeHandler(animTest -> {
							Player player = ClientUtil.getClientPlayer();

							if (player != null)
								player.sendSystemMessage(Component.literal("KeyFraming"));
						}),
				// Add our generic living animation controller
				DefaultAnimations.genericLivingController()
		);
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}

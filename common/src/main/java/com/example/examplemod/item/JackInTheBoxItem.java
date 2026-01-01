package com.example.examplemod.item;

import com.example.examplemod.client.renderer.item.JackInTheBoxRenderer;
import com.example.examplemod.registry.SoundRegistry;
import com.google.common.base.Suppliers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.object.PlayState;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.ClientUtil;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Example {@link GeoItem} implementation in the form of a Jack-in-the-Box.<br>
 */
public final class JackInTheBoxItem extends Item implements GeoItem {
	private static final RawAnimation POPUP_ANIM = RawAnimation.begin().thenPlay("use.popup");
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public JackInTheBoxItem(Properties properties) {
		super(properties);

		// Register our item as server-side handled.
		// This enables both animation data syncing and server-side animation triggering
		SingletonGeoAnimatable.registerSyncedAnimatable(this);
	}

	// Create our armor model/renderer and return it
	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			// Defer creation of our renderer then cache it so that it doesn't get instantiated too early
			private final Supplier<JackInTheBoxRenderer> renderer = Suppliers.memoize(JackInTheBoxRenderer::new);

			@Override
			@Nullable
			public GeoItemRenderer<JackInTheBoxItem> getGeoItemRenderer() {
				return this.renderer.get();
			}
		});
	}

	// Let's handle our use method so that we activate the animation when right-clicking while holding the box
	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		if (level instanceof ServerLevel serverLevel)
			triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "popup_controller", "box_open");

		return super.use(level, player, hand);
	}

	@Override
	public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @org.jspecify.annotations.Nullable EquipmentSlot slot) {
		if (entity instanceof ServerPlayer player && player.isCrouching())
			stopTriggeredAnim(entity, GeoItem.getOrAssignId(stack, level), "popup_controller", "box_open");

		super.inventoryTick(stack, level, entity, slot);
	}

	// Let's add our animation controller
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>("popup_controller", 20, animTest -> {
			final ItemDisplayContext context = animTest.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);

			// We only want our triggered animation to happen if it's in-hand
			if (context.firstPerson() || context == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || context == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
				return PlayState.CONTINUE;

			return PlayState.STOP;
		}).receiveTriggeredAnimations()
		  .triggerableAnim("box_open", POPUP_ANIM)
		  // We've marked the "box_open" animation as being triggerable from the server
		  .setSoundKeyframeHandler(state -> {
			  // Use helper method to avoid client-code in common class
			  Player player = ClientUtil.getClientPlayer();

		  	  if (player != null)
					player.playSound(SoundRegistry.JACK_MUSIC.get(), 1, 1);
		  }));
	}

	// We don't want our animation to happen in non-hand perspectives
	@Override
	public boolean isPerspectiveAware() {
		return true;
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}

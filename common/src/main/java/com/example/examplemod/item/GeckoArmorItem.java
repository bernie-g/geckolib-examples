package com.example.examplemod.item;

import com.example.examplemod.client.renderer.armor.GeckoArmorRenderer;
import com.google.common.base.Suppliers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.object.PlayState;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Example {@link GeoAnimatable GeoAnimatable} armor item implementation
 * @see GeoItem
 * @see GeckoArmorRenderer
 */
public final class GeckoArmorItem extends Item implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public static final DataTicket<Boolean> HAS_FULL_SET_EFFECT = DataTicket.create("examplemod_has_full_set_effect", Boolean.class);

	public GeckoArmorItem(ArmorMaterial armorMaterial, ArmorType type, Properties properties) {
		super(properties.humanoidArmor(armorMaterial, type));
	}

	// Create our armor model/renderer and return it
	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			// Defer creation of our renderer then cache it so that it doesn't get instantiated too early
			private final Supplier<GeckoArmorRenderer<?>> renderer = Suppliers.memoize(GeckoArmorRenderer::new);

			@Nullable
			@Override
            public GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack itemStack, EquipmentSlot equipmentSlot) {
				return this.renderer.get();
			}
		});
	}

	// Let's add our animation controller
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>("Main", 20, animTest -> {
			// Play the animation if the full set is being worn, otherwise stop
			if (animTest.getData(HAS_FULL_SET_EFFECT))
				return animTest.setAndContinue(DefaultAnimations.IDLE);

			return PlayState.STOP;
		}));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
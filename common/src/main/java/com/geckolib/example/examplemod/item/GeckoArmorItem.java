package com.geckolib.example.examplemod.item;

import com.geckolib.example.examplemod.client.renderer.armor.GeckoArmorRenderer;
import com.geckolib.animatable.GeoAnimatable;
import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.animation.AnimationController;
import com.geckolib.animation.object.PlayState;
import com.geckolib.constant.DefaultAnimations;
import com.geckolib.constant.dataticket.DataTicket;
import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.util.GeckoLibUtil;
import com.google.common.base.Suppliers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.Nullable;

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
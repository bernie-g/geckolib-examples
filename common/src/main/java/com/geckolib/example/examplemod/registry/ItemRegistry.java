package com.geckolib.example.examplemod.registry;

import com.geckolib.example.examplemod.ModConstants;
import com.geckolib.example.examplemod.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/// The mod's registered items
public final class ItemRegistry {
	public static void init() {}

	public static final Supplier<BlockItem> GECKO_HABITAT = register("gecko_habitat", properties -> new GeckoHabitatItem(BlockRegistry.GECKO_HABITAT.get(), properties));
	public static final Supplier<BlockItem> FERTILIZER = register("fertilizer", properties -> new FertilizerItem(BlockRegistry.FERTILIZER.get(), properties));

	public static final Supplier<JackInTheBoxItem> JACK_IN_THE_BOX = register("jack_in_the_box", JackInTheBoxItem::new);

	public static final Supplier<WolfArmorItem> WOLF_ARMOR_HELMET = register("wolf_armor_helmet", properties -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorType.HELMET, properties));
	public static final Supplier<WolfArmorItem> WOLF_ARMOR_CHESTPLATE = register("wolf_armor_chestplate", properties -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorType.CHESTPLATE, properties));
	public static final Supplier<WolfArmorItem> WOLF_ARMOR_LEGGINGS = register("wolf_armor_leggings", properties -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorType.LEGGINGS, properties));
	public static final Supplier<WolfArmorItem> WOLF_ARMOR_BOOTS = register("wolf_armor_boots", properties -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorType.BOOTS, properties));

	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_HELMET = register("gecko_armor_helmet", properties -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorType.HELMET, properties));
	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_CHESTPLATE = register("gecko_armor_chestplate", properties -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorType.CHESTPLATE, properties));
	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_LEGGINGS = register("gecko_armor_leggings", properties -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorType.LEGGINGS, properties));
	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_BOOTS = register("gecko_armor_boots", properties -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorType.BOOTS, properties));
    
    public static final Supplier<SpawnEggItem> BAT_SPAWN_EGG = register("bat_spawn_egg", SpawnEggItem::new);
    public static final Supplier<SpawnEggItem> BIKE_SPAWN_EGG = register("bike_spawn_egg", SpawnEggItem::new);
	public static final Supplier<SpawnEggItem> COOL_KID_SPAWN_EGG = register("cool_kid_spawn_egg", SpawnEggItem::new);
	public static final Supplier<SpawnEggItem> FAKE_GLASS_SPAWN_EGG = register("fake_glass_spawn_egg", SpawnEggItem::new);
	public static final Supplier<SpawnEggItem> GREMLIN_SPAWN_EGG = register("gremlin_spawn_egg", SpawnEggItem::new);
	public static final Supplier<SpawnEggItem> MUTANT_ZOMBIE_SPAWN_EGG = register("mutant_zombie_spawn_egg", SpawnEggItem::new);
	public static final Supplier<SpawnEggItem> PARASITE_SPAWN_EGG = register("parasite_spawn_egg", SpawnEggItem::new);
	public static final Supplier<SpawnEggItem> RACE_CAR_SPAWN_EGG = register("race_car_spawn_egg", SpawnEggItem::new);

	public static final Supplier<CreativeModeTab> EXAMPLEMOD_TAB = ModConstants.PLATFORM.registerCreativeModeTab("examplemod_items", () -> ModConstants.PLATFORM.newCreativeTabBuilder()
			.title(Component.translatable("itemGroup." + ModConstants.MODID + ".examplemod_items"))
			.icon(() -> new ItemStack(ItemRegistry.JACK_IN_THE_BOX.get()))
			.displayItems((enabledFeatures, entries) -> {
				entries.accept(ItemRegistry.JACK_IN_THE_BOX.get());
				entries.accept(ItemRegistry.GECKO_ARMOR_HELMET.get());
				entries.accept(ItemRegistry.GECKO_ARMOR_CHESTPLATE.get());
				entries.accept(ItemRegistry.GECKO_ARMOR_LEGGINGS.get());
				entries.accept(ItemRegistry.GECKO_ARMOR_BOOTS.get());
				entries.accept(ItemRegistry.WOLF_ARMOR_HELMET.get());
				entries.accept(ItemRegistry.WOLF_ARMOR_CHESTPLATE.get());
				entries.accept(ItemRegistry.WOLF_ARMOR_LEGGINGS.get());
				entries.accept(ItemRegistry.WOLF_ARMOR_BOOTS.get());
				entries.accept(ItemRegistry.GECKO_HABITAT.get());
				entries.accept(ItemRegistry.FERTILIZER.get());
				entries.accept(ItemRegistry.BAT_SPAWN_EGG.get());
				entries.accept(ItemRegistry.BIKE_SPAWN_EGG.get());
				entries.accept(ItemRegistry.RACE_CAR_SPAWN_EGG.get());
				entries.accept(ItemRegistry.PARASITE_SPAWN_EGG.get());
				entries.accept(ItemRegistry.MUTANT_ZOMBIE_SPAWN_EGG.get());
				entries.accept(ItemRegistry.GREMLIN_SPAWN_EGG.get());
				entries.accept(ItemRegistry.FAKE_GLASS_SPAWN_EGG.get());
				entries.accept(ItemRegistry.COOL_KID_SPAWN_EGG.get());
			})
			.build());

	//<editor-fold defaultstate="collapsed" desc="<Registration Methods>">
	/// Register a basic [Item]
	private static Supplier<Item> registerBasic(String id) {
		return registerBasic(id, new Item.Properties());
	}

	/// Register a basic [Item] with custom [Item.Properties]
	private static Supplier<Item> registerBasic(String id, Item.Properties properties) {
		return register(id, () -> new Item(properties.setId(ResourceKey.create(Registries.ITEM, ModConstants.id(id)))));
	}

	/// Register an item
	private static <T extends Item> Supplier<T> register(String id, Function<Item.Properties, T> itemFactory) {
		return register(id, itemFactory, UnaryOperator.identity());
	}

	/// Register an item
	private static <T extends Item> Supplier<T> register(String id, Function<Item.Properties, T> itemFactory, UnaryOperator<Item.Properties> properties) {
		return register(id, () -> itemFactory.apply(properties.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ModConstants.id(id))))));
	}

	/// Register an item
	private static <T extends Item> Supplier<T> register(String id, Supplier<T> item) {
		return ModConstants.PLATFORM.registerItem(id, item);
	}
	//</editor-fold>
}

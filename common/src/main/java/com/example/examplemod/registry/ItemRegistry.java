package com.example.examplemod.registry;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.item.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;
import java.util.function.Supplier;

public final class ItemRegistry {
	public static void init() {}

	public static final Supplier<BlockItem> GECKO_HABITAT = registerItem("gecko_habitat", properties -> new GeckoHabitatItem(BlockRegistry.GECKO_HABITAT.get(), properties));
	public static final Supplier<BlockItem> FERTILIZER = registerItem("fertilizer", properties -> new FertilizerItem(BlockRegistry.FERTILIZER.get(), properties));

	public static final Supplier<JackInTheBoxItem> JACK_IN_THE_BOX = registerItem("jack_in_the_box", JackInTheBoxItem::new);

	public static final Supplier<WolfArmorItem> WOLF_ARMOR_HELMET = registerItem("wolf_armor_helmet", properties -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorType.HELMET, properties));
	public static final Supplier<WolfArmorItem> WOLF_ARMOR_CHESTPLATE = registerItem("wolf_armor_chestplate", properties -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorType.CHESTPLATE, properties));
	public static final Supplier<WolfArmorItem> WOLF_ARMOR_LEGGINGS = registerItem("wolf_armor_leggings", properties -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorType.LEGGINGS, properties));
	public static final Supplier<WolfArmorItem> WOLF_ARMOR_BOOTS = registerItem("wolf_armor_boots", properties -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorType.BOOTS, properties));

	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_HELMET = registerItem("gecko_armor_helmet", properties -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorType.HELMET, properties));
	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_CHESTPLATE = registerItem("gecko_armor_chestplate", properties -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorType.CHESTPLATE, properties));
	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_LEGGINGS = registerItem("gecko_armor_leggings", properties -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorType.LEGGINGS, properties));
	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_BOOTS = registerItem("gecko_armor_boots", properties -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorType.BOOTS, properties));
    
    public static final Supplier<SpawnEggItem> BAT_SPAWN_EGG = registerItem("bat_spawn_egg", properties -> new SpawnEggItem(EntityRegistry.BAT.get(), properties));
    public static final Supplier<SpawnEggItem> BIKE_SPAWN_EGG = registerItem("bike_spawn_egg", properties -> new SpawnEggItem(EntityRegistry.BIKE.get(), properties));
	public static final Supplier<SpawnEggItem> COOL_KID_SPAWN_EGG = registerItem("cool_kid_spawn_egg", properties -> new SpawnEggItem(EntityRegistry.COOL_KID.get(), properties));
	public static final Supplier<SpawnEggItem> FAKE_GLASS_SPAWN_EGG = registerItem("fake_glass_spawn_egg", properties -> new SpawnEggItem(EntityRegistry.FAKE_GLASS.get(), properties));
	public static final Supplier<SpawnEggItem> GREMLIN_SPAWN_EGG = registerItem("gremlin_spawn_egg", properties -> new SpawnEggItem(EntityRegistry.GREMLIN.get(), properties));
	public static final Supplier<SpawnEggItem> MUTANT_ZOMBIE_SPAWN_EGG = registerItem("mutant_zombie_spawn_egg", properties -> new SpawnEggItem(EntityRegistry.MUTANT_ZOMBIE.get(), properties));
	public static final Supplier<SpawnEggItem> PARASITE_SPAWN_EGG = registerItem("parasite_spawn_egg", properties -> new SpawnEggItem(EntityRegistry.PARASITE.get(), properties));
	public static final Supplier<SpawnEggItem> RACE_CAR_SPAWN_EGG = registerItem("race_car_spawn_egg", properties -> new SpawnEggItem(EntityRegistry.RACE_CAR.get(), properties));

	private static <T extends Item> Supplier<T> registerItem(String id, Function<Item.Properties, T> item) {
		return ExampleModCommon.COMMON_PLATFORM.registerItem(id, item);
	}

	public static final Supplier<CreativeModeTab> EXAMPLEMOD_TAB = ExampleModCommon.COMMON_PLATFORM.registerCreativeModeTab("examplemod_items", () -> ExampleModCommon.COMMON_PLATFORM.newCreativeTabBuilder()
			.title(Component.translatable("itemGroup." + ExampleModCommon.MODID + ".examplemod_items"))
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
}

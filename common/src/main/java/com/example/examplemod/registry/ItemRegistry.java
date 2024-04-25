package com.example.examplemod.registry;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.item.GeckoArmorItem;
import com.example.examplemod.item.GeckoHabitatItem;
import com.example.examplemod.item.JackInTheBoxItem;
import com.example.examplemod.item.WolfArmorItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

public final class ItemRegistry {
	public static void init() {}

	public static final Supplier<BlockItem> GECKO_HABITAT = registerItem("gecko_habitat", () -> new GeckoHabitatItem(BlockRegistry.GECKO_HABITAT.get(), new Item.Properties()));
	public static final Supplier<BlockItem> FERTILIZER = registerItem("fertilizer", () -> new BlockItem(BlockRegistry.FERTILIZER.get(), new Item.Properties()));

	public static final Supplier<JackInTheBoxItem> JACK_IN_THE_BOX = registerItem("jack_in_the_box", () -> new JackInTheBoxItem(new Item.Properties()));

	public static final Supplier<WolfArmorItem> WOLF_ARMOR_HELMET = registerItem("wolf_armor_helmet", () -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final Supplier<WolfArmorItem> WOLF_ARMOR_CHESTPLATE = registerItem("wolf_armor_chestplate", () -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final Supplier<WolfArmorItem> WOLF_ARMOR_LEGGINGS = registerItem("wolf_armor_leggings", () -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final Supplier<WolfArmorItem> WOLF_ARMOR_BOOTS = registerItem("wolf_armor_boots", () -> new WolfArmorItem(ArmorMaterialRegistry.WOLF_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_HELMET = registerItem("gecko_armor_helmet", () -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_CHESTPLATE = registerItem("gecko_armor_chestplate", () -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_LEGGINGS = registerItem("gecko_armor_leggings", () -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final Supplier<GeckoArmorItem> GECKO_ARMOR_BOOTS = registerItem("gecko_armor_boots", () -> new GeckoArmorItem(ArmorMaterialRegistry.GECKO_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    
    public static final Supplier<SpawnEggItem> BAT_SPAWN_EGG = registerItem("bat_spawn_egg", ExampleModCommon.COMMON_PLATFORM.makeSpawnEggFor(EntityRegistry.BAT, 0x1F1F1F, 0x0D0D0D, new Item.Properties()));
    public static final Supplier<SpawnEggItem> BIKE_SPAWN_EGG = registerItem("bike_spawn_egg", ExampleModCommon.COMMON_PLATFORM.makeSpawnEggFor(EntityRegistry.BIKE, 0xD3E3E6, 0xE9F1F5, new Item.Properties()));
    public static final Supplier<SpawnEggItem> RACE_CAR_SPAWN_EGG = registerItem("race_car_spawn_egg", ExampleModCommon.COMMON_PLATFORM.makeSpawnEggFor(EntityRegistry.RACE_CAR, 0x9E1616, 0x595959, new Item.Properties()));
    public static final Supplier<SpawnEggItem> PARASITE_SPAWN_EGG = registerItem("parasite_spawn_egg", ExampleModCommon.COMMON_PLATFORM.makeSpawnEggFor(EntityRegistry.PARASITE, 0x302219, 0xACACAC, new Item.Properties()));
    public static final Supplier<SpawnEggItem> MUTANT_ZOMBIE_SPAWN_EGG = registerItem("mutant_zombie_spawn_egg", ExampleModCommon.COMMON_PLATFORM.makeSpawnEggFor(EntityRegistry.MUTANT_ZOMBIE, 0x3C6236, 0x579989, new Item.Properties()));
    public static final Supplier<SpawnEggItem> FAKE_GLASS_SPAWN_EGG = registerItem("fake_glass_spawn_egg", ExampleModCommon.COMMON_PLATFORM.makeSpawnEggFor(EntityRegistry.FAKE_GLASS, 0xDD0000, 0xD8FFF7, new Item.Properties()));
    public static final Supplier<SpawnEggItem> COOL_KID_SPAWN_EGG = registerItem("cool_kid_spawn_egg", ExampleModCommon.COMMON_PLATFORM.makeSpawnEggFor(EntityRegistry.COOL_KID, 0x5F2A31, 0x6F363E, new Item.Properties()));
    public static final Supplier<SpawnEggItem> GREMLIN_SPAWN_EGG = registerItem("gremlin_spawn_egg", ExampleModCommon.COMMON_PLATFORM.makeSpawnEggFor(EntityRegistry.GREMLIN, 0x505050, 0x606060, new Item.Properties()));

	private static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
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

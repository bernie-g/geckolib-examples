package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.GeckoArmorItem;
import com.example.examplemod.item.GeckoHabitatItem;
import com.example.examplemod.item.JackInTheBoxItem;
import com.example.examplemod.item.WolfArmorItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public final class ItemRegistry {
	public static final BlockItem GECKO_HABITAT = register("gecko_habitat", new GeckoHabitatItem(BlockRegistry.GECKO_HABITAT, new Item.Properties()));
	public static final BlockItem FERTILIZER = register("fertilizer", new BlockItem(BlockRegistry.FERTILIZER, new Item.Properties()));

	public static final JackInTheBoxItem JACK_IN_THE_BOX = register("jack_in_the_box", new JackInTheBoxItem(new Item.Properties()));

	public static final WolfArmorItem WOLF_ARMOR_HELMET = register("wolf_armor_helmet", new WolfArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final WolfArmorItem WOLF_ARMOR_CHESTPLATE = register("wolf_armor_chestplate", new WolfArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final WolfArmorItem WOLF_ARMOR_LEGGINGS = register("wolf_armor_leggings", new WolfArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final WolfArmorItem WOLF_ARMOR_BOOTS = register("wolf_armor_boots", new WolfArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));

	public static final GeckoArmorItem GECKO_ARMOR_HELMET = register("gecko_armor_helmet", new GeckoArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final GeckoArmorItem GECKO_ARMOR_CHESTPLATE = register("gecko_armor_chestplate", new GeckoArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final GeckoArmorItem GECKO_ARMOR_LEGGINGS = register("gecko_armor_leggings", new GeckoArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final GeckoArmorItem GECKO_ARMOR_BOOTS = register("gecko_armor_boots", new GeckoArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));
    
    public static final SpawnEggItem BAT_SPAWN_EGG = register("bat_spawn_egg", new SpawnEggItem(EntityRegistry.BAT, 0x1F1F1F, 0x0D0D0D, new Item.Properties()));
    public static final SpawnEggItem BIKE_SPAWN_EGG = register("bike_spawn_egg", new SpawnEggItem(EntityRegistry.BIKE, 0xD3E3E6, 0xE9F1F5, new Item.Properties()));
    public static final SpawnEggItem RACE_CAR_SPAWN_EGG = register("race_car_spawn_egg", new SpawnEggItem(EntityRegistry.RACE_CAR, 0x9E1616, 0x595959, new Item.Properties()));
    public static final SpawnEggItem PARASITE_SPAWN_EGG = register("parasite_spawn_egg", new SpawnEggItem(EntityRegistry.PARASITE, 0x302219, 0xACACAC, new Item.Properties()));
    public static final SpawnEggItem MUTANT_ZOMBIE_SPAWN_EGG = register("mutant_zombie_spawn_egg", new SpawnEggItem(EntityRegistry.MUTANT_ZOMBIE, 0x3C6236, 0x579989, new Item.Properties()));
    public static final SpawnEggItem FAKE_GLASS_SPAWN_EGG = register("fake_glass_spawn_egg", new SpawnEggItem(EntityRegistry.FAKE_GLASS, 0xDD0000, 0xD8FFF7, new Item.Properties()));
    public static final SpawnEggItem COOL_KID_SPAWN_EGG = register("cool_kid_spawn_egg", new SpawnEggItem(EntityRegistry.COOL_KID, 0x5F2A31, 0x6F363E, new Item.Properties()));
    public static final SpawnEggItem GREMLIN_SPAWN_EGG = register("gremlin_spawn_egg", new SpawnEggItem(EntityRegistry.GREMLIN, 0x505050, 0x606060, new Item.Properties()));

	public static final CreativeModeTab ITEM_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(ExampleMod.MODID, "examplemod_items"), FabricItemGroup
			.builder()
			.title(Component.translatable("itemGroup.examplemod.examplemod_items"))
			.icon(() -> new ItemStack(ItemRegistry.JACK_IN_THE_BOX))
			.displayItems((enabledFeatures, entries) -> {
				entries.accept(ItemRegistry.JACK_IN_THE_BOX);
				entries.accept(ItemRegistry.GECKO_ARMOR_HELMET);
				entries.accept(ItemRegistry.GECKO_ARMOR_CHESTPLATE);
				entries.accept(ItemRegistry.GECKO_ARMOR_LEGGINGS);
				entries.accept(ItemRegistry.GECKO_ARMOR_BOOTS);
				entries.accept(ItemRegistry.WOLF_ARMOR_HELMET);
				entries.accept(ItemRegistry.WOLF_ARMOR_CHESTPLATE);
				entries.accept(ItemRegistry.WOLF_ARMOR_LEGGINGS);
				entries.accept(ItemRegistry.WOLF_ARMOR_BOOTS);
				entries.accept(ItemRegistry.GECKO_HABITAT);
				entries.accept(ItemRegistry.FERTILIZER);
				entries.accept(ItemRegistry.BAT_SPAWN_EGG);
				entries.accept(ItemRegistry.BIKE_SPAWN_EGG);
				entries.accept(ItemRegistry.RACE_CAR_SPAWN_EGG);
				entries.accept(ItemRegistry.PARASITE_SPAWN_EGG);
				entries.accept(ItemRegistry.MUTANT_ZOMBIE_SPAWN_EGG);
				entries.accept(ItemRegistry.GREMLIN_SPAWN_EGG);
				entries.accept(ItemRegistry.FAKE_GLASS_SPAWN_EGG);
				entries.accept(ItemRegistry.COOL_KID_SPAWN_EGG);
			}).build());

	public static void init() {}

	public static <I extends Item> I register(String name, I item) {
		return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ExampleMod.MODID, name), item);
	}
}

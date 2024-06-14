package com.example.examplemod;

import com.example.examplemod.platform.ExampleModPlatform;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ExampleModFabricPlatform implements ExampleModPlatform {
    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntityType) {
        return registerSupplier(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, blockEntityType);
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return registerSupplier(BuiltInRegistries.BLOCK, id, block);
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String id, Supplier<EntityType<T>> entity) {
        return registerSupplier(BuiltInRegistries.ENTITY_TYPE, id, entity);
    }

    @Override
    public <T extends ArmorMaterial> Holder<T> registerArmorMaterial(String id, Supplier<T> armorMaterial) {
        return registerHolder(BuiltInRegistries.ARMOR_MATERIAL, id, armorMaterial);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return registerSupplier(BuiltInRegistries.ITEM, id, item);
    }

    @Override
    public <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> sound) {
        return registerSupplier(BuiltInRegistries.SOUND_EVENT, id, sound);
    }

    @Override
    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String id, Supplier<T> tab) {
        return registerSupplier(BuiltInRegistries.CREATIVE_MODE_TAB, id, tab);
    }

    @Override
    public <E extends Mob> Supplier<SpawnEggItem> makeSpawnEggFor(Supplier<EntityType<E>> entityType, int primaryEggColour, int secondaryEggColour, Item.Properties itemProperties) {
        return () -> new SpawnEggItem(entityType.get(), primaryEggColour, secondaryEggColour, itemProperties);
    }

    @Override
    public CreativeModeTab.Builder newCreativeTabBuilder() {
        return FabricItemGroup.builder();
    }

    /**
     * Quick wrapper to make the individual registration lines cleaner but still return the multiloader-compatible supplier
     */
    private static <T, R extends Registry<? super T>> Supplier<T> registerSupplier(R registry, String id, Supplier<T> object) {
        final T registeredObject = Registry.register((Registry<T>)registry, ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, id), object.get());

        return () -> registeredObject;
    }

    /**
     * Quick wrapper to make the individual registration lines cleaner but still return the multiloader-compatible supplier
     */
    private static <T, R extends Registry<? super T>> Holder<T> registerHolder(R registry, String id, Supplier<T> object) {
        return Registry.registerForHolder((Registry<T>)registry, ResourceLocation.fromNamespaceAndPath(ExampleModCommon.MODID, id), object.get());
    }
}

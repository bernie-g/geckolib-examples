package com.geckolib.example.examplemod;

import com.geckolib.example.examplemod.platform.PlatformHelper;
import net.fabricmc.fabric.impl.creativetab.FabricCreativeModeTabBuilderImpl;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

/// Fabric [SPI](https://docs.oracle.com/javase/tutorial/sound/SPI-intro.html) implementation for [PlatformHelper]
public final class FabricPlatform implements PlatformHelper {
    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        final T registeredItem = Registry.register(BuiltInRegistries.ITEM, ModConstants.id(id), item.get());

        return () -> registeredItem;
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String id, Supplier<EntityType<T>> entityType) {
        final EntityType<T> registeredEntity = Registry.register(BuiltInRegistries.ENTITY_TYPE, ModConstants.id(id), entityType.get());

        return () -> registeredEntity;
    }
    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntityType) {
        return registerSupplier(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, blockEntityType);
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Function<BlockBehaviour.Properties, T> block) {
        return registerKeyedSupplier(BuiltInRegistries.BLOCK, id, key -> block.apply(BlockBehaviour.Properties.of().setId((ResourceKey<Block>)key)));
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
    public CreativeModeTab.Builder newCreativeTabBuilder() {
        return new FabricCreativeModeTabBuilderImpl();
    }

    /**
     * Quick wrapper to make the individual registration lines cleaner but still return the multiloader-compatible supplier
     */
    private static <T, R extends Registry<? super T>> Supplier<T> registerSupplier(R registry, String id, Supplier<T> object) {
        final T registeredObject = Registry.register((Registry<T>)registry, Identifier.fromNamespaceAndPath(ModConstants.MODID, id), object.get());

        return () -> registeredObject;
    }
    /**
     * Quick wrapper to make the individual registration lines cleaner but still return the multiloader-compatible supplier
     */
    private static <T, R extends Registry<? super T>> Supplier<T> registerKeyedSupplier(R registry, String id, Function<ResourceKey<T>, T> object) {
        final Registry<T> typedRegistry = (Registry<T>)registry;
        final Identifier registryId = Identifier.fromNamespaceAndPath(ModConstants.MODID, id);
        final T registeredObject = Registry.register(typedRegistry, registryId, object.apply(ResourceKey.create(typedRegistry.key(), registryId)));

        return () -> registeredObject;
    }

    /**
     * Quick wrapper to make the individual registration lines cleaner but still return the multiloader-compatible supplier
     */
    private static <T, R extends Registry<? super T>> Holder<T> registerHolder(R registry, String id, Supplier<T> object) {
        return Registry.registerForHolder((Registry<T>)registry, Identifier.fromNamespaceAndPath(ModConstants.MODID, id), object.get());
    }
}

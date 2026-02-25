package com.geckolib.example.examplemod;

import com.geckolib.example.examplemod.registry.EntityRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

/// Initializer class for NeoForge-specific setup tasks
@Mod(ModConstants.MODID)
public final class ModMain {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT_REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, ModConstants.MODID);
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(Registries.BLOCK, ModConstants.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTRY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ModConstants.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, ModConstants.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModConstants.MODID);
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(Registries.ITEM, ModConstants.MODID);

    public ModMain(IEventBus modBus, ModContainer modContainer) {
        SOUND_EVENT_REGISTRY.register(modBus);
        BLOCK_REGISTRY.register(modBus);
        BLOCK_ENTITY_REGISTRY.register(modBus);
        ENTITY_REGISTRY.register(modBus);
        CREATIVE_TAB_REGISTRY.register(modBus);
        ITEM_REGISTRY.register(modBus);
        modBus.<EntityAttributeCreationEvent>addListener(event -> EntityRegistry.registerEntityAttributes(event::put));

        ModCommon.init();
    }
}

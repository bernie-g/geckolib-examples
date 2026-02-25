package com.github.myname.mymod;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

/// Initializer class for Forge-specific setup tasks
@Mod(ModConstants.MODID)
public final class ModMain {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT_REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, ModConstants.MODID);
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(Registries.BLOCK, ModConstants.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTRY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ModConstants.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, ModConstants.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModConstants.MODID);
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(Registries.ITEM, ModConstants.MODID);

    public ModMain(FMLJavaModLoadingContext context) {
        final BusGroup busGroup = context.getModBusGroup();

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

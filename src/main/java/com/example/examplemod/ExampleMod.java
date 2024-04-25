package com.example.examplemod;

import com.example.examplemod.registry.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final String MODID = "examplemod";

    public ExampleMod(IEventBus modEventBus) {
        EntityRegistry.ENTITIES.register(modEventBus);
        ArmorMaterialRegistry.ARMOR_MATERIALS.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        ItemRegistry.TABS.register(modEventBus);
        BlockEntityRegistry.BLOCK_ENTITIES.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        SoundRegistry.SOUNDS.register(modEventBus);
    }
}

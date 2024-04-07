package com.example.examplemod;

import net.fabricmc.api.ModInitializer;

public final class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleModCommon.doRegistrations();
    }
}

package com.geckolib.example.examplemod;

import com.geckolib.example.examplemod.platform.PlatformHelper;
import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ServiceLoader;

/// Mod constants class.
///
/// All the mod's shared static instances are stored here
public final class ModConstants {
    public static final String MODID = "examplemod";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    private static final Identifier BASE_ID = Identifier.fromNamespaceAndPath(MODID, "");

    public static final PlatformHelper PLATFORM = ServiceLoader.load(PlatformHelper.class).findFirst().get();

    public static void init() {}

    /// Create a new [Identifier] with this mod's namespace
    public static Identifier id(String path) {
        return BASE_ID.withPath(path);
    }
}

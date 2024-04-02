package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;

public final class EntityRegistry {
	public static final EntityType<BatEntity> BAT = register("bat", BatEntity::new, 0.7f, 1.3f, 0x1F1F1F, 0x0D0D0D);
	public static final EntityType<BikeEntity> BIKE = register("bike", BikeEntity::new, 0.5f, 0.6f, 0xD3E3E6, 0xE9F1F5);
	public static final EntityType<RaceCarEntity> RACE_CAR = register("race_car", RaceCarEntity::new, 1.5f, 1.5f, 0x9E1616, 0x595959);
	public static final EntityType<ParasiteEntity> PARASITE = register("parasite", ParasiteEntity::new, 1.5f, 1.5f, 0x302219, 0xACACAC);
	public static final EntityType<DynamicExampleEntity> MUTANT_ZOMBIE = register("mutant_zombie", DynamicExampleEntity::new, 0.5f, 1.9f, 0x3C6236, 0x579989);
	public static final EntityType<FakeGlassEntity> FAKE_GLASS = register("fake_glass", FakeGlassEntity::new, 1, 1, 0xDD0000, 0xD8FFF7);
	public static final EntityType<CoolKidEntity> COOL_KID = register("cool_kid", CoolKidEntity::new, 0.45f, 1f, 0x5F2A31, 0x6F363E);
    public static final EntityType<DynamicExampleEntity> GREMLIN = register("gremlin", DynamicExampleEntity::new, 0.5f, 1.9f, 0x505050, 0x606060);

	public static void init() {
		AttributeSupplier.Builder genericAttribs = Mob.createMobAttributes()
				.add(Attributes.FOLLOW_RANGE, 16)
				.add(Attributes.MAX_HEALTH, 1);
		AttributeSupplier.Builder genericMovingAttribs = Mob.createMobAttributes()
				.add(Attributes.FOLLOW_RANGE, 16)
				.add(Attributes.MAX_HEALTH, 1)
				.add(Attributes.MOVEMENT_SPEED, 0.25f);
		AttributeSupplier.Builder genericMonsterAttribs = Monster.createMonsterAttributes()
				.add(Attributes.FOLLOW_RANGE, 16)
				.add(Attributes.MAX_HEALTH, 1)
				.add(Attributes.MOVEMENT_SPEED, 0.25f)
				.add(Attributes.ATTACK_DAMAGE, 5)
				.add(Attributes.ATTACK_KNOCKBACK, 0.1);

		FabricDefaultAttributeRegistry.register(EntityRegistry.BIKE, genericAttribs.build());
		FabricDefaultAttributeRegistry.register(EntityRegistry.RACE_CAR, genericAttribs.build());
		FabricDefaultAttributeRegistry.register(EntityRegistry.BAT, genericAttribs.build());
		FabricDefaultAttributeRegistry.register(EntityRegistry.MUTANT_ZOMBIE, genericAttribs.build());
		FabricDefaultAttributeRegistry.register(EntityRegistry.GREMLIN, genericAttribs.build());
		FabricDefaultAttributeRegistry.register(EntityRegistry.COOL_KID, genericMovingAttribs.build());
		FabricDefaultAttributeRegistry.register(EntityRegistry.FAKE_GLASS, genericMovingAttribs.build());
		FabricDefaultAttributeRegistry.register(EntityRegistry.PARASITE, genericMonsterAttribs.build());
	}

	private static <T extends PathfinderMob> EntityType<T> register(String name, EntityType.EntityFactory<T> entity, float width, float height, int primaryEggColor, int secondaryEggColor) {
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(ExampleMod.MODID, name), EntityType.Builder.of(entity, MobCategory.CREATURE).sized(width, height).build(name));
	}
}

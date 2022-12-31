package fuzs.mutantmonsters.init;

import fuzs.mutantmonsters.MutantMonsters;
import fuzs.mutantmonsters.block.MBSkullBlock;
import fuzs.mutantmonsters.block.MBWallSkullBlock;
import fuzs.mutantmonsters.entity.*;
import fuzs.mutantmonsters.entity.mutant.*;
import fuzs.mutantmonsters.entity.projectile.ChemicalXEntity;
import fuzs.mutantmonsters.entity.projectile.MutantArrowEntity;
import fuzs.mutantmonsters.entity.projectile.ThrowableBlockEntity;
import fuzs.mutantmonsters.item.*;
import fuzs.mutantmonsters.tileentity.MBSkullTileEntity;
import fuzs.puzzleslib.core.CommonAbstractions;
import fuzs.puzzleslib.core.CommonFactories;
import fuzs.puzzleslib.init.RegistryManager;
import fuzs.puzzleslib.init.RegistryReference;
import fuzs.puzzleslib.init.builder.ModBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.function.Supplier;

public class ModRegistry {
    private static final CreativeModeTab CREATIVE_MODE_TAB = CommonAbstractions.INSTANCE.creativeTab(MutantMonsters.MOD_ID, new Supplier<>() {
        @Override
        public ItemStack get() {
            return new ItemStack(CHEMICAL_X_ITEM.get());
        }
    });
    private static final RegistryManager REGISTRY = CommonFactories.INSTANCE.registration(MutantMonsters.MOD_ID);
    public static final RegistryReference<Block> MUTANT_SKELETON_SKULL_BLOCK = REGISTRY.registerBlock("mutant_skeleton_skull", () -> new MBSkullBlock(MBSkullBlock.Types.MUTANT_SKELETON, BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
    public static final RegistryReference<Block> MUTANT_SKELETON_WALL_SKULL_BLOCK = REGISTRY.registerBlock("mutant_skeleton_wall_skull", () -> new MBWallSkullBlock(MBSkullBlock.Types.MUTANT_SKELETON, BlockBehaviour.Properties.copy(MUTANT_SKELETON_SKULL_BLOCK.get()).dropsLike(MUTANT_SKELETON_SKULL_BLOCK.get())));
    public static final RegistryReference<EntityType<CreeperMinionEntity>> CREEPER_MINION_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("creeper_minion", () -> EntityType.Builder.of(CreeperMinionEntity::new, MobCategory.MISC).sized(0.3F, 0.85F));
    public static final RegistryReference<EntityType<MutantCreeperEntity>> MUTANT_CREEPER_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("mutant_creeper", () -> EntityType.Builder.of(MutantCreeperEntity::new, MobCategory.MONSTER).sized(1.99F, 2.8F));
    public static final RegistryReference<EntityType<MutantEndermanEntity>> MUTANT_ENDERMAN_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("mutant_enderman", () -> EntityType.Builder.<MutantEndermanEntity>of(MutantEndermanEntity::new, MobCategory.MONSTER).setCustomClientFactory(MutantEndermanEntity::new).sized(1.2F, 4.2F));
    public static final RegistryReference<EntityType<MutantSkeletonEntity>> MUTANT_SKELETON_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("mutant_skeleton", () -> EntityType.Builder.<MutantSkeletonEntity>of(MutantSkeletonEntity::new, MobCategory.MONSTER).setCustomClientFactory(MutantSkeletonEntity::new).sized(1.2F, 3.6F));
    public static final RegistryReference<EntityType<MutantSnowGolemEntity>> MUTANT_SNOW_GOLEM_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("mutant_snow_golem", () -> EntityType.Builder.of(MutantSnowGolemEntity::new, MobCategory.MISC).sized(1.15F, 2.3F));
    public static final RegistryReference<EntityType<MutantZombieEntity>> MUTANT_ZOMBIE_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("mutant_zombie", () -> EntityType.Builder.<MutantZombieEntity>of(MutantZombieEntity::new, MobCategory.MONSTER).setCustomClientFactory(MutantZombieEntity::new).sized(1.8F, 3.2F));
    public static final RegistryReference<EntityType<SpiderPigEntity>> SPIDER_PIG_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("spider_pig", () -> EntityType.Builder.of(SpiderPigEntity::new, MobCategory.CREATURE).sized(1.4F, 0.9F));
    public static final RegistryReference<EntityType<BodyPartEntity>> BODY_PART_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("body_part", () -> EntityType.Builder.<BodyPartEntity>of(BodyPartEntity::new, MobCategory.MISC).setCustomClientFactory(BodyPartEntity::new).setTrackingRange(4).setUpdateInterval(10).sized(0.7F, 0.7F));
    public static final RegistryReference<EntityType<ChemicalXEntity>> CHEMICAL_X_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("chemical_x", () -> EntityType.Builder.<ChemicalXEntity>of(ChemicalXEntity::new, MobCategory.MISC).setCustomClientFactory(ChemicalXEntity::new).setTrackingRange(10).setUpdateInterval(10).sized(0.25F, 0.25F));
    public static final RegistryReference<EntityType<CreeperMinionEggEntity>> CREEPER_MINION_EGG_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("creeper_minion_egg", () -> EntityType.Builder.<CreeperMinionEggEntity>of(CreeperMinionEggEntity::new, MobCategory.MISC).setCustomClientFactory(CreeperMinionEggEntity::new).setTrackingRange(10).setUpdateInterval(20).sized(0.5625F, 0.75F));
    public static final RegistryReference<EntityType<EndersoulCloneEntity>> ENDERSOUL_CLONE_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("endersoul_clone", () -> EntityType.Builder.of(EndersoulCloneEntity::new, MobCategory.MONSTER).sized(0.6F, 2.9F));
    public static final RegistryReference<EntityType<EndersoulFragmentEntity>> ENDERSOUL_FRAGMENT_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("endersoul_fragment", () -> EntityType.Builder.<EndersoulFragmentEntity>of(EndersoulFragmentEntity::new, MobCategory.MISC).setCustomClientFactory(EndersoulFragmentEntity::new).setTrackingRange(4).setUpdateInterval(10).sized(0.75F, 0.75F));
    public static final RegistryReference<EntityType<MutantArrowEntity>> MUTANT_ARROW_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("mutant_arrow", () -> EntityType.Builder.<MutantArrowEntity>of(MutantArrowEntity::new, MobCategory.MISC).setCustomClientFactory(MutantArrowEntity::new).setShouldReceiveVelocityUpdates(false).noSave());
    public static final RegistryReference<EntityType<SkullSpiritEntity>> SKULL_SPIRIT_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("skull_spirit", () -> EntityType.Builder.<SkullSpiritEntity>of(SkullSpiritEntity::new, MobCategory.MISC).setCustomClientFactory(SkullSpiritEntity::new).setTrackingRange(10).setUpdateInterval(20).setShouldReceiveVelocityUpdates(false).sized(0.1F, 0.1F));
    public static final RegistryReference<EntityType<ThrowableBlockEntity>> THROWABLE_BLOCK_ENTITY_TYPE = REGISTRY.registerEntityTypeBuilder("throwable_block", () -> EntityType.Builder.<ThrowableBlockEntity>of(ThrowableBlockEntity::new, MobCategory.MISC).setCustomClientFactory(ThrowableBlockEntity::new).setTrackingRange(4).setUpdateInterval(100).sized(1.0F, 1.0F));
    public static final RegistryReference<Item> CREEPER_MINION_SPAWN_EGG_ITEM = REGISTRY.registerItem("creeper_minion_spawn_egg", () -> new ForgeSpawnEggItem(CREEPER_MINION_ENTITY_TYPE::get, 894731, 12040119, new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_CREEPER_SPAWN_EGG_ITEM = REGISTRY.registerItem("mutant_creeper_spawn_egg", () -> new ForgeSpawnEggItem(MUTANT_CREEPER_ENTITY_TYPE::get, 5349438, 11013646, new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_ENDERMAN_SPAWN_EGG_ITEM = REGISTRY.registerItem("mutant_enderman_spawn_egg", () -> new ForgeSpawnEggItem(MUTANT_ENDERMAN_ENTITY_TYPE::get, 1447446, 8860812, new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_SKELETON_SPAWN_EGG_ITEM = REGISTRY.registerItem("mutant_skeleton_spawn_egg", () -> new ForgeSpawnEggItem(MUTANT_SKELETON_ENTITY_TYPE::get, 12698049, 6310217, new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_SNOW_GOLEM_SPAWN_EGG_ITEM = REGISTRY.registerItem("mutant_snow_golem_spawn_egg", () -> new ForgeSpawnEggItem(MUTANT_SNOW_GOLEM_ENTITY_TYPE::get, 15073279, 16753434, new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_ZOMBIE_SPAWN_EGG_ITEM = REGISTRY.registerItem("mutant_zombie_spawn_egg", () -> new ForgeSpawnEggItem(MUTANT_ZOMBIE_ENTITY_TYPE::get, 7969893, 44975, new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> SPIDER_PIG_SPAWN_EGG_ITEM = REGISTRY.registerItem("spider_pig_spawn_egg", () -> new ForgeSpawnEggItem(SPIDER_PIG_ENTITY_TYPE::get, 3419431, 15771042, new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> CHEMICAL_X_ITEM = REGISTRY.registerItem("chemical_x", () -> new ChemicalXItem(new Item.Properties().tab(CREATIVE_MODE_TAB).stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryReference<Item> CREEPER_MINION_TRACKER_ITEM = REGISTRY.registerItem("creeper_minion_tracker", () -> new Item(new Item.Properties().tab(CREATIVE_MODE_TAB).stacksTo(1)));
    public static final RegistryReference<Item> CREEPER_SHARD_ITEM = REGISTRY.registerItem("creeper_shard", () -> new CreeperShardItem(new Item.Properties().tab(CREATIVE_MODE_TAB).durability(32).rarity(Rarity.UNCOMMON)));
    public static final RegistryReference<Item> ENDERSOUL_HAND_ITEM = REGISTRY.registerItem("endersoul_hand", () -> new EndersoulHandItem(new Item.Properties().tab(CREATIVE_MODE_TAB).durability(240).rarity(Rarity.EPIC)));
    public static final RegistryReference<Item> HULK_HAMMER_ITEM = REGISTRY.registerItem("hulk_hammer", () -> new HulkHammerItem(new Item.Properties().tab(CREATIVE_MODE_TAB).durability(64).rarity(Rarity.UNCOMMON)));
    public static final RegistryReference<Item> MUTANT_SKELETON_ARMS_ITEM = REGISTRY.registerItem("mutant_skeleton_arms", () -> new Item(new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_SKELETON_LIMB_ITEM = REGISTRY.registerItem("mutant_skeleton_limb", () -> new Item(new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_SKELETON_PELVIS_ITEM = REGISTRY.registerItem("mutant_skeleton_pelvis", () -> new Item(new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_SKELETON_RIB_ITEM = REGISTRY.registerItem("mutant_skeleton_rib", () -> new Item(new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_SKELETON_RIB_CAGE_ITEM = REGISTRY.registerItem("mutant_skeleton_rib_cage", () -> new Item(new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_SKELETON_SHOULDER_PAD_ITEM = REGISTRY.registerItem("mutant_skeleton_shoulder_pad", () -> new Item(new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_SKELETON_SKULL_ITEM = REGISTRY.registerItem("mutant_skeleton_skull", () -> new ArmorBlockItem(MBArmorMaterial.MUTANT_SKELETON, MUTANT_SKELETON_SKULL_BLOCK.get(), MUTANT_SKELETON_WALL_SKULL_BLOCK.get(), new Item.Properties().tab(CREATIVE_MODE_TAB).rarity(Rarity.UNCOMMON)));
    public static final RegistryReference<Item> MUTANT_SKELETON_CHESTPLATE_ITEM = REGISTRY.registerItem("mutant_skeleton_chestplate", () -> new SkeletonArmorItem(MBArmorMaterial.MUTANT_SKELETON, EquipmentSlot.CHEST, new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_SKELETON_LEGGINGS_ITEM = REGISTRY.registerItem("mutant_skeleton_leggings", () -> new SkeletonArmorItem(MBArmorMaterial.MUTANT_SKELETON, EquipmentSlot.LEGS, new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<Item> MUTANT_SKELETON_BOOTS_ITEM = REGISTRY.registerItem("mutant_skeleton_boots", () -> new SkeletonArmorItem(MBArmorMaterial.MUTANT_SKELETON, EquipmentSlot.FEET, new Item.Properties().tab(CREATIVE_MODE_TAB)));
    public static final RegistryReference<BlockEntityType<MBSkullTileEntity>> SKULL_BLOCK_ENTITY_TYPE = REGISTRY.registerBlockEntityTypeBuilder("skull", () -> ModBlockEntityTypeBuilder.of(MBSkullTileEntity::new, MUTANT_SKELETON_SKULL_BLOCK.get(), MUTANT_SKELETON_WALL_SKULL_BLOCK.get()));
    public static final RegistryReference<SimpleParticleType> ENDERSOUL_PARTICLE_TYPE = REGISTRY.register(Registry.PARTICLE_TYPE_REGISTRY, "endersoul", () -> new SimpleParticleType(false));
    public static final RegistryReference<SimpleParticleType> SKULL_SPIRIT_PARTICLE_TYPE = REGISTRY.register(Registry.PARTICLE_TYPE_REGISTRY, "skull_spirit", () -> new SimpleParticleType(true));
    public static final RegistryReference<SoundEvent> ENTITY_CREEPER_MINION_AMBIENT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.creeper_minion.ambient");
    public static final RegistryReference<SoundEvent> ENTITY_CREEPER_MINION_DEATH_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.creeper_minion.death");
    public static final RegistryReference<SoundEvent> ENTITY_CREEPER_MINION_HURT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.creeper_minion.hurt");
    public static final RegistryReference<SoundEvent> ENTITY_CREEPER_MINION_PRIMED_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.creeper_minion.primed");
    public static final RegistryReference<SoundEvent> ENTITY_CREEPER_MINION_EGG_HATCH_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.creeper_minion_egg.hatch");
    public static final RegistryReference<SoundEvent> ENTITY_ENDERSOUL_CLONE_TELEPORT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.endersoul_clone.teleport");
    public static final RegistryReference<SoundEvent> ENTITY_ENDERSOUL_CLONE_DEATH_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.endersoul_clone.death");
    public static final RegistryReference<SoundEvent> ENTITY_ENDERSOUL_FRAGMENT_EXPLODE_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.endersoul_fragment.explode");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_CREEPER_AMBIENT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_creeper.ambient");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_CREEPER_CHARGE_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_creeper.charge");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_CREEPER_DEATH_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_creeper.death");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_CREEPER_HURT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_creeper.hurt");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_CREEPER_PRIMED_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_creeper.primed");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ENDERMAN_AMBIENT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_enderman.ambient");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ENDERMAN_DEATH_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_enderman.death");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ENDERMAN_HURT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_enderman.hurt");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ENDERMAN_MORPH_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_enderman.morph");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ENDERMAN_SCREAM_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_enderman.scream");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ENDERMAN_STARE_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_enderman.stare");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ENDERMAN_TELEPORT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_enderman.teleport");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_SKELETON_AMBIENT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_skeleton.ambient");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_SKELETON_DEATH_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_skeleton.death");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_SKELETON_HURT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_skeleton.hurt");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_SKELETON_STEP_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_skeleton.step");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_SNOW_GOLEM_DEATH_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_snow_golem.death");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_SNOW_GOLEM_HURT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_snow_golem.hurt");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ZOMBIE_AMBIENT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_zombie.ambient");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ZOMBIE_ATTACK_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_zombie.attack");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ZOMBIE_DEATH_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_zombie.death");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ZOMBIE_GRUNT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_zombie.grunt");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ZOMBIE_HURT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_zombie.hurt");
    public static final RegistryReference<SoundEvent> ENTITY_MUTANT_ZOMBIE_ROAR_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.mutant_zombie.roar");
    public static final RegistryReference<SoundEvent> ENTITY_SPIDER_PIG_AMBIENT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.spider_pig.ambient");
    public static final RegistryReference<SoundEvent> ENTITY_SPIDER_PIG_DEATH_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.spider_pig.death");
    public static final RegistryReference<SoundEvent> ENTITY_SPIDER_PIG_HURT_SOUND_EVENT = REGISTRY.registerRawSoundEvent("entity.spider_pig.hurt");

    public static final TagKey<Block> MUTANT_ENDERMAN_HOLABLE = BlockTags.create(MutantMonsters.id("mutant_enderman_holdable"));
    public static final TagKey<Block> ENDERSOUL_HAND_HOLDABLE = BlockTags.create(MutantMonsters.id("endersoul_hand_holdable"));

    public static void touch() {

    }
}
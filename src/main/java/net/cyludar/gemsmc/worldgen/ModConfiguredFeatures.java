package net.cyludar.gemsmc.worldgen;

import net.cyludar.gemsmc.block.ModBlocks;
import net.cyludar.gemsmc.GemsMC;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_JADE_ORE_KEY = registerKey("jade_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BLACK_OPAL_ORE_KEY = registerKey("black_opal_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_AVENTURINE_ORE_KEY = registerKey("aventurine_ore");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldJadeOres = List.of(OreConfiguration.target(stoneReplaceables,
                ModBlocks.JADE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_JADE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldBlackOpalOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldAventurineOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.AVENTURINE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_AVENTURINE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_JADE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldJadeOres, 6, 0.3f));
        register(context, OVERWORLD_BLACK_OPAL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBlackOpalOres, 9));
        register(context, OVERWORLD_AVENTURINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAventurineOres, 6, 0.3f));

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(GemsMC.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

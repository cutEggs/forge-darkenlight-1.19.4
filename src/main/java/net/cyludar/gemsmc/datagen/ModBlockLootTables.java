package net.cyludar.gemsmc.datagen;


import net.cyludar.gemsmc.block.ModBlocks;
import net.cyludar.gemsmc.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.JADE_BLOCK.get());
        dropSelf(ModBlocks.BLACK_OPAL_BLOCK.get());
        dropSelf(ModBlocks.AVENTURINE_BLOCK.get());

        add(ModBlocks.JADE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.JADE_ORE.get(), ModItems.JADE.get()));
        add(ModBlocks.DEEPSLATE_JADE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_JADE_ORE.get(), ModItems.JADE.get()));
        add(ModBlocks.BLACK_OPAL_ORE.get(),
                (block) -> createOreDrop(ModBlocks.BLACK_OPAL_ORE.get(), ModItems.BLACK_OPAL.get()));
        add(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get(), ModItems.BLACK_OPAL.get()));
        add(ModBlocks.AVENTURINE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.AVENTURINE_ORE.get(), ModItems.AVENTURINE.get()));
        add(ModBlocks.DEEPSLATE_AVENTURINE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_AVENTURINE_ORE.get(), ModItems.AVENTURINE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

package net.cyludar.gemsmc.block;

import net.cyludar.gemsmc.GemsMC;
import net.cyludar.gemsmc.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GemsMC.MOD_ID);


    public static final  RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST).strength(30)));
    public static final  RegistryObject<Block> JADE_ORE = registerBlock("jade_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(30)
                    .requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final  RegistryObject<Block> DEEPSLATE_JADE_ORE = registerBlock("deepslate_jade_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(30)
                    .requiresCorrectToolForDrops(), UniformInt.of(1, 3)));

    public static final RegistryObject<Block> BLACK_OPAL_BLOCK = registerBlock("black_opal_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BLACK_OPAL_ORE = registerBlock("black_opal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> DEEPSLATE_BLACK_OPAL_ORE = registerBlock("deepslate_black_opal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(8f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    public static final  RegistryObject<Block> AVENTURINE_BLOCK = registerBlock("aventurine_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST).strength(30)));
    public static final  RegistryObject<Block> AVENTURINE_ORE = registerBlock("aventurine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(15)
                    .requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final  RegistryObject<Block> DEEPSLATE_AVENTURINE_ORE = registerBlock("deepslate_aventurine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(15)
                    .requiresCorrectToolForDrops(), UniformInt.of(1, 3)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T>block){

        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){

       return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }



    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}

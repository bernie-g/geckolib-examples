package com.geckolib.example.examplemod.item;

import com.geckolib.example.examplemod.ModConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class FertilizerItem extends BlockItem {
    public FertilizerItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Deprecated
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        tooltip.accept(Component.translatable("item." + ModConstants.MODID + ".fertilizer.tooltip"));

        super.appendHoverText(itemStack, context, display, tooltip, flag);
    }
}

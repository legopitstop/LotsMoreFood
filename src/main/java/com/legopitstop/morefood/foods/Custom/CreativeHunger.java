package com.legopitstop.morefood.foods.Custom;

import com.legopitstop.morefood.MoreFood;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class CreativeHunger extends Item {

    public CreativeHunger() {
        super(new Properties()
        .group(MoreFood.TAB)
        .food(new Food.Builder()
                .hunger(0)
                .saturation(0f)
                .setAlwaysEdible()
                .effect(new EffectInstance(Effects.HUNGER, 2*20, 255), 1.0F)
                .build())

        );

    }
    // desc lines at bottom
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(this.func_219981_d_().mergeStyle(TextFormatting.RED));
    }

    @OnlyIn(Dist.CLIENT)
    public IFormattableTextComponent func_219981_d_() {
        return new TranslationTextComponent(this.getTranslationKey() + ".desc");
    }
}
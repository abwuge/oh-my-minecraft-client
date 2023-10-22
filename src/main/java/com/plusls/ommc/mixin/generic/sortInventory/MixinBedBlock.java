package com.plusls.ommc.mixin.generic.sortInventory;

import com.plusls.ommc.api.sortInventory.IDyeBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BedBlock.class)
public class MixinBedBlock implements IDyeBlock {
    @Shadow
    @Final
    private DyeColor color;

    @Override
    public DyeColor ommc$getColor() {
        return this.color;
    }
}
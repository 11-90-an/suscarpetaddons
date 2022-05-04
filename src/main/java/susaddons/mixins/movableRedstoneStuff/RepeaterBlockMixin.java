package susaddons.mixins.movableRedstoneStuff;

import susaddons.SusAddonsSettings;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RepeaterBlock;
import net.minecraft.block.piston.PistonBehavior;

import org.spongepowered.asm.mixin.Mixin;

@Mixin(RepeaterBlock.class)
public class RepeaterBlockMixin extends Block {
    public RepeaterBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        if (SusAddonsSettings.movableRedstoneStuff) {
            return PistonBehavior.NORMAL;
        } 
        else {
            return PistonBehavior.DESTROY;
        }
    }
}
package susaddons.mixins.movableRedstoneStuff;

import susaddons.SusAddonsSettings;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.block.piston.PistonBehavior;

import org.spongepowered.asm.mixin.Mixin;

@Mixin(RedstoneTorchBlock.class)
public class RedstoneTorchBlockMixin extends Block {
    public RedstoneTorchBlockMixin(Settings settings) {
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
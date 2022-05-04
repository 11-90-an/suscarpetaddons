package susaddons.mixins.comparatorReadThroughOthers;

import susaddons.SusAddonsSettings;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComparatorBlock;
import net.minecraft.block.PistonBlock;
import net.minecraft.world.BlockView;
import net.minecraft.util.math.BlockPos;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/* ty crec */

@Mixin(ComparatorBlock.class)
public class ComparatorMixin {
    @Redirect(method = "getPower", at = @At(value = "INVOKE", target = "net/minecraft/block/BlockState.isSolidBlock(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Z"))
    public boolean comparator(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        if (SusAddonsSettings.comparatorReadThroughOthers) {
            return readThroughStuff(blockState, blockView, blockPos);
        }
        return blockState.isSolidBlock(blockView, blockPos);
    }
    
    public boolean readThroughStuff(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return blockState.isOf(Blocks.CHAIN) || weCheckIfPiston(blockState) || blockState.isSolidBlock(blockView, blockPos);
    }

    private boolean weCheckIfPiston(BlockState blockState) {
        return (blockState.isOf(Blocks.PISTON) || blockState.isOf(Blocks.STICKY_PISTON)) && !blockState.get(PistonBlock.EXTENDED);
    }
}
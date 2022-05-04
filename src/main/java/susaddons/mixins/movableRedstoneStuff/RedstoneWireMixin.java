package susaddons.mixins.movableRedstoneStuff;

import susaddons.SusAddonsSettings;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(RedstoneWireBlock.class)
public class RedstoneWireMixin extends Block {
    public RedstoneWireMixin(Settings settings) {
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

    @Inject(method = "neighborUpdate", 
            require = 1, 
            at = @At(value = "INVOKE", 
                target = "Lnet/minecraft/block/AbstractRailBlock;updateBlockState(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/Block;)V"
                ),
            cancellable = true
    )
    private void IfRailIsSetCorrectly(BlockState state, World world, BlockPos pos, Block block, BlockPos neighborPos, boolean moved, CallbackInfo ci) {
        if (SusAddonsSettings.movableRedstoneStuff && !(world.getBlockState(pos).getBlock() instanceof RedstoneWireBlock)) {
            ci.cancel();
        }
    }
}
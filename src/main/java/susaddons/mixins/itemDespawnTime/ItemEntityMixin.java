package susaddons.mixins.itemDespawnTime;

import susaddons.SusAddonsSettings;

import net.minecraft.entity.ItemEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/* much yoinking from carpet-extra and help from crec <3 */

@Mixin(ItemEntity.class)
public class ItemEntityMixin {
    @ModifyConstant(method = "tick", constant = @Constant(intValue = 6000))
    private int changeDespawnTime(int original) {
        if (SusAddonsSettings.itemDespawnTimeLength > 0) {
            return SusAddonsSettings.itemDespawnTimeLength;
        }
        else {
            return original;
        }
    }
}
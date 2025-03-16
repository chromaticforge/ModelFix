package com.github.chromaticforge.modelfix.mixins;

import com.github.chromaticforge.modelfix.hook.ItemModelGeneratorHook;
import net.minecraft.client.renderer.block.model.BlockPart;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemModelGenerator.class)
public class ItemModelGeneratorMixin {
    @Inject(method = "func_178397_a", at = @At("HEAD"), cancellable = true)
    private void generateModel(TextureAtlasSprite textureAtlasSprite, String string, int i, CallbackInfoReturnable<List<BlockPart>> cir) {
        cir.setReturnValue(ItemModelGeneratorHook.generateModel(textureAtlasSprite, string, i));
    }
}

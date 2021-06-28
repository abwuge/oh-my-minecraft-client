package com.plusls.ommc.mixin.feature.malilib;

import com.plusls.ommc.feature.sortInventory.MyKeybindMulti;
import fi.dy.masa.malilib.hotkeys.KeybindMulti;
import fi.dy.masa.malilib.util.GuiUtils;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = KeybindMulti.class, remap = false)
public class MixinKeybindMulti implements MyKeybindMulti {
    boolean allowInScreen;

    @Redirect(method = "updateIsPressed", at = @At(value = "INVOKE", target = "Lfi/dy/masa/malilib/util/GuiUtils;getCurrentScreen()Lnet/minecraft/client/gui/screen/Screen;"))
    // @Redirect(method = "updateIsPressed", at = @At(value = "INVOKE", target = "Lfi/dy/masa/malilib/util/GuiUtils;getCurrentScreen()Lnet/minecraft/class_437;"))
    private Screen allowDetectKeyInScreen() {
        Screen ret = GuiUtils.getCurrentScreen();
        if (allowInScreen) {
            if (!(ret instanceof ChatScreen)) {
                ret = null;
            }
        }
        return ret;
    }

    @Override
    public void allowInScreen() {
        allowInScreen = true;
    }
}

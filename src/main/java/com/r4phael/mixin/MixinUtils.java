package com.r4phael.mixin;

import gtPlusPlus.core.util.Utils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Utils.class)
public class MixinUtils {

    @Redirect(method = "getWrittenBook", at = @At(
            value = "INVOKE",
            target = "Lgregtech/api/util/GT_LanguageManager;addStringLocalization(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            remap = false
    ), remap = false)
    private static String redirect_addStringLocalization(String key, String value) {
        return value;
    }

}

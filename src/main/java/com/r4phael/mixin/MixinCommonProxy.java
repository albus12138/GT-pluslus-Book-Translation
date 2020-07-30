package com.r4phael.mixin;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import gtPlusPlus.core.common.CommonProxy;
import gtPlusPlus.core.lib.CORE;
import net.minecraftforge.common.config.Configuration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(CommonProxy.class)
public class MixinCommonProxy {

    @Inject(method = "preInit", at = @At(
            value = "HEAD",
            remap = false
    ), remap = false)
    public void onPreInit(FMLPreInitializationEvent event, CallbackInfo ci) {
        if (CORE.Config == null) {
            CORE.Config = new Configuration(new File(event.getModConfigurationDirectory(), "GTplusplus/ManualTranslation.cfg"));
            CORE.Config.load();
        }
    }

}

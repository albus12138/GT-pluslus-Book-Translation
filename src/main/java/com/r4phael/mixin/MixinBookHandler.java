package com.r4phael.mixin;

import gtPlusPlus.core.handler.BookHandler;

import gtPlusPlus.core.lib.CORE;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.ArrayList;

@Mixin(BookHandler.class)
public class MixinBookHandler {

	private static String errInfo;
	private static boolean needInit = false;

	@Inject(method = "run", at = @At(
			value = "HEAD",
			remap = false
	), remap = false, cancellable = true)
	private static void onRun(CallbackInfo ci) {
		needInit = CORE.Config.getBoolean("needInit", "info", false, "是否需要初始化该文件");
		errInfo = CORE.Config.getString("errorInfo", "info", "Something Wrong Here, Please Contact Translator", "错误反馈提示");
	}

	@Inject(method = "run", at = @At(
			value = "RETURN",
			remap = false
	), remap = false, cancellable = true)
	private static void postRun(CallbackInfo ci) {
		if (needInit) CORE.Config.save();
		CORE.Config = null;
	}

	@ModifyArgs(method = "run", at = @At(
			value = "INVOKE",
			target = "LgtPlusPlus/core/handler/BookHandler;writeBookTemplate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)LgtPlusPlus/core/handler/BookHandler$BookTemplate;",
			remap = false
	), remap = false)
	private static void modifyArgs_writeBookTemplate(Args args) {
		String mapping = args.get(0).toString().replace("_", "");
		if (needInit) {
			ArrayList<String> pages = new ArrayList<String>();
			for (String page: (String[]) args.get(3)) pages.add(page.replace("\n", "[CR]"));
			CORE.Config.getString("title", mapping, args.get(1).toString(), "Translation of Title");
			CORE.Config.getStringList("pages", mapping, pages.toArray(new String[pages.size()]), "Translation of Pages");
			CORE.Config.getStringList("pages", mapping, new String[] {}, "Translation of Pages");
		} else {
			ArrayList<String> pages = new ArrayList<String>();
			for (String page: CORE.Config.getStringList("pages", mapping, new String[] {errInfo}, "Translation of Pages"))
				pages.add(page.replace("[CR]", "\n"));
			args.set(1, CORE.Config.getString("title", mapping, errInfo, "Translation of Title"));
			args.set(3, pages.toArray(new String[pages.size()]));
		}
	}

}
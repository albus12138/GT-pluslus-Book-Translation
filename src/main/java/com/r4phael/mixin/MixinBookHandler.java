package com.r4phael.mixin;

import gregtech.api.util.GT_LanguageManager;
import gtPlusPlus.core.handler.BookHandler;

import net.minecraftforge.common.config.Property;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.ArrayList;

@Mixin(BookHandler.class)
public class MixinBookHandler {

	@ModifyArgs(method = "run", at = @At(
			value = "INVOKE",
			target = "LgtPlusPlus/core/handler/BookHandler;writeBookTemplate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)LgtPlusPlus/core/handler/BookHandler$BookTemplate;",
			remap = false
	), remap = false)
	private static void modifyArgs_writeBookTemplate(Args args) {
		if (GT_LanguageManager.sEnglishFile == null) {
			System.out.println("GregTech.lang not found!");
			return;
		}

		String title = args.get(1).toString();
		Property property = GT_LanguageManager.sEnglishFile.get("LanguageFile", String.format("Book.%s.Name", title), title);
		args.set(1, property.getString());

		int page_num = 0;
		ArrayList<String> pages = new ArrayList<String>();
		for (String page: (String[]) args.get(3)) {
			String no_cr_page = page.replace("\n", "[CR]");
			property = GT_LanguageManager.sEnglishFile.get("LanguageFile", String.format("Book.%s.Page%02d", title, page_num), no_cr_page);
			pages.add(property.getString().replace("[CR]", "\n"));
			page_num++;
		}
		args.set(3, pages.toArray(new String[pages.size()]));
	}

}
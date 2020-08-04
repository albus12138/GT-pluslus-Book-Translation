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

		ArrayList<String> pages = new ArrayList<String>();
		int PAGE_NUM = GT_LanguageManager.sEnglishFile.getInt(String.format("Book.%s.APageNum", title), "LanguageFile", ((String[]) args.get(3)).length, 1, 48, "定义手册页数，增减手册页数后修改本参数");
		String[] raw_pages = args.get(3);
		for (int page_num=0; page_num < PAGE_NUM; page_num++) {
			String page = page_num < raw_pages.length ? raw_pages[page_num] : "Empty Page, Please check PageNum in GregTech.lang!";
			String no_cr_page = page.replace("\n", "[CR]");
			property = GT_LanguageManager.sEnglishFile.get("LanguageFile", String.format("Book.%s.Page%02d", title, page_num), no_cr_page);
			pages.add(property.getString().replace("[CR]", "\n"));
		}
		args.set(3, pages.toArray(new String[pages.size()]));
	}

}
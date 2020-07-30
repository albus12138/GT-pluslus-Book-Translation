package com.r4phael.mixin;

import gtPlusPlus.api.objects.Logger;
import gtPlusPlus.core.handler.BookHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.transformer.meta.MixinInner;

@Mixin(BookHandler.BookTemplate.class)
public class MixinBookTemplate {
    public final String mAuthor;
    public final String mMapping;
    public final int mMeta;
    public final String[] mPages;
    public final String mTitle;

    public MixinBookTemplate(int aMeta, String aMapping, String aTitle, String aAuthor, String[] aPages) {
        this.mMeta = aMeta;
        this.mMapping = aMapping;
        this.mTitle = aTitle;
        this.mAuthor = aAuthor;
        this.mPages = aPages;
        Logger.INFO("Mixin BookTemplate");
    }
}

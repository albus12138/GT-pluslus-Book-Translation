# GT-pluslus-Book-Translation
基于 Sponge Mixin 框架翻译 GT++ 手册中硬编码内容

由于语言文件加 key 出现问题，采用 config 文件作为翻译文本存储。（希望知道怎么加key的大佬可以帮助我完善本工具）

## 使用方法

- 导出待翻译文本：添加如下配置文件到对应路径，将 `GT-PlusPlus-Book-Translation.jar` 添加到 `mods` 文件夹，运行游戏，修改 `needInit` 配置项为 `false` 完成导出工作。游戏加载完成即可退出，待翻译文本会添加至该配置文件。

```
# .minecraft/config/GTplusplus/ManualTranslation.cfg
# Configuration file

info {
    # 错误反馈提示 [default: Something Wrong Here, Please Contact Translator]
    S:errorInfo=GTPP手册汉化出错，请反馈到 https://github.com/albus12138/GT-pluslus-Book-Translation

    # 是否需要初始化该文件 [default: false]
    B:needInit=true
}
```

- 翻译说明

    - 文本中 `[CR]` 为手册中换行符替换，如无需调整手册排版，请不要修改。

    - 配置文件中每一行代表游戏中手册一页，请注意内容长度。

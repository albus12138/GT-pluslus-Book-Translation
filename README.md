# GT-pluslus-Book-Translation
基于 Sponge Mixin 框架翻译 GT++ 手册中硬编码内容

使用 GregTech.lang 作为汉化文本存储，通过该文件初始化 GT++ 手册内容，并移除 GT++ 原本添加语言key的代码。（原代码无法汉化手册名称，同时在单页多行文本时会损坏 GregTech.lang）

## 使用方法

- 将 `GT-PlusPlus-Book-Translation.jar` 添加到 `mods` 文件夹，运行游戏，游戏加载完成后会将 GT++ 手册内容添加到 `GregTech.lang` ，汉化时修改其中内容即可。完成汉化后再次运行游戏即可看到汉化后手册。

![](https://raw.githubusercontent.com/albus12138/GT-pluslus-Book-Translation/master/GregTech.lang.png)

- 翻译说明

    - 文本中 `[CR]` 为手册中换行符替换，如无需调整手册排版，请不要修改。

    - 请保持手册原有页数，不要增加或删除页面
# GT-pluslus-Book-Translation
基于 Sponge Mixin 框架翻译 GT++ 手册中硬编码内容

使用 GregTech.lang 作为汉化文本存储，通过该文件初始化 GT++ 手册内容，并移除 GT++ 原本添加语言key的代码。（原代码无法汉化手册名称，同时在单页多行文本时会损坏 GregTech.lang）

## 使用方法

- 将 `GT-PlusPlus-Book-Translation.jar` 添加到 `mods` 文件夹，运行游戏，游戏加载完成后会将 GT++ 手册内容添加到 `GregTech.lang` ，汉化时修改其中内容即可。完成汉化后再次运行游戏即可看到汉化后手册。

![](https://raw.githubusercontent.com/albus12138/GT-pluslus-Book-Translation/master/GregTech.lang.png)

- 翻译说明

    - 文本中 `[CR]` 为手册中换行符替换，如无需调整手册排版，请不要修改。

    - 增减手册页面时，不要忘记修改 APageNum 配置（由于页面从0开始计数，请修改为最大页码数+1）

    - 如发现手册末尾页面为 `Empty Page, Please check PageNum in GregTech.lang!`，说明 APageNum 参数设置过大，请修改该参数，并删除自动生成的空页面
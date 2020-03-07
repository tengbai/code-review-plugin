IDEA 知识点

### 01, Tool Window 的介绍

在 IDEA 工具左、下、右的部分都是 Tool Window。通过这些 Tool Window 能够从不同的视角来查看项目。比如：项目管理、源代码搜索、导航，Run、Debug等。

![](https://resources.jetbrains.com/help/img/idea/2019.3/toolwindow.png)


** Tool Window ***

每个 Tool Window 都有两个 tool window group，一个是主要的，一个是次要的，但是每次只有一个能够获取鼠标焦点。

每个每个 Tool window 可有有多个 tab。例如：Run 工具窗中通过不同的 tab 为不同的配置的单独显示。

插件中使用 Tool window 主要有两种场景:

(1) 通过 Tool Window bar 上的 button 被点击后显示 Tool window。

(2) 通过 Tool Window 来显示展示结果，然后就可以将其关闭，例如：`Analysis Dependency`

第一种场景，需要 tool window 在 plugin.xml 中注册，使用 com.intellij.toolWindow 扩展点。这个扩展点属性提供了所有需要显示的数据。

|属性|描述|
|----|----|
| id| tool window 的ID
| anchor | Tool window 显示的位置：left , bottom, right |
| secondary | 指定 tool window 显示在 主要的还是次要的 tool window 组中
| icon | tool window 的图标 13 x 13 px

在此之上，创建一个实现了 ToolWindowFactory 接口的工厂类，当用户点击 tool window button 的时候，将会调用 createToolWindowContent() 方法，并初始化 tool window 的UI界面。

Tool window 可以面向整个项目，也可以面向特定的目录、文件，通过 conditionClass 属性类指定实现了 Condition 接口的类名。

第二种方法涉及到在你的插件代码中简单地调用 ToolWindowManager.registerToolWindow(); 

**Tool Window Bar 和 Button**

![](https://resources.jetbrains.com/help/img/idea/2019.3/tool_window_bar_and_buttons.png)

更多关于 Tool Window 资料：

[(1) Tool Window](https://www.jetbrains.com/help/idea/tool-windows.html)

[(2) Tool Window In SDK](https://www.jetbrains.org/intellij/sdk/docs/user_interface_components/tool_windows.html?search=window)

---



### 02, 光标 Position

由于文档中部分内容是可以折叠的(例如：import 部分)，光标在编辑器中的问题也就有了两种，一种是逻辑位置，另一种是视觉位置。

逻辑位置是光标实际所在的行数。

视觉位置只将折叠部分的多行视为一行来得到的位置。例如：一个 java 文件一共 20 行，java import 部分这得了 5 行，那么一个实际在 12 行的光标，得到的视觉位置是 （ 12 - 5）= 7 行。

另外，不管是逻辑位置，还是视觉位置，行号都是从 0 开始的。 即 L0 就是第一行。如下图就是编辑器行和列的坐标关系。

![](https://www.jetbrains.org/intellij/sdk/docs/tutorials/editor_basics/img/editor_coords.png)

更多资料：[Editor Coordinate Systems - Caret Positions and Offsets](https://www.jetbrains.org/intellij/sdk/docs/tutorials/editor_basics/coordinates_system.html?search=Position)



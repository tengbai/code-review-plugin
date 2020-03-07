IDEA 知识点

### 01, 光标 Position

由于文档中部分内容是可以折叠的(例如：import 部分)，光标在编辑器中的问题也就有了两种，一种是逻辑位置，另一种是视觉位置。

逻辑位置是光标实际所在的行数。

视觉位置只将折叠部分的多行视为一行来得到的位置。例如：一个 java 文件一共 20 行，java import 部分这得了 5 行，那么一个实际在 12 行的光标，得到的视觉位置是 （ 12 - 5）= 7 行。

另外，不管是逻辑位置，还是视觉位置，行号都是从 0 开始的。 即 L0 就是第一行。如下图就是编辑器行和列的坐标关系。

![](https://www.jetbrains.org/intellij/sdk/docs/tutorials/editor_basics/img/editor_coords.png)

更多资料：[Editor Coordinate Systems - Caret Positions and Offsets](https://www.jetbrains.org/intellij/sdk/docs/tutorials/editor_basics/coordinates_system.html?search=Position)



### 依赖
* java 8
* gradle 4.10
### 目录结构
* action： 用户与idea的交互
* constants：代码中的常量
* store：数据
* ui: 前端样式
* utils: 公用方法

### 打包部署
1.运行./gradlew buildPlugin, 将插件项目打包

2.在idea插件配置里上传打包好的插件

![image.png](./readme_pic_1.jpg)

![image.png](./readme_pic_2.png)

3.重启idea


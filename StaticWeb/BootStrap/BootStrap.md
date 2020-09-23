# BootStrap

## 概念

- 前端开发框架；
- Bootstrap，来自 Twitter，是目前很受欢迎的前端框架；
- Bootstrap 是基于 HTML、CSS、JavaScript 的，它简洁灵活，使得 Web 开发更加快捷
  - 优点
    - 定义了很多的css样式和js插件。我们开发人员直接可以使用这些样式和插件得到丰富的页面效果；
    - 响应式布局（同一套页面可以兼容不同分辨率的设备）

## 快速入门

1. 下载Bootstrap
2. 在项目中将这三个文件夹复制
3. 创建html页面，引入必要的资源文件

```javascript
<!DOCTYPE html>
	<html lang="zh-CN">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	    <title>Bootstrap HelloWorld</title>
	
	    <!-- Bootstrap -->
	    <link href="css/bootstrap.min.css" rel="stylesheet">
            <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	    <script src="js/jquery-3.2.1.min.js"></script>
	    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	    <script src="js/bootstrap.min.js"></script>
	</head>
	<body>
	<h1>你好，世界！</h1>
	
	</body>
	</html>
```

## 响应式布局

- 利用响应式布局可以实现通过一套页面兼容不同分辨率的设备

  ### 实现步骤

  1. 定义容器（相当于之前的table）

     容器分类：

     - container：两边留白（非最小情况下）
     - container-fluid：每种设备都是100%宽度

  2. 定义行（相当于之前的tr   样式 row）

  3. 定义元素

     - 定义元素指的是，指定该元素在不同设备上所占的格子数目。
     - 样式： col -设备代号 - 格子数目

     设备代号：

     1. xs：超小屏幕 手机 (<768px)：col-xs-12
     2. sm：小屏幕 平板 (≥768px)
     3.  md：中等屏幕 桌面显示器 (≥992px)
     4. lg：大屏幕 大桌面显示器 (≥1200px)

  > 注意：
  >
  > 1. 一行中如果格子数目超过12，则超出部分自动换行
  > 2. 栅格类属性可以向上兼容。栅格类适用于与屏幕宽度大于或等于分界点大小的设备
  > 3. 如果真实设备宽度小于了设置栅格类属性的设备代码的最小值，会一个元素沾满一整行

  ### CSS样式和Javascript插件

  1. 全局CSS样式

     - 按钮

       `class="btn btn-default"`

     - 图片

       ```javascript
       class="img-responsive //图片在任意尺寸都占100%`
       //图片形状:
       <img src="..." alt="..." class="img-rounded">//方形
       <img src="..." alt="..." class="img-circle"> // 圆形
       <img src="..." alt="..." class="img-thumbnail"> //相框
       ```

     - 表格

       ```javascript
       table
       table-bordered
       table-hover
       ```

     - 表单

       `给表单添加 class = "form-control"`

  2. 组件（会用）

     - 导航条

     - 分页条

  3. 插件

     - 轮播图

  

  
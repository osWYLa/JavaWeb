# XML

## 概念

- XML: Extensible Markup Language 可扩展标记语言

  > 可扩展：标签都是自定义的。 <user>  <student>

- 功能

  - 存储数据
    - 配置文件
    - 网络传输

- XML VS HTML
  1. xml标签都是自定义的，html标签是预定义。
  2. xml的语法严格，html语法松散
  3. xml是存储数据的，html是展示数据

## 语法

- 基本语法

  1. xml文档的后缀名 .xml
  2. xml第一行必须定义为文档声明
  3. xml文档中有且仅有一个根标签
  4. 属性值必须使用引号(单双都可)引起来
  5. 标签必须正确关闭
  6. xml标签名称区分大小写

- 快速入门（实例程序）

  ```xml
  <?xml version='1.0' ?>
  <users>
      <user id='1'>
          <name>zhangsan</name>
          <age>23</age>
          <gender>male</gender>
          <br/>
      </user>
  
      <user id='2'>
          <name>lisi</name>
          <age>24</age>
          <gender>female</gender>
      </user>
  </users>
  ```

- 组成部分

  1. 文档声明

     1. 格式:<?xml 属性列表 ?>
     2. 属性列表
        - version：版本号，必须声明的属性（1.0）
        - encoding：编码方式（默认值：ISO-8859-1）
        - standalone: 是否独立（是否依赖其他文件）

  2. 指令（结合CSS）[xml设计之初是为了取代HTML的]

     `<?xml-stylesheet type="text/css" href="a.css" ?>`

  3. 标签（标签名称可以自定义）

     规则：

     -  名称可以包含字母、数字以及其他的字符 
     -  名称不能以数字或者标点符号开始 
     -  名称不能以字母 xml（或者 XML、Xml 等等）开始 
     -  名称不能包含空格
     
  4. 属性

     - id 属性值唯一

  5. 文本

     - CDATA区的数据会被原样显示

       ` <![CDATA[ 数据 ]]>`

- **约束（规定xml文档的书写规则）**

  - 要求：

    - 能够在xml中引入约束文档；
    - 能够基本读懂约束文档；

  - 约束分类

    1. DTD约束：较为简单的约束技术（存在较大的问题）

       DTD约束（属性内容并不能被DTD很好的约束）

       1. 内部DTD约束：将约束文档定义在xml文档中；

       2. 外部DTD约束：将约束文档定义在外部的DTD文件中；

          - 本地位置：

            `<!DOCTYPE 根标签名 SYSTEM "dtd文件的位置">`

          - 网络位置：

            `<!DOCTYPE 根标签名 PUBLIC "dtd文件名字" "dtd文件的位置URL">`

    2. Schema约束：较为复杂的约束技术

       1. Schema约束的引入

          > 1. 填写xml文档的根元素；
          >
          > 2. 引入xsi前缀：
          >
          >    `xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"`
          >
          > 3. 引入xsd文件命名空间：
          >
          >    `xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd"`
          >
          > 4. 为每一个xsd约束声明一个前缀，作为标识：
          >
          >    `xmlns="http://www.itcast.cn/xml" `
          >
          > 如：
          >
          > ```xml
          > <students   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          > 			xmlns="http://www.itcast.cn/xml"
          > 			xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd">
          > </students>
          > 
          > ```

          

## 解析

- 操作XML文档，将文档中的数据读取到内存中

  - 操作XML文档

    - 解析（读取）：将文档中的数据读取到内存中；
    - 写入：将内存中的数据保存到xml文件中（做持久化存储）

  - 解析XML方式

    1. DOM方式：
       - 将标记语言文档一次性加载至内存，在内存中形成一棵DOM树
         - 优点：操作方便，可以对文档进行ＣＲＵＤ操作；
         - 缺点：占内存；
       
    2. SAX方式:
   - 逐行读取,基于事件驱动(设置事件监听器)
      - 优点:不占内存;
         - 缺点:只能读取,不能增删改
      
  
- xml常见解析器

  1. JAXP:sun公司提供的解析器，支持dom和sax两种思想（几乎不使用）
  2. DOM4J：一款非常优秀的解析器（DOM思想实现）
  3. Jsoup：jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
  4. PULL：Android操作系统内置的解析器，sax方式的。

- Jsoup

  - jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。

  - 快速入门

    - 步骤

      1. 导入jar包;
      2. 获取Document对象;
      3. 获取对应的标签Element对象;
      4. 获取解析数据

      > ```java
      > //获取student.xml的path
      >  String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
      > //解析xml文档，加载文档进内存，获取dom树--->Document
      > Document document = Jsoup.parse(new File(path), "utf-8");
      > //获取元素对象 Element
      > Elements elements = document.getElementsByTag("name");
      > 
      > System.out.println(elements.size());
      > //获取第一个name的Element对象
      > Element element = elements.get(0);
      > //获取数据
      > String name = element.text();
      > System.out.println(name);
      > ```

  - 对象的使用

    1. Jsoup对象:工具类,可以解析html或者xml文档,返回Document对象

       > parse：解析html或xml文档，返回Document
       >
       > parse(File in, String charsetName)：解析xml或html文件的
       >
       > parse(String html)：解析xml或html字符串
       >
       > parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象

    2. Document对象:文档对象,代表内存中的DOM树

       > 获取Element对象:
       > getElementById(String id)：根据id属性值获取唯一的element对象
       >
       > getElementsByTag(String tagName)：根据标签名称获取元素对象集合
       >
       > getElementsByAttribute(String key)：根据属性名称获取元素对象集合
       >
       > getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合

    3. Elements对象:元素Element对象的集合

    4. Element对象:元素对象

       > 1. 获取子元素对象
       >
       >    getElementById(String id)：根据id属性值获取唯一的element对象
       >
       >    getElementsByTag(String tagName)：根据标签名称获取元素对象集合
       >
       >    getElementsByAttribute(String key)：根据属性名称获取元素对象集合
       >
       >    getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合
       >
       > 2. 获取属性值
       >
       >    String attr(String key)：根据属性名称获取属性值
       >
       > 3. 获取文本内容
       >
       >     String text():获取文本内容
       >
       >    String html():获取标签体的所有内容(包括字标签的字符串内容)

    5. Node:节点对象

       - Node节点对象是Document对象和Element对象的父类

- 快捷查询方式

  1. selector:选择器

     - 方法:Elements	select(String cssQuery)
     - cssQuery语法:参考文档中,Selector类中定义的语法

  2. XPath

     - XPath即为XML路径语言，它是一种用来确定XML（标准通用标记语言的子集）文档中某部分位置的语言(使用需要额外导入jar包),配合xpath语法完成查询

       > ```java
       > //1.获取student.xml的path
       > String path = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
       > //2.获取Document对象
       > Document document = Jsoup.parse(new File(path), "utf-8");
       > 
       > //3.根据document对象，创建JXDocument对象
       > JXDocument jxDocument = new JXDocument(document);
       > 
       > //4.结合xpath语法查询
       > //4.1查询所有student标签
       > List<JXNode> jxNodes = jxDocument.selN("//student");
       >             for (JXNode jxNode : jxNodes) {
       >                 System.out.println(jxNode);
       >             }
       > 			
       > System.out.println("--------------------");
       > 
       > //4.2查询所有student标签下的name标签
       > List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
       >             for (JXNode jxNode : jxNodes2) {
       >                 System.out.println(jxNode);
       >             }
       > 
       > System.out.println("--------------------");
       > 
       > //4.3查询student标签下带有id属性的name标签
       > List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
       >             for (JXNode jxNode : jxNodes3) {
       >                 System.out.println(jxNode);
       > 			        }
       > System.out.println("--------------------");
       > //4.4查询student标签下带有id属性的name标签 并且id属性值为itcast
       > 
       > List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='itcast']");
       >             for (JXNode jxNode : jxNodes4) {
       >                 System.out.println(jxNode);
       >             }
       > ```
       >
       > 

       

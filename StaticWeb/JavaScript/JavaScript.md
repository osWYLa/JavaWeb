# JavaScript

##  JavaScript基础

### 概念

- JavaScript 运行于客户端浏览器中，被浏览器引擎解析
- JavaScript 为脚本语言，不需要编译，可以直接被浏览器解析执行

### 功能

- 增强用户和HTML页面的交互，可以控制HTML元素，使得页面拒用动态效果，增强用户体验

### JavaScript发展史

1. 1992年，Nombase公司，开发出第一门客户端脚本语言，专门用于表单的校验。命名为 ： C--	，后来更名为：ScriptEase
2. 1995年，Netscape(网景)公司，开发了一门客户端脚本语言：LiveScript。后来，请来SUN公司的专家，修改LiveScript，命名为JavaScript
3. 1996年，微软抄袭JavaScript开发出JScript语言
4. 1997年，ECMA(欧洲计算机制造商协会)，制定出客户端脚本语言的标准：ECMAScript，就是统一了所有客户端脚本语言的编码方式

### 组成

- JavaScript = ECMAScript + JavaScript自己特有的东西(BOM+DOM)

  #### ECMAScript 客户端脚本语言的标准

  1. 基本语法：

     1. 与HTML结合方式

        1. 内部JS
           - 定义<script>，标签体内容就是JavaScript代码
        2. 外部JS
           - 定义<script>，通过src属性引入外部的js文件

        注意：

        > 1. <script> 可以定义再HTML页面的任意位置。但是定义的位置会影响执行顺序
        > 2. <script> 可以定义多个

     2. 注释

        1. 单行
        2. 多行

     3. 数据类型

        1. 原始数据类型（基本数据类型）
           1. number:数字（整数、小数、NaN【not a number】）
           2. string : 字符串（使用单双引号都可以）
           3. boolean 
           4. null：一个对象为空的占位符
           5. undefined：未定义（变量未赋初始值时会被赋值为undefined）
        2. 引用数据类型：对象

     4. 变量（数据存储空间）

        1. 关于强类型语言和弱类型语言：

           1. 强类型语言：在开辟变量存储空间时，定义了空间的数据类型。只能存储固定类型的数据；（如Java）
           2. 弱类型语言：在开辟变量存储空间时，不定义空间的将来的数据存储类型，可以存放任意类型的数据；（如JavaScript）

        2. 语法：

           ```javascript
           var 变量名 = 初始化值;
           ```

        3. typeof 运算符：获取变量的类型

           > 注意：null运算后，得到的是Object

     5. 运算符

        1. 一元运算符（只有一个运算数）

           > 注意：在Javascript中如果运算数不是运算符所要求的数据类型，那么JavaScript引擎会自动将运算数进行类型转换
           >
           > - string转number：按照字面值转。如果字面值不是数字，则转为NaN；
           > - boolean转number：true 转为1；false转为0；

        2. 算数运算符（+ - * / % ...）

        3. 赋值运算符（= += -+....）

        4. 比较运算符（> < >= <= == ===(全等于))

           >关于比较规则：
           >
           >1. 类型相同：直接比较
           >
           >   字符串比较: 按照字典顺序比较。按位逐一比较，直到得出大小为止
           >
           >2. 类型不同：先进行类型转换之后再比较
           >
           >   === （全等）：在进行内容比较之前，首先判断类型。若类型不同，则直接返回false

        5. 逻辑运算符（&& || ！）

           > 其他类型转换为boolean:
           >
           > 1. number : 0 或者NaN结果为假，其他为真；
           > 2. string： 除了空字符串（" "），其他都是true
           > 3. null 和 undefined 结果都是false；
           > 4. 对象，结果都为true

        6. 三元运算符

           1. ? : 表达式

           2. 语法：

              ```javascript
              表达式 ? 值1:值2;
              判断表达式的值，如果是true则取值为1，如果是false则取值为2
              ```

     6. 流程控制语句

        1. if..else

        2. switch

           > 注意：在Java在中，switch语句可以接受的数据类型有：byte int short char 枚举（1.5） String（1.7）。在JavaScript中，switch可以接受任意原始数据类型

        3. while

        4. do...while

        5. for

     7. JavaScript特殊语法

        1. 句末以;结尾，如果一行只有一条语句也可以省略（但是不推荐）

        2. 变量的定义使用var关键字，也可以不使用。区别：（***关于var 、let、const***）

           使用var关键字定义：定义的变量是局部变量；

           不使用var关键字定义：定义的变量是全局变量（不建议使用）

  2. 基本对象

     1. Function：函数（方法）对象

        1. 创建

           1. ```javascript
              var function = new Function(形参列表,方法体);(不使用)
              ```

           2. ```javascript
              function 方法名称（形参列表）{
                  方法体
              }
              ```

           3. ```javascript
              var 方法名 = function(形参列表){
                  方法体
              }
              ```

        2. 属性

           length 表示形参的个数

        3. 特点

           1. 方法定义的形参类型不需要写，返回值类型也不写
           2. 方法是一个对象，如果定义名称相同的方法，会造成覆盖
           3. 在JavaScript中方法的调用只和方法的名称有关，和参数列表无关
           4. 在方法声明中只用一个隐藏的内置对象(数组)，argument，封装所有的实际参数

        4. 调用

           方法名称 （实参列表）

     2. Array：数组对象

        1. 创建

           1. ```javascript
              var arr = new Array(元素列表);
              ```

           2. ```javascript
              var arr = new Array(默认长度);
              ```

           3. ```javascript
              var arr = [元素列表];
              ```

        2. 方法

           1. join(参数)： 将数组中的元素按照指定的分隔符拼接为字符串；
           2. push(): 向数组的末尾添加一个或者多个元素，并返回新的长度；

        3. 属性

           length：数组的长度

        4. 特点

           1. JavaScript中的数组元素的类型是可变的；
           2. JavaScript中的数组长度是可变的；

     3. Boolean

     4. Date：日期对象

        1. 创建

           ```javascript
           var date = new Date();
           ```

        2. 方法

           1. toLocaleString():返回当前date对象对应的时间本地字符串格式；
           2. getTime()：获取毫秒值。返回当前如期对象描述的时间到1970.1.1日零点的毫秒差；

     5. Math：数学对象

        1. 创建

           Math对象不需要创建，直接使用 Math.方法名();

        2. 方法

           1. random（）：返回【0，1）之间的随机数 ；
           2. ceil（x）： 对数进行上舍入；
           3. floor（x）：对数进行下舍入；
           4. round（x）：四舍五入；

        3. 属性

           PI

     6. Number

     7. String

     8. RegExp：正则表达式

        1. 正则表达式：定义字符串的组成规则

           1. 单个字符: []，如：

              > [a] ：
              >
              > [ab] ：
              >
              > [a-zA-Z0-9_] ：

              - 也使用特殊符号代表特殊含义的单个字符

                > \d : 单个数字字符 [0-9]
                >
                > \w : 单个单词字符 [a-zA-Z0-9_]

           2. 量词符号：

              >? : 表示出现0次或者1次
              >
              >*：表示出现0次或者多次
              >
              >+：出现1次或者多次
              >
              >{m,n}:表示  m<= 出现次数 <= n
              >
              >​			若m缺省：{,n}  最多n次
              >
              >​			若n缺省：{m,}   最多m次

           3. 开始结束符号

              > ^ : 开始
              >
              > $ :  结束

        2. 正则对象

           1. 创建

              1. ```javascript
                 var reg = new RegExp("正则表达式");
                 ```

              2. ```javascript
                 var reg = /正则表达式/;
                 ```

           2. 方法

              test(参数):测试指定的字符串是否符合正则表达式定义的规范

     9. Global对象

        1. 特点
           全局对象，Global对象中封装的方法不需要对象就可以直接调用

           方法名 （）；

        2. 方法

           1. encodeURI() ：urI编码

           2. decodeURI()：urI解码

           3. encodeURIComponent（）：urI编码（支持的格式更多）

           4. decodeURIComponent（）：urI解码（支持的格式更多）

           5. parseInt()：将字符串转换成数字

              逐一判断每一个字符是否是数字，直到不是数字为止，将前边的数字部分转换为number

           6. isNaN()：判断一个值是否是NaN（NaN参与的==比较全部为false，为判断是否是NaN，可以使用isNaN()）

           7. eval():将JavaScript字符串作为脚本代码来执行

        3. URL编码

           传智播客 =  %E4%BC%A0%E6%99%BA%E6%92%AD%E5%AE%A2

           













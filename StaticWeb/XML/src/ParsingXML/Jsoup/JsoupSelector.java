package ParsingXML.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-09-25
 * @Description
 * @Version
 */
public class JsoupSelector {
    public static void main(String[] args) throws IOException {
       //XML快速查询
        //1.选择器 Element select(String cssQuery)  /*cssQuery的语法通过查看文档获取*/
            //获取xml路径，获取document对象
        String path = JsoupSelector.class.getClassLoader().getResource("students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //选择器查询name标签(元素选择器)
        Elements elements = document.select("name");
        System.out.println(elements);

        System.out.println("=========");
        //id选择器
        Elements elements1 = document.select("#tian");
        System.out.println(elements1);

        System.out.println("=========");
        //如：获取number属性值为'attribute'的student标签下的age子标签
        Elements elements2 = document.select("student[number=\"attribute\"]");
        System.out.println(elements2);

            //获取下面的子标签
        System.out.println("=========");
        Elements elements3 = document.select("student[number=\"attribute\"] > age"); //age 后面不能有空格
        System.out.println(elements3);
        System.out.println("=========");


    }
}

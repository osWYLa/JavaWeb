package ParsingXML.Jsoup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


/**
 * @author wyl
 * @create 2020-09-25
 * @Description Jsoup快速入门
 * @Version
 */
public class JsoupTest {
    public static void main(String[] args) throws IOException {
        //获取document对象
            //获取students.xml文件位置
            //对于可能出现的空指针异常情况，需要在src目录下新建目录并设置为resource（？？？）
        String path = JsoupTest.class.getClassLoader().getResource("students.xml").getPath();
            //解析xml文档，加载文档进内存，获取dom树---> document
        Document document = Jsoup.parse(new File(path), "utf-8");
            //获取元素对象 Element
        Elements names = document.getElementsByTag("name");

        System.out.println(names.size());

        Iterator<Element> iterator = names.iterator();
        while (iterator.hasNext()){
            Element element = iterator.next();
            System.out.println("iterator:"+element.text());
        }

        for (Element element :
                names) {
            System.out.println("foreach:"+element.text());
        }


    }
}

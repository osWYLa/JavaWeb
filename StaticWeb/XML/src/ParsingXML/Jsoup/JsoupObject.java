package ParsingXML.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * @author wyl
 * @create 2020-09-25
 * @Description Jsoup对象的parse方法
 * @Version
 */
public class JsoupObject {
    public static void main(String[] args) throws IOException {
        //获取xml的path,再解析
        String path = JsoupObject.class.getClassLoader().getResource("students.xml").getPath();
        System.out.println(path);

        //parse(string html):解析xml或者html字符串，获取到document对象，再解析
        String string = "<?xml version =\"1.0\" encoding = 'utf-8' ?>\n" +
                "<students>\n" +
                "    <student number=\"attribute\">\n" +
                "        <name>yuye001</name>\n" +
                "        <age>10000</age>\n" +
                "        <sex>female</sex>\n" +
                "    </student>\n" +
                "    <student number=\"attribute\">\n" +
                "            <name>yuye002</name>\n" +
                "            <age>10</age>\n" +
                "            <sex>female</sex>\n" +
                "        </student>\n" +
                "</students>";
        Document document = Jsoup.parse(string);
        System.out.println(document);
        //parse(URL url,int timeoutMillis):通过网络路径获取指定html和xml的文档对象
        URL url = new URL("https://www.baidu.com");
        Document document1 = Jsoup.parse(url, 10000);
        System.out.println(document1);

    }
}

package ParsingXML.Jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author wyl
 * @create 2020-09-26
 * @Description 导入JsoupXPath 的jar包
 * @Version
 */
public class XpathTest {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //XPath查询
            //获取document对象
        String path = XpathTest.class.getClassLoader().getResource("students.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

            //根据Document对象，创建JpathDocument对象
        JXDocument jxDocument = new JXDocument(document);

            //结合Xpath语法查询
        List<JXNode> jxNodes = jxDocument.selN("//student"); //查询所有student标签
        for (JXNode j :
                jxNodes) {
            System.out.println(j);
        }

        System.out.println("==========");
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name"); //查询所有student标签下的name 标签
        for (JXNode j :
                jxNodes1) {
            System.out.println(j);
        }
        System.out.println("==========");
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]"); //查询所有student标签下带有id属性的name 标签
        for (JXNode j :
                jxNodes2) {
            System.out.println(j);
        }

        System.out.println("==========");


        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='tian']"); //查询所有student标签下带有id属性的name 标签,并且要求id属性必须是tian
        for (JXNode j :
                jxNodes3) {
            System.out.println(j);
        }

        System.out.println("==========");



    }
}

package web.download;

import web.download.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author wyl
 * @create 2020-10-11
 * @Description
 * @Version
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = req.getParameter("filename");
        //2.使用字节输入流加载文件至内存
        //2.1 确定文件的真实部署路径
        ServletContext servletContext = this.getServletContext();
        //web目录下
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2使用字节流关联
        FileInputStream fileInputStream = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1 设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename); //首先获取文件的mime类型
        resp.setHeader("content-type",mimeType);

        //中文文件名问题解决(这里不同的浏览器对于此处的中文名称乱码显示的内容还不一致，所以在工具类中需要由获得的agent请求头区分不同浏览器，进行分别处理)
            //获取user-agent 请求头
        String agent = req.getHeader("user-agent");
        //使用工具类设置filename 编码
        filename = DownLoadUtils.getFileName(agent, filename);

        //3.2 设置响应头打开方式：content-disposition(设置以附件打开)
        resp.setHeader("content-disposition","attachment;filename="+filename); //附件提示框名称

        //4.将输入流的数据写出到输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = fileInputStream.read(bytes))!= -1){
            outputStream.write(bytes,0,len);
        }


    }
}

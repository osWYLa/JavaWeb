package web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;

/**
 * @author wyl
 * @create 2020-10-11
 * @Description
 * @Version
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int width = 100;
        int height = 50;
        //1.创建对象，再内存中创建一张图片（验证码图片对象）
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1 填充背景色
        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,width,height);

        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        //2.3写验证码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890";
            //生成随机角标
        Random random = new Random();

        for (int i = 1; i <= 4 ; i++) {
            int index = random.nextInt(str.length());//角标范围
            char ch = str.charAt(index);
            g.drawString(ch+"",width/5*i,height/2);
        }

        //2.4 画干扰线
        g.setColor(Color.GREEN);
            //随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,x2,y1,y2);
        }

        //3.将图片输出到页面
        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream()); //formatName 在文件存储时使用，内存中其实无所谓。（二进制）



    }
}

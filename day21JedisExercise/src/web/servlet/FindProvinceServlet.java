package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author wyl
 * @create 2020-11-12
 * @Description
 * @Version
 */
@WebServlet("/findProvinceServlet")
public class FindProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询
        ProvinceServiceImpl service = new ProvinceServiceImpl();
        /*List<Province> list = service.findAll();
        //序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
*/

        String json = service.findAllJson();
      //  System.out.println("json02："+json02);


        System.out.println(json);

        //响应
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

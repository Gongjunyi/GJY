package top.gjy.web.servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//通过ServletContext获取MIME类型
//ServletContext的功能:
//1.获取MIME类型
//2.共享数据
//3.获取服务器的真实路径
@WebServlet(urlPatterns = "/context2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        // image/jpeg
        String fileName = "a.jpg";
        String mimeType = context.getMimeType(fileName);
        System.out.println(mimeType);
    }
}

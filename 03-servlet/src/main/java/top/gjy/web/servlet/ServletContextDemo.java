package top.gjy.web.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

//获取文件的真实路径(服务器)
@WebServlet(urlPatterns = "/path")
public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.得到ServletContext对象
        ServletContext context = this.getServletContext();
        //2.web目录资源访问 b.txt
        String bpath = context.getRealPath("/b.txt");
        System.out.println(bpath);
        //3.WEB-INF目录下的资源访问 c.txt
        String cpath = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(cpath);

        //4.src目录或子目录下的资源访问
        String apath = context.getRealPath("/WEB-INF/classes/top/gjy/web/servlet/a.txt");
        System.out.println(apath);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

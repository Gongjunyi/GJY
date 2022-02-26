package com.gjy.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//@WebServlet(urlPatterns = "/res")
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        System.out.println("init...");
        getServletInfo();
        message = "2022北京冬奥会";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //response.getWriter().println("ok");
        //不变request.getRequestDispatcher("xyz/detail.html").forward(request,response);
        //变response.sendRedirect("xyz/detail.html");
        String type = request.getParameter("type");
        System.out.println(type);
        switch (type){
            case "html":
                getHtml(response);
                break;
            case "json":
                getJson(response);
                break;
            case "img":
                getImg(request,response);
                break;
            default:
                break;
        }
    }


    private void getHtml(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.println("<html lang=\"en\"><body>");
//        out.println("<h1>"+message+"</h1>");
//        out.println("</body></html>");
//        out.flush();
//        out.close();
    }
    private void getJson(HttpServletResponse response) throws IOException {
        //response.sendRedirect("/xyz/detail.html");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String json = "{\"name\":Jack ,\"age\":\"22\",\"test\":{\"name\":\"Tom\"}}";
        out.println(json);
        out.flush();
        out.close();
    }
    private void getImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        String path = request.getServletContext().getRealPath("");
        System.out.println(path);
        File file = new File(path + "/img/iu.jpg");
        InputStream inputStream = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = inputStream.read()) != -1) {
            out.write(read);
        }
        out.flush();
        inputStream.close();
        out.close();
    }
    @Override
    public void destroy() {
        System.out.println("destroyed...");
    }
    @Override
    public String getServletInfo(){
        System.out.println(super.getServletInfo());
        return super.getServletInfo();
    }

}
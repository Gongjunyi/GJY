package com.gjy.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/req")
public class ReqServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("Protocol"+request.getProtocol());
//        System.out.println("ContextPath:"+request.getContextPath());
//        System.out.println("ServletPath:"+request.getServletPath());
//        System.out.println("QueryString:"+request.getQueryString());
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("Protocol"+request.getProtocol());
//        System.out.println("ServletPath"+request.getServletPath());
//        System.out.println(request.getParameter("password"));
        String name = request.getParameter("name");
        System.out.println(name);
        //1.设置服务器端的编码，要在response.getWriter()之前设置，默认是iso-8859-1
        response.setCharacterEncoding("UTF-8");
        //2.通过设置响应头，通知浏览器服务器发送的数据模式
        response.setHeader("Content-type","text/plain;charset=utf-8");
        //等同于2,提倡用这个
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().println(name);
        response.getWriter().close();
    }
}

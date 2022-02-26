package com.gjy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;


@WebServlet(
        name = "ParameterServlet",
        urlPatterns = {"/param"},
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "site",value = "https://mqxu.com"),
                @WebInitParam(name = "name",value = "mqxu")
        })
public class ParameterServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -5767625680763237936L;

    @Override
    public void init() throws ServletException {
        String site = this.getInitParameter("site");
        String name  = this.getInitParameter("name");
        System.out.println(site);
    }

    protected void service(HttpServletResponse req, HttpServletResponse resp) throws IOException{
//        String site = this.getInitParameter("site");
//        String name  = this.getInitParameter("name");
//        PrintWriter out = resp.getWriter();
//        out.println(site);
//        out.println(name);
//        out.flush();
//        out.close();
    }
}

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class RegLet extends HttpServlet {

    private static final long serialVersionUID = -4415294210787731608L;

    /**
     * The doGet method of the Server let.
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // 新建服务对象
        Service serv = new Service();

        // 接收注册信息
        String account = request.getParameter("account");
        account = new String(account.getBytes("ISO-8859-1"), "UTF-8");
        String password = request.getParameter("password");
        String phonenum=request.getParameter("phonenum");
        String confirm;
//		String password = request.getParameter("r_password");
        System.out.println("test");
        // 验证处理
        boolean reged = serv.register(account, password,phonenum);
        System.out.println("test" + reged);
        if (reged) {
            System.out.print("Succss");
            confirm = "注册成功";
            request.getSession().setAttribute("account", account);
            //response.sendRedirect("welcome.jsp");
        } else {
            System.out.print("Failed");
            confirm = "注册失败，该帐号已被注册";
        }


        // 返回信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //out.print("用户名：" + account);
        //out.print("密码：" + password);
        out.print(confirm);
        out.flush();
        out.close();
    }

    /**
     * The doPost method of the Server let.
     */

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//		测试为何手机端中文乱码，电脑正常
//		System.out.println("u1--"+account);
//		System.out.println("u2--"+account);

    }

}
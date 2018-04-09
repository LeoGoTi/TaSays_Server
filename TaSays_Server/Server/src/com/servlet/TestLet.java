package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class TestLet extends HttpServlet {

    private static final long serialVersionUID = 369840050351775312L;

    /**
     * The doGet method of the Server let.
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String line;
        String content=request.getParameter("content");//调用content用于py脚本
        String type=request.getParameter("type");
        content = new String(content.getBytes("ISO-8859-1"), "UTF-8");
        type = new String(type.getBytes("ISO-8859-1"), "UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String args1;
        try {
            System.out.println("start");
            if(type.equals("1"))
                args1="python3 /usr/model2.py "+content+"";
            else
                args1="python3 /usr/model3.py \""+content+"\"";
            Process pr=Runtime.getRuntime().exec(args1);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    pr.getInputStream()));

            while ((line = in.readLine())!= null) {
                System.out.print(line);
                out.print(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The doPost method of the Server let.
     */

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 测试为何手机端中文乱码，电脑正常
        System.out.println("u1--");
        System.out.println("u2--");

    }

}
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.Json;
import com.service.Service;
import org.json.simple.JSONObject;

public class EditInfoLet extends HttpServlet {

    private static final long serialVersionUID = 259521988485312L;
    Json json=new Json();
    JSONObject obj=new JSONObject();

    /**
     * The doGet method of the Server let.
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 接收信息
        String account = request.getParameter("account"),
                gender = request.getParameter("gender"),
                introduction = request.getParameter("introduction"),
                nickname = request.getParameter("nickname"),
                birth = request.getParameter("birth"),
                phonenum = request.getParameter("phonenum");
        account = new String(account.getBytes("ISO-8859-1"), "UTF-8");
        gender = new String(gender.getBytes("ISO-8859-1"), "UTF-8");
        introduction = new String(introduction.getBytes("ISO-8859-1"), "UTF-8");
        nickname = new String(nickname.getBytes("ISO-8859-1"), "UTF-8");
        birth = new String(birth.getBytes("ISO-8859-1"), "UTF-8");
        phonenum = new String(phonenum.getBytes("ISO-8859-1"), "UTF-8");


        // 新建服务对象
        Service serv = new Service();
        obj.put("account",account);
        obj.put("nickname",nickname);
        obj.put("gender",gender);
        obj.put("introduction",introduction);
        obj.put("birth",birth);
        obj.put("phonenum",phonenum);
        // 验证处理
       /* boolean loged = serv.login(account, password);
        if (lo/
            System.out.print("Succss");
            confirm = "登陆成功";
            request.getSession().setAttribute("account", account);
            // response.sendRedirect("welcome.jsp");
        } else {
            System.out.print("Failed");
            confirm = "账号或密码不正确";
        }
*/
        // 返回信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //out.print("用户名：" + account);
        //out.print("密码：" + password);
        //out.print(confirm);
        out.println(json.PersonalInfoWrite(obj));
        out.print(obj.toString());
        out.flush();
        out.close();

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
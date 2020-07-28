package duing.web.servlet;

import duing.domain.Admin;
import duing.service.AdminService;
import duing.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //验证码正确
        //封装User对象
        String username = request.getParameter("login_username");
        String password = request.getParameter("login_password");
        System.out.println(username+":"+password);
        Admin admin = new Admin(username,password);
        //调用Service查询
        AdminService adminService = new AdminServiceImpl();
        Admin loginAdmin = adminService.loginAdmin(admin);
        //判断是否登录成功
        if(loginAdmin!=null){
            //登陆成功
            //将用户存入Session
            request.getSession().setAttribute("admin",loginAdmin);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //登录失败
            //提示信息
            request.setAttribute("login_msg","用户名或密码错误！");
            //转发
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

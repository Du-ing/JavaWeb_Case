package duing.web.servlet;

import duing.domain.Admin;
import duing.service.AdminService;
import duing.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registAdminServlet")
public class RegistAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        //获取用户输入的验证码
        String verifycode = request.getParameter("verifycode");
        //校验验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码输入不正确
            request.setAttribute("regist_msg","验证码错误！");
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        //验证码正确
        //封装User对象
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = new Admin(username,password);
        //调用Service
        AdminService adminService = new AdminServiceImpl();
        //获取注册结果
        boolean flag = adminService.registAdmin(admin);

        if(flag){
            request.getSession().setAttribute("regist","注册成功！你可以进行登录");
            //跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else {
            request.setAttribute("regist_msg","注册失败！用户名已存在");
            //转发
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

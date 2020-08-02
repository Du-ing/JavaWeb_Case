package duing.filter;

import duing.domain.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //获取资源请求路径
        String uri = request.getRequestURI();
        //判断是否包含登录和注册相关路径，要注意排除掉css/js/验证码/图片等资源
        if(uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/")
                || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")
                || uri.contains("/regist.jsp") || uri.contains("/registAdminServlet")){
            //包含，证明用户想要登录，放行
            chain.doFilter(req,resp);
        }else {
            //不包含，需要验证用户是否登录
            //从session中获取user
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            if(admin != null){
                //已登录，放行
                chain.doFilter(req,resp);
            }else{
                //未登录，跳转到登录页面
                request.setAttribute("login_msg","您尚未登录系统，请先登录！");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}

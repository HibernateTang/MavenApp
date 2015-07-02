package com.spring.oa.filter;

import com.spring.oa.domain.User;
import com.spring.oa.util.Const;
import com.spring.oa.util.SessionUtils;
import com.spring.oa.util.VideoConverter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by burning-.- on 2015/6/27.
 */
public class LoginChecker implements Filter{
    public List<String> pathNeedLogin;
    public void init(FilterConfig filterConfig) throws ServletException {
        pathNeedLogin=new ArrayList<String>();
        pathNeedLogin.add("/login_logout.do");
        pathNeedLogin.add("/upload_init.do");
        pathNeedLogin.add("/upload_upload.do");
        pathNeedLogin.add("/player_comment.do");
        Const.UPLOAD_REAL_PATH=filterConfig.getServletContext().getRealPath(Const.UPLOAD_FOLDER)+"\\";
        VideoConverter.getInstance().startConverJob();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        String path=request.getServletPath();//得到浏览器的请求与地址
        if(!pathNeedLogin.contains(path)){//不需要登陆访问
            filterChain.doFilter(request,response);//放行
            return;
        }
        /*执行到这里说明需要登陆才能访问*/
        /*得到session中的用户对象*/
        User user= SessionUtils.getUserFormSession(request);
        if(user!=null){//已登陆放行
            filterChain.doFilter(request,response);
        }else {//未登陆则转向登陆页
            response.sendRedirect(request.getContextPath()+"/login_init.do");
        }
    }
    /*卸载Web应用时执行*/
    public void destroy() {
        VideoConverter.getInstance().stopConvertJob();
    }
}

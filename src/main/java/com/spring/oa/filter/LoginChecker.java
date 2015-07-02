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
        String path=request.getServletPath();//�õ���������������ַ
        if(!pathNeedLogin.contains(path)){//����Ҫ��½����
            filterChain.doFilter(request,response);//����
            return;
        }
        /*ִ�е�����˵����Ҫ��½���ܷ���*/
        /*�õ�session�е��û�����*/
        User user= SessionUtils.getUserFormSession(request);
        if(user!=null){//�ѵ�½����
            filterChain.doFilter(request,response);
        }else {//δ��½��ת���½ҳ
            response.sendRedirect(request.getContextPath()+"/login_init.do");
        }
    }
    /*ж��WebӦ��ʱִ��*/
    public void destroy() {
        VideoConverter.getInstance().stopConvertJob();
    }
}

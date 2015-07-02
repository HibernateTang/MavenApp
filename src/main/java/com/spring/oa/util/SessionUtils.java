package com.spring.oa.util;

import com.mysql.jdbc.StringUtils;
import com.spring.oa.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by burning-.- on 2015/6/27.
 */
public class SessionUtils {
    /*����û��������֤���Ƿ���session�е�һ��*/
    public static boolean isCodeMatch(HttpServletRequest request){
        /*��ȡsession*/
        HttpSession session=request.getSession(false);
        if(session==null){
            return false;
        }
        /*��ȡsession�е���֤��*/
        String existCode=(String)session.getAttribute(Const.KEY_VERIFICAITON_CODE);
        if(StringUtils.isNullOrEmpty(existCode)){
            return false;
        }
        /*��ȡ�û��������֤��*/
        String inputCode=request.getParameter("verificationCode");
        if(StringUtils.isNullOrEmpty(inputCode)){
            return false;
        }
        return existCode.equalsIgnoreCase(inputCode);
    }
    /*�û���¼�ɹ��󣬽��û��Ķ������session��*/
    public static void setUserToSession(HttpServletRequest request,User user){
        HttpSession session=request.getSession();
        if(user==null){
            return;
        }
        session.setAttribute(Const.KEY_LOGINED_USER,user);
    }
    /*�õ�֮ǰ����session�е��û�����*/
    public static User getUserFormSession(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session==null){
            return null;
        }
        return (User)session.getAttribute(Const.KEY_LOGINED_USER);
    }
    /*�û�ע��ʱ��ɾ��֮ǰ����session�е��û�����*/
    public static void removeUserFormSession(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session==null){
            return;
        }
        session.removeAttribute(Const.KEY_LOGINED_USER);
    }
}

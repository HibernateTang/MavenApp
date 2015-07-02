package com.spring.oa.action;

import com.spring.oa.domain.User;
import com.spring.oa.service.UserService;
import com.spring.oa.util.SessionUtils;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * Created by burning-.- on 2015/6/27.
 */
@SuppressWarnings("serial")
@Controller
public class LoginAction extends BaseAction {
    @Resource
    private UserService userService;

    private String userName;
    private String password;
    private String verificationCode;
    /*��ʼ����¼ҳ��*/
    public String init(){
        return "login";
    }
    /*ִ�е�¼����*/
    public String login(){
        /*�ж���֤���Ƿ���ȡ*/
        if(!SessionUtils.isCodeMatch(request)){
            this.addFieldError("verification_code_error","��֤�����");
            return "login";
        }
        /*�ж��û��������Ƿ���ȷ*/
        User u=userService.findUser(userName, password);
        if(u==null){
            this.addFieldError("invalid_user_error","�û������������");
            return "login";
        }else {
            /*�޸��û�����½ʱ��*/
            u.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
            userService.updateLastLoginTime(u);
            SessionUtils.setUserToSession(request, u);
        }
        return "back_to_main";
    }
    /*ע������*/
    public String logout(){
        SessionUtils.removeUserFormSession(request);
        return "back_to_main";
    }

}

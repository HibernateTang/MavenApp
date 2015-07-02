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
    /*初始化登录页面*/
    public String init(){
        return "login";
    }
    /*执行登录操作*/
    public String login(){
        /*判断验证码是否争取*/
        if(!SessionUtils.isCodeMatch(request)){
            this.addFieldError("verification_code_error","验证码错误");
            return "login";
        }
        /*判断用户名密码是否正确*/
        User u=userService.findUser(userName, password);
        if(u==null){
            this.addFieldError("invalid_user_error","用户名或密码错误");
            return "login";
        }else {
            /*修改用户最后登陆时间*/
            u.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
            userService.updateLastLoginTime(u);
            SessionUtils.setUserToSession(request, u);
        }
        return "back_to_main";
    }
    /*注销操作*/
    public String logout(){
        SessionUtils.removeUserFormSession(request);
        return "back_to_main";
    }

}

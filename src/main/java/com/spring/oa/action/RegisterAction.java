package com.spring.oa.action;

import com.opensymphony.xwork2.ActionContext;
import com.spring.oa.service.FaceService;
import com.spring.oa.service.UserService;
import com.spring.oa.util.SessionUtils;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by burning-.- on 2015/6/27.
 */
@SuppressWarnings("serial")
@Controller
public class RegisterAction extends BaseAction {
    @Resource
    private UserService userService;
    @Resource
    private FaceService faceService;

    private String userName;
    private String password;
    private String password2;
    private String verificationCode;
    private int faceId;

    public String init(){
        ActionContext.getContext().put("all_faces",faceService.findAllFaces());
        ActionContext.getContext().put("default_face",faceService.findDefaultFace());
        return "register";
    }
    /*执行注册操作*/
    public String register(){
        /*判断验证码是否正确*/
        if(!SessionUtils.isCodeMatch(request)){
            this.addFieldError("verification_code_error","验证码错误! ");
            return init();
        }
        /*判断输入的用户名是否已存在*/
        if(userService.isUserNameExist(userName)){
            this.addFieldError("user_name_exist_error","用户名已存在!");
            return init();
        }else {
            userService.addUser(userName,password,faceId);
        }
        return "register_success";
    }
}


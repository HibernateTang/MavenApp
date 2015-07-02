package com.spring.oa.action;

import org.springframework.stereotype.Controller;

/**
 * Created by burning-.- on 2015/6/27.
 */
@SuppressWarnings("serial")
@Controller
public class VerificationCodeAction extends BaseAction {
    @Override
    public String execute(){
        return "init";
    }
}

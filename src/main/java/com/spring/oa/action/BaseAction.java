package com.spring.oa.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by burning-.- on 2015/6/27.
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    public void setServletRequest(HttpServletRequest request){
        this.request=request;
    }
    public void setServletResponse(HttpServletResponse response){
        this.response=response;
    }
}


package com.chinasoft.meetingroom.interceptior;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by wei on 15/6/2.
 */
public class AdminAuthorityInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        String level = (String) actionContext.get("level");
        if(level!=null&&level.equals(String.valueOf(1))){
            return actionInvocation.invoke();
        }
        return Action.LOGIN;
    }
}

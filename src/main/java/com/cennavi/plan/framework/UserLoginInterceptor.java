package com.cennavi.plan.framework;

import com.cennavi.plan.model.BaseUser;
import com.cennavi.plan.model.ResultObj;
import com.cennavi.plan.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class UserLoginInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(UserLoginInterceptor.class);
    @Resource
    UserUtil userUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        logger.info(">>>UserLoginInterceptor>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");

        String token= request.getParameter("token");
        ResultObj<BaseUser> result = userUtil.checkUserCache(token);
        if (result.isSuccess()){
            logger.info("用户已登录");
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(600);
            session.setAttribute("user",result.getResult());
            return true;
        }else{
            logger.warn(result.getMsg());
            response.sendRedirect("/user/error/unlogin");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}

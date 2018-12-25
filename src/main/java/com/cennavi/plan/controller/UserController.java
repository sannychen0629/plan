package com.cennavi.plan.controller;

import com.cennavi.plan.model.BaseUser;
import com.cennavi.plan.model.ResultObj;
import com.cennavi.plan.service.IBaseUserService;
import com.cennavi.plan.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/planService/user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    UserUtil userUtil;
    @Resource
    IBaseUserService baseUserService;
    @RequestMapping("login")
    public @ResponseBody
    Object login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {

        BaseUser baseUser = baseUserService.loadUserByUsername(username);
        ResultObj<BaseUser> resultObj = new ResultObj();
        if(baseUser==null){
            resultObj.setMsg("用户不存在");
            //resultObj.setResult(baseUser);
            resultObj.setSuccess(false);
        }
        else if (baseUser.getPassword().equals(password)){
            String token = userUtil.cacheUserInfo(baseUser);
            baseUser.setToken(token);
            resultObj.setMsg("登陆成功");
            resultObj.setResult(baseUser);
            resultObj.setSuccess(true);
        }else{
            resultObj.setMsg("密码错误");
            resultObj.setResult(baseUser);
            resultObj.setSuccess(false);
        }
        return resultObj;
    }

    @RequestMapping("logout")
    public @ResponseBody Object logout(@RequestParam String token, HttpServletRequest request, HttpServletResponse response) {

        userUtil.clearCache(token);
        ResultObj<BaseUser> resultObj = new ResultObj();
        resultObj.setSuccess(true);
        resultObj.setMsg("成功退出");
        return resultObj;
    }


    /**
     * 登录页面跳转
     * @return
     */
    @RequestMapping("toLoginPage")
    public String toLoginPage() {
        return "login";
    }

    /**
     * 登录提醒
     * @return
     */
    @RequestMapping(value ="/error/unlogin")
    @ResponseBody Object refuse() {
        ResultObj<BaseUser> resultObj = new ResultObj<BaseUser>();
        resultObj.setMsg("未登录，请先登录");
        resultObj.setRetCode("longin_003");
        resultObj.setSuccess(true);
        return resultObj;
    }
}

package com.cennavi.plan.controller;

import com.cennavi.plan.model.BaseUser;
import com.cennavi.plan.model.ResultObj;
import com.cennavi.plan.service.IBaseUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    IBaseUserService baseUserService;
    @RequestMapping("login")
    public @ResponseBody
    Object login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {

        BaseUser baseUser = baseUserService.loadUserByUsername(username);
        ResultObj<BaseUser> resultObj = new ResultObj();
        if(baseUser==null){
            resultObj.setMsg("用户不存在");
            resultObj.setResult(baseUser);
            resultObj.setSuccess(false);
        }
        else if (baseUser.getPassword().equals(password)){

            //String token = userUtil.cacheUserInfo(baseUser);
            //baseUser.setToken(token);
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
}

package com.cennavi.plan.utils;

import com.cennavi.plan.mapper.BaseUserMapper;
import com.cennavi.plan.model.BaseUser;
import com.cennavi.plan.model.ResultObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
@EnableScheduling // 启用定时任务扫描
public class UserUtil {
    private final static Logger logger = LoggerFactory.getLogger(UserUtil.class);
    private final static int expireTime = 180000000;
    static ConcurrentHashMap<String,Long> tokenMap = new ConcurrentHashMap<String,Long>();
    @Autowired
    private ServletContext application;
    @Resource
    private BaseUserMapper baseUserMapper;

    /**
     * 将用户信息放入全局缓存中，并返回用户token
     * @param baseUser
     * @return
     */
    public String cacheUserInfo(BaseUser baseUser){
        //使用uuid作为token
        String token = UUID.randomUUID().toString().replace("-", "").toLowerCase();

        //获取application并保存用户信息
        application.setAttribute(token,baseUser);

        //保存token设置时间
        tokenMap.put(token,System.currentTimeMillis());

        return token;
    }

    /**
     * 用户登录超时检查
     * @param token
     * @return
     */
    public ResultObj<BaseUser> checkUserCache(String token){
        ResultObj resultObj = new ResultObj();

        long ntime = System.currentTimeMillis();
        long stime = 0;
        try {
            stime = tokenMap.get(token);
        } catch (Exception e) {
            logger.error("token 无效（不存在）");
            resultObj.setMsg("token 无效（不存在）");
            return resultObj;
        }
        int dtime = (int)(ntime-stime)/1000;


        if ( dtime>expireTime ){

            application.removeAttribute(token);
            tokenMap.remove(token);
            logger.warn("用户长时间未操作，需重新登录");
            resultObj.setSuccess(false);
            resultObj.setMsg("用户长时间未操作，需重新登录");
            return resultObj;

        }else {

            BaseUser user = (BaseUser)application.getAttribute(token);
            tokenMap.put(token, System.currentTimeMillis());
            resultObj.setSuccess(true);
            resultObj.setResult(user);
            return resultObj;

        }

    }

    /**
     * 根据用户token清除用户及token信息
     * @param token
     */
    public synchronized void clearCache(String token){
        tokenMap.remove(token);
        application.removeAttribute(token);
    }

    /**
     * 根据用户token获取用户及token信息
     * @param token
     */
    public BaseUser getUserInfo(String token){

        BaseUser user = (BaseUser)application.getAttribute(token);
        return user;

    }

    /**
     * 获取用户信息
     */
    public BaseUser getUserInfo(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        BaseUser user = (BaseUser)session.getAttribute("user");
        return user;

    }

    /**
     * 定时任务清理无用用户缓存信息
     */
    public void userClearTask() {
        logger.info("userClearTask开始定时执行");

        Iterator<Map.Entry<String, Long>> it = tokenMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Long> entry =  it.next();
            long stime = entry.getValue();
            long ntime = System.currentTimeMillis();
            if((double)(ntime-stime) /1000 > 12*60*60){ //大于12小时自动注销
                it.remove();//使用迭代器的remove()方法删除元素
                BaseUser user = (BaseUser)application.getAttribute(entry.getKey());
                baseUserMapper.updateStatus(user.getUserid(),"0");
                application.removeAttribute(entry.getKey());
            }

        }
    }
}

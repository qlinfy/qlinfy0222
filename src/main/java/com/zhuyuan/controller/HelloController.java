package com.zhuyuan.controller;

import com.zhuyuan.entity.TUser;
import com.zhuyuan.repository.TUserRepository;
import com.zhuyuan.utils.CommonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */
@Controller
public class HelloController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    TUserRepository tUserRepository;

    @RequestMapping("/toLogin")
    public String index(ModelMap map,String userName,String password,TUser tUser){
        System.out.println(tUser.getUserName());
        UsernamePasswordToken token = new UsernamePasswordToken(userName, CommonUtils.encrypt(password));
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            logger.info("对用户[" + userName + "]进行登录验证..验证开始");
            currentUser.login(token);
            logger.info("对用户[" + userName + "]进行登录验证..验证通过");
        }catch(UnknownAccountException uae){
            logger.info("对用户[" + userName+ "]进行登录验证..验证未通过,未知账户");
            map.addAttribute("message", "未知账户");
            token.clear();
            return "login";
        }catch(IncorrectCredentialsException ice){
            logger.info("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
            map.addAttribute("message", "密码不正确");
            token.clear();
            return "login";
        }catch(LockedAccountException lae){
            logger.info("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
            map.addAttribute("message", "账户已锁定");
            token.clear();
            return "login";
        }catch(ExcessiveAttemptsException eae){
            logger.info("对用户[" + userName+ "]进行登录验证..验证未通过,错误次数过多");
            map.addAttribute("message", "用户名或密码错误次数过多");
            token.clear();
            return "login";
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            map.addAttribute("message", "用户名或密码不正确");
            token.clear();
            return "login";
        }
        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            logger.info("用户[" + userName + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            return "index";
        }else{
            token.clear();
            return "login";
        }
    }


    @RequestMapping("/login")
    public String indexTest(){
        System.out.println("jinlaile");
        Pageable pageable = new PageRequest(1,1);
        Page page = tUserRepository.findAll(pageable);
        for (int i = 0; i <page.getContent().size(); i++) {
            System.out.println("fasdfasfasdfdasdfdasf"+((TUser)page.getContent().get(i)).getUserName());
        }
        return "login";
        }



}

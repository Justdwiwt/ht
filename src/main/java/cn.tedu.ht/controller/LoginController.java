package cn.tedu.ht.controller;

import cn.tedu.ht.pojo.User;
import cn.tedu.ht.service.UserService;
import cn.tedu.ht.tool.Md5Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

//    /**
//     * 用户登录页面
//     *
//     * @return /sysadmin/login/login
//     */
//    @RequestMapping(value = "/tologin")
//    public String toLogin() {
//        return "/sysadmin/login/login";
//    }

    /**
     * 登录验证
     *
     * @param userName name
     * @param password pwd
     * @param model    {@code StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)} errorInfo
     *                 <p> {@code user == null} errorInfo
     * @param session  {@code sessionUser} user
     * @return redirect:/home
     * <p> {@code StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)} /sysadmin/login/login
     * <p> {@code user == null} /sysadmin/login/login
     */
    @SuppressWarnings("ConstantConditions")
    @RequestMapping(value = "/login")
    public String toLogin(String userName, String password, Model model, HttpSession session) {
        //1、判断用户名和密码是否为空
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            //证明 用户名  或者 密码 是空的
            model.addAttribute("errorInfo", "用户名或者密码不能为空");
            return "/sysadmin/login/login";
        }
        //2、根据用户名和密码判断当前用户是否存在
        String md5Password = Md5Password.getMd5HashPassword(password, userName);
        //根据加密后的密码和用户名 查询数据库
        User user = userService.checkLoginByUser(userName, md5Password);
        if (StringUtils.isEmpty(user) || user == null) {
            //用户名或者密码不正确
            model.addAttribute("errorInfo", "用户名和密码不正确");
            return "/sysadmin/login/login";
        }
        //3、将用户数据存入到session中
        session.setAttribute("sessionUser", user);
        return "redirect:/home.action";
    }

    /**
     * 点击登出按钮，页面的跳转
     *
     * @param session sessionUser
     * @return /sysadmin/login/logout
     */
    @RequestMapping(value = "/logout")
    public String toLoginOut(HttpSession session) {
        session.setAttribute("sessionUser", null);
        return "/sysadmin/login/login";
    }

}

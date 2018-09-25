package cn.tedu.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sysadmin/user")   //请求的公共部分
public class UserController {

    // 用户列表页面的跳转
    @RequestMapping(value = "/list")  //每个请求的action
    public String toUserList() {
        return "/sysadmin/user/jUserList";
    }

}

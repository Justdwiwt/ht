package cn.tedu.ht.controller;

import cn.tedu.ht.pojo.User;
import cn.tedu.ht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/sysadmin/user")   //请求的公共部分
public class UserController {

    @Autowired
    private UserService userService;

    // 用户列表页面的跳转
    @RequestMapping(value = "/list")  //每个请求的action
    public String toUserList(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "/sysadmin/user/jUserList";
    }


}

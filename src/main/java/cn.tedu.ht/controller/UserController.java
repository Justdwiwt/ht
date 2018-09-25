package cn.tedu.ht.controller;

import cn.tedu.ht.pojo.User;
import cn.tedu.ht.service.UserService;
import cn.tedu.ht.tool.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/sysadmin/user")   //请求的公共部分
public class UserController {

    @Autowired
    private UserService userService;

//    // 用户列表页面的跳转
//    @RequestMapping(value = "/list")  //每个请求的action
//    public String toUserList(Model model) {
//        List<User> userList = userService.findAll();
//        model.addAttribute("userList", userList);
//        return "/sysadmin/user/jUserList";
//    }

    // 用户列表页面的跳转
    @RequestMapping(value = "/list")  //每个请求的action
    public String toUserList(@RequestParam(defaultValue = "1") int currentPage,
                             @RequestParam(defaultValue = "10") int pageSize, Model model) {
        PageBean<User> pageBean = userService.findUserByPages(currentPage, pageSize);
        List<User> userList = pageBean.getList();
        model.addAttribute("userList", userList);
        model.addAttribute("pageBean", pageBean);
        return "/sysadmin/user/jUserList";
    }


}

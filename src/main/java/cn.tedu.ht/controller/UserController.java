package cn.tedu.ht.controller;

import cn.tedu.ht.pojo.Dept;
import cn.tedu.ht.pojo.User;
import cn.tedu.ht.service.DeptService;
import cn.tedu.ht.service.UserService;
import cn.tedu.ht.tool.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/sysadmin/user") //请求的公共部分
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private DeptService deptService;

    //用户列表页面的跳转
	/*@RequestMapping(value="/list") //每个请求的action
	public String toUserList(Model model) {
		//查询全部的用户信息
		List<User> userList = userService.findAll();
		//数据填充
		model.addAttribute("userList", userList);
		return "/sysadmin/user/jUserList";
	}*/
    @RequestMapping(value = "/list") //每个请求的action
    public String toUserList(
            @RequestParam(defaultValue = "1") int currentPage,
            @RequestParam(defaultValue = "10") int pageSize, Model model) {
        //查询分页的数据：默认查询，每一页为10条数据，从第0条开始
        System.out.println("************" + currentPage);
        System.out.println("------------" + pageSize);
        PageBean<User> pageBean = userService.findUserByPages(currentPage, pageSize);
        List<User> userList = pageBean.getPageList();
        //数据填充
        model.addAttribute("userList", userList);
        model.addAttribute("pageBean", pageBean);
        return "/sysadmin/user/jUserList";
    }

    //点击新增按钮，跳转页面
    @RequestMapping(value = "/tosave")
    public String toSaveUser(Model model) {
        //准备 上级领导的信息
        List<User> userInfoList = userService.findManagerUser();
        //准备 所属部门的信息
        List<Dept> deptList = deptService.findAll();
        for (Dept dept : deptList) {
            System.out.println("===========" + dept);
        }
        //数据填充
        model.addAttribute("userInfoList", userInfoList);
        model.addAttribute("deptList", deptList);
        return "/sysadmin/user/jUserSave";
    }

    //点击保存按钮，实现保存功能
    @RequestMapping(value = "/save")
    public String saveUser(User user, Model model) {
        //检验用户的用户名是否存在冲突

        //调用service层的保存方法
        userService.saveUser(user);

        //重定向
        return "redirect:/sysadmin/user/list";
    }

}

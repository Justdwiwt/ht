package cn.tedu.ht.service;

import cn.tedu.ht.mapper.UserMapper;
import cn.tedu.ht.pojo.User;
import cn.tedu.ht.tool.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int getUserTotalCount() {
        return userMapper.getUserTotalCount();
    }

    @Override
    public PageBean<User> findUserByPages(int currentPage, int pageSize) {
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setCurrPage(currentPage);
        pageBean.setPageSize(pageSize);
        int totalCount = userMapper.getUserTotalCount();
        pageBean.setTotalCount(totalCount);
        int totalPage = (int) Math.ceil(totalCount / pageSize);
        pageBean.setTotalPage(totalPage);
        int startRow = pageSize * (currentPage - 1) + 1;
        List<User> userList = userMapper.findUserByPages(startRow, pageSize);
        pageBean.setList(userList);
        return null;
    }

}

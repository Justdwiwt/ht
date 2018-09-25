package cn.tedu.ht.service;

import cn.tedu.ht.mapper.UserMapper;
import cn.tedu.ht.pojo.User;
import cn.tedu.ht.pojo.UserInfo;
import cn.tedu.ht.tool.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询全部的信息
     *
     * @return User
     */
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 查询用户的总数据量
     *
     * @return 用户的总数据量
     */
    @Override
    public int getUserTotalCount() {
        return userMapper.getUserTotalCount();
    }

    //返回值为：pageBean的对象
    //不只是 List<User>  还有 分页的相关数据

    /**
     * 根据分页，查询当前分页的数据
     *
     * @param currentPage 当前页码
     * @param pageSize    最大页码
     * @return PageBean
     */
    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    @Override
    public PageBean<User> findUserByPages(int currentPage, int pageSize) {
        PageBean<User> pageBean = new PageBean<>();
        //封装当前的页数
        pageBean.setCurrPage(currentPage);
        //封装每一页的数量
        pageBean.setPageSize(pageSize);
        //封装用户的总数据量
        int totalCount = userMapper.getUserTotalCount();
        pageBean.setTotalCount(totalCount);
        //封装所有的页数
        int totalPage = (int) Math.ceil(totalCount / pageSize) + 1;
        pageBean.setTotalPage(totalPage);
        //封装每一页显示的数据
        //比如 ： 从第3也开始 ，每一页10条 ，那么 开始条数为21
        int startRow = currentPage == 1 ? 0 : pageSize * (currentPage - 1) + 1;
        List<User> userList = userMapper.findUserByPages(startRow, pageSize);
        pageBean.setPageList(userList);
        return pageBean;
    }

    /**
     * 查询上级领导的信息
     *
     * @return User
     */
    @Override
    public List<User> findManagerUser() {
        return userMapper.findManagerUser();
    }

    /**
     * 新增操作
     *
     * @param user User
     */
    public void saveUser(User user) {
        //自动的生成主键
        String userId = UUID.randomUUID().toString();
        //保存 到 user_p表中
        user.setUserId(userId);
        userMapper.saveUser(user);
        //保存 到 user_info_p表中
        UserInfo userInfo = user.getUserInfo();
        userMapper.saveUserInfo(userInfo);
    }

}

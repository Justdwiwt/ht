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
    @SuppressWarnings({"IntegerDivisionInFloatingPointContext", "Convert2Diamond"})
    @Override
    public PageBean<User> findUserByPages(int currentPage, int pageSize) {
        PageBean<User> pageBean = new PageBean<User>();
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
    @Override
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

    /**
     * 保存信息到中间表中
     *
     * @param userId  User
     * @param roleIds Role
     */
    @Override
    public void saveUserRole(String userId, String roleIds) {
        //防止数据的重复插入
        userMapper.deleteUserRole(userId);
        String[] roles = roleIds.split(",");
        for (String roleId : roles)
            userMapper.saveUserRole(userId, roleId);
    }

    /**
     * 根据userid查询中间表中的信息
     *
     * @param userId User
     * @return {@code List<String>}
     */
    @Override
    public List<String> findUserRoleByUserId(String userId) {
        return userMapper.findUserRoleByUserId(userId);
    }

    /**
     * 状态的启动和停用
     *
     * @param userIds id
     * @param state   状态
     */
    @Override
    public void updateState(String[] userIds, int state) {
        userMapper.updateState(userIds, state);
    }

}

package cn.tedu.ht.shiro;

import cn.tedu.ht.pojo.User;
import cn.tedu.ht.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 原材料 realm
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 权限认证的方法重写：根据具体的业务逻辑完成方法的定义
     * 查询 数据库中 当前用户对应的 权限模块
     *
     * @param arg0 PrincipalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        String userId = user.getUserId();
        String username = user.getUsername();
        String password = user.getPassword();
        List<String> pList = userService.findModuleNameByUserId(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(pList);
        return null;
    }

    /**
     * 用户登录的认证：当前的用户的用户名和密码
     * 拿到密码之后，需要进行加密模块的验证
     *
     * @param token UsernamePasswordToken
     * @return AuthenticationInfo
     * @throws AuthenticationException error
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户名和密码：存放在登录认证的令牌当中的
        UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
        // 通过令牌对象获取 前端页面输入的 用户名信息
        String username = loginToken.getUsername();
        // 根据username，去数据库中查询当前用户是否存在
        // 程序员手动准备的原材料信息
        /* sql语句：查询用户的信息的同时获取 部门信息
         * mapper层
         * service层
         */
        User user = userService.findUserByUsername(username);

        //返回值类型为：AuthenticationInfo
        // 结果：只是根据用户名去查询了 数据库
        /* principal : 表示真实的用户 user
         * credentials ： 表示 user对象的 密码
         * realmName ： 原材料的类名 string字符串 this.getName()
         */

        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
    }

}

package com.niaobulashi.config;

import com.niaobulashi.entity.SysUser;
import com.niaobulashi.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-09 22:24
 */
@Slf4j
@Component
public class CustomRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;

    /**
     * 获取身份验证信息
     * 也就是说根据用户输入的账号和密码是否匹配
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     * @param token   用户身份信息 token
     * @return  返回封装了用户信息的 AuthenticationInfo 实例
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("------身份认证方法--------");
        //获取用户的输入的账号
        String loginName = (String)token.getPrincipal();
        log.info(token.getCredentials().toString());
        // 通过username从数据库中查询找User对象，
        SysUser sysUser = userMapper.queryUserByLoginName(loginName);
        log.info("根据loginName查询结果为：" + sysUser);
        if(sysUser == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser, //用户名
                sysUser.getPassword(), //密码
                ByteSource.Util.bytes(sysUser.getCredentialsSalt()),//salt=loginName+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("-----权限认证-----");
        String loginName = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获得该用户角色
        String role = userMapper.getRole(loginName);
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }

}

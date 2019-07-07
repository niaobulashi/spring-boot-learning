package com.niaobulashi.dao;

import com.niaobulashi.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-07 02:06
 */
public interface SysUserDao extends JpaRepository<SysUser, Integer> {

    /**
     * 根据userId删除数据
     */
    @Transactional
    @Query(value = "delete u from sys_user u where u.user_id = ?1", nativeQuery = true)
    @Modifying
    void deleteByUserId(String userId);

    /**
     * 根据UserId查询
     * @param userId
     * @return
     */
    @Query(value = "select u.* from sys_user u where u.user_id = ?1", nativeQuery = true)
    Optional<SysUser> findByUserId(String userId);

    /**
     * 根据Id更新用户相关信息
     * nativeQuery = true 添加该属性等于true则是原生SQL语句查询，不添加则是HQL语句
     */
    @Transactional
    @Query(value = "update  sys_user set email=?1, user_name=?2, pass_word=?3 where user_id=?4", nativeQuery = true)
    @Modifying
    public void updateOne(String email, String userName, String passWord, String userId);

    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    @Query(value = "SELECT " +
            "t.user_id AS userId, " +
            "t.user_name AS userName, " +
            "t.email AS email, " +
            "t.pass_word AS passWord, " +
            "r.role_id AS roleId " +
            "FROM sys_user t LEFT JOIN sys_user_role r " +
            "ON r.user_id = t.user_id " +
            "WHERE t.user_id = ?1", nativeQuery = true)
    List<SysUserInfo> findUserRole(String userId);

    /**
     * 根据username查询用户信息
     * @return
     */
    @Query(value = "select u.* from sys_user u where u.user_name like CONCAT('%',?1,'%')", nativeQuery = true)
    List<SysUser> findUserName(String nickName);
}

package com.niaobulashi.web;

import com.niaobulashi.mapper.UserMapper;
import com.niaobulashi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value="update")
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }
}

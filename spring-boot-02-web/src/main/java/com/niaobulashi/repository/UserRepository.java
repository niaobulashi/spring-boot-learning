package com.niaobulashi.repository;

import com.niaobulashi.model.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserVo, Long> {

    UserVo findByUserName(String userName);

    UserVo findByUserNameOrEmail(String username, String email);

}
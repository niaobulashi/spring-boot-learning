package com.niaobulashi.service;

import com.niaobulashi.model.UserDetail;
import com.niaobulashi.param.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDetailService {
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
}

package com.niaobulashi.service;

import com.niaobulashi.entity.SysLogEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-learning
 * @description: 系统日志
 * @author: https://niaobulashi.com
 * @create: 2019-07-03 23:53
 */
@Slf4j
@Service
public class SysLogService {

    public boolean save(SysLogEntity sysLogEntity){
        // 这里就不做具体实现了
        log.info(sysLogEntity.getParams());
        return true;
    }
}

package com.niaobulashi;

import com.niaobulashi.common.utils.RedisUtils;
import com.niaobulashi.entity.SysCodeEntity;
import com.niaobulashi.service.SysCodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private SysCodeService sysCodeService;

    @Test
    public void contextLoads() {
        Long startTime = System.currentTimeMillis(); //开始时间
        sysCodeService.queryCodeAll();
        Long endTime = System.currentTimeMillis(); //结束时间
        System.out.println("查询数据库--共耗时：" + (endTime - startTime) + "毫秒"); //1007毫秒
    }

    /**
     * 将数据字典存入缓存
     */
    @Test
    public void setCodeToRedis() {
        List<SysCodeEntity> codeEntityList = sysCodeService.queryCodeAll();
        redisTemplate.boundHashOps("codeList").put("all", codeEntityList);
    }

    /**
     * 将数据字典从缓存中删除
     */
    @Test
    public void deleteRedis() {
        redisTemplate.delete("codeList");
    }

}

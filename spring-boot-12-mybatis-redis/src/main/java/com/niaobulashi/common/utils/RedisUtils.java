package com.niaobulashi.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @program: niaobulashi
 * @description: Redis工具类
 * @author: hulang
 * @create: 2019-06-30 01:05
 */
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate redisTemplate;
    // 简单的K-V操作
    @Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOperations;

    // 针对Map类型的数据操作
    @Resource(name="redisTemplate")
    private HashOperations<String, String, Object> hashOperations;

    // 针对List类型的数据操作
    @Resource(name="redisTemplate")
    private ListOperations<String, Object> listOperations;

    // set类型数据操作
    @Resource(name="redisTemplate")
    private SetOperations<String, Object> setOperations;

    // zset类型数据操作
    @Resource(name="redisTemplate")
    private ZSetOperations<String, Object> zSetOperations;

    /**  默认过期时长，单位：秒 */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;

    /**  不设置过期时长 */
    public final static long NOT_EXPIRE = -1;

    // 普通缓存获取
    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    // 普通缓存放入
    public void set(String key, Object value){
        set(key, value, DEFAULT_EXPIRE);
    }

    // 删除缓存key
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public String get(String key, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    public void set(String key, Object value, long expire){
        valueOperations.set(key, toJson(value));
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }


    /**
     * Object转成JSON
     */
    private String toJson(Object object){
        if(object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String){
            return String.valueOf(object);
        }
        return JSON.toJSONString(object);
    }

    /**
     * JSON转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz){
        return JSON.parseObject(json, clazz);
    }

}

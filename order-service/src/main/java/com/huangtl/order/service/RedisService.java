package com.huangtl.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author huangtl
 * @Date 2020/10/10 14:49
 **/
@Component
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置缓存信息
     * @param key 键
     * @param value 值
     */
    public void set(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 获取缓存信息
     * @param key 键
     * @return 值
     */
    public String get(String key){
        Object value = redisTemplate.opsForValue().get(key);
        if(null != value) {
            return value.toString();
        }
        return "";
    }
}

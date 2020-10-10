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

    public void set(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public String get(String key){
        Object value = redisTemplate.opsForValue().get(key);
        if(null != value) {
            return value.toString();
        }
        return "";
    }
}

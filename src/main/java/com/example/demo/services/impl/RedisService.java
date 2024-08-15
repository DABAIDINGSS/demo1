package com.example.demo.services.impl;

import com.example.demo.services.RedisApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService implements RedisApi {

    @Autowired
    private JedisPool jedisPool;

    public boolean acquireLock(String key, String value, long timeout) {
        try (Jedis jedis = jedisPool.getResource()) {
            long t = jedis.setnx(key, value);
            if (t > 0) {
                jedis.expire(key, timeout);
                return true;
            }
            return false;
        }
    }
}
package com.example.demo.services;

public interface RedisApi {
    boolean acquireLock(String key, String value, long expirationTime);
}

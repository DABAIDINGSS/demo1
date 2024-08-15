package com.example.demo.controller;

import com.example.demo.services.RedisApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/redisTest")
public class RedisController {

    @Autowired
    private RedisApi redisService;

    @GetMapping("/lockDemo")
    public ResponseEntity<String> lockDemo() {
        boolean locked = redisService.acquireLock("lockdemo", "uuid", 600);
        if (locked) {
            return ResponseEntity.ok("键值锁已设置");
        } else {
            return ResponseEntity.status(409).body("键值锁已存在");
        }
    }
}
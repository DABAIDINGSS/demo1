package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class CalcController {
    @PostMapping("/add")
    @ResponseBody
    public double add(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        double result = num1 + num2;


        return result;
    }

}
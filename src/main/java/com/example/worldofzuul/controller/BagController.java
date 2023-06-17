package com.example.worldofzuul.controller;

import com.example.worldofzuul.common.Params;
import com.example.worldofzuul.service.BagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FunctionController
 * @Description 处理背包相关请求的控制器
 * @Author Ducking
 * @DATE 2023/6/15 22:45
 * @Version 1.0
 */
@RestController
@RequestMapping("/bag")
public class BagController {
    @Autowired
    private BagService bagService;

    @PostMapping("/look")
    public String look(@RequestBody Params params) {

        return "look";
    }
}

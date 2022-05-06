package cn.ckeen.controller;

import cn.ckeen.service.GreeterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description：TODO
 * @author: CKeen
 * @date: 2022/5/6 1:35 上午
 */
@RestController
public class GreeterController {

    @Resource
    private GreeterService greeterService;

    @GetMapping("greeter")
    public String greet(@RequestParam("name")String name){
        String result = greeterService.greet(name);
        return result;
    }
}

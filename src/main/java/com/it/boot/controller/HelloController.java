package com.it.boot.controller;

import com.it.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZuYingFang
 * @time 2021-09-10 16:27
 */


@Slf4j   // 日志功能，lombok插件里面的
@RestController    // 就是@ResponseBody和@Controller的合体，表明这个类的所有返回值以字符串显示到页面上
public class HelloController {


    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(){

        log.info("请求进来了");
        return "hello, springboot2";
    }


}

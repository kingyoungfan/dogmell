package com.yytec.dogmell.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 30/08/2017 22:38
 *
 * @author yangqiankun
 */
@RestController
@RequestMapping("/api")
public class IndexController {

    @GetMapping
    public String index() {
        return "李影影是个小狗狗";
    }

    @GetMapping("weather/now.json")
    public String now() {
        return "{\"results\":[{\"location\":{\"id\":\"WS10730EM8EV\",\"name\":\"深圳\",\"country\":\"CN\",\"path\":\"深圳,深圳,广东,中国\",\"timezone\":\"Asia/Shanghai\",\"timezone_offset\":\"+08:00\"},\"now\":{\"text\":\"多云\",\"code\":\"4\",\"temperature\":\"31\"},\"last_update\":\"2017-09-01T17:20:00+08:00\"}]}";
    }
}

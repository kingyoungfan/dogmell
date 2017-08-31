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
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "李影影是个小狗狗";
    }
}

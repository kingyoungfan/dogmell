package com.yytec.dogmell.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 01/09/2017 14:38
 *
 * @author yangqiankun
 */
@RestController
@RequestMapping("api")
public class UserController {

    @PostMapping("/user/login")
    public Map<String, Object> login(@RequestParam String username, @RequestParam String password) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("success", true);
        ret.put("message", "Ok");
        return ret;

    }
}

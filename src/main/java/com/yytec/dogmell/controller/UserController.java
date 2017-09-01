package com.yytec.dogmell.controller;

import org.springframework.web.bind.annotation.*;

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
    public Map<String, Object> login(@RequestBody String body) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("success", true);
        ret.put("message", "Ok");
        return ret;

    }
}

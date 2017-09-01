package com.yytec.dogmell.controller;

import com.yytec.dogmell.models.Permissions;
import com.yytec.dogmell.models.User;
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

    @GetMapping("user")
    public Map<String, Object> user() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("success", true);
        User user = new User();
        user.setId(1);
        user.setUsername("guest");
        Permissions permissions = new Permissions();
        permissions.setRole("guest");
        String[] visit = {"1", "2", "21", "7", "5", "51", "52", "53"};
        permissions.setVisit(visit);
        user.setPermissions(permissions);
        ret.put("user", user);
        return ret;
    }

    @PostMapping("/user/login")
    public Map<String, Object> login(@RequestBody String body) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("success", true);
        ret.put("message", "Ok");
        return ret;

    }
}

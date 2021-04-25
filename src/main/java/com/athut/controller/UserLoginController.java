package com.athut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author yangwan
 * @create 2021-04-25 13:26
 */
@Controller
public class UserLoginController {
    @PostMapping("/userlogin")
    public String userLogin(@RequestParam String nickname,
                            @RequestParam String password,
                            HttpSession session,){

    }
}

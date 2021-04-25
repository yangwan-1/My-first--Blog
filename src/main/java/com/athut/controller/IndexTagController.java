package com.athut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yangwan
 * @create 2021-04-22 20:28
 */
@Controller
public class IndexTagController {
    @GetMapping("/tagList")
    public String tag(){
        return "tags";
    }
}

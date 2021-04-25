package com.athut.controller;

import com.athut.pojo.Blog;
import com.athut.service.impl.BlogServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-22 20:34
 */
@Controller
public class ArchivesController {
    @Autowired
    BlogServiceImpl blogService;
    @GetMapping("/archives")
    public String archives(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
    Model model){
        PageHelper.startPage(pn,5);
       List<Blog> blog =  blogService.listBlog();
       PageInfo pageInfo = new PageInfo<>(blog);
       model.addAttribute("blog",pageInfo);
        return "archives";
    }
}

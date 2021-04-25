package com.athut.controller;

import com.athut.NotFoundException;
import com.athut.pojo.Blog;
import com.athut.pojo.Type;
import com.athut.service.impl.BlogServiceImpl;
import com.athut.service.impl.TagServiceImpl;
import com.athut.service.impl.TypeServiceImpl;
import com.athut.vo.BlogQuery;
import com.athut.vo.DetailedBlog;
import com.athut.vo.IndexPageBlog;
import com.athut.vo.SearchBlog;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-08 15:09
 */
@Controller
public class IndexController {
    @Autowired
    BlogServiceImpl blogService;
    @Autowired
    TypeServiceImpl typeService;
    @Autowired
    TagServiceImpl tagService;
    @GetMapping("/")
    public String index(@RequestParam(value = "pn",defaultValue = "1")Integer pn
            , Model model){
        String orderBy = "update_time desc";
        PageHelper.startPage(pn,4,orderBy);
       List<IndexPageBlog> blog =  blogService.listIndexBlog();
        PageInfo pageInfo = new PageInfo(blog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("typeInfo",typeService.listTypeLimit());
        model.addAttribute("tagInfo",tagService.listTagLimit());
        return "index";
    }

    @RequestMapping ("/blog")
    public String blog(){
        return "blog";
    }

    @GetMapping("/about")
    public String aboutMe(){
        return "aboutme";
    }

    @PostMapping("/search")
    public String indexBlogsSearch(@RequestParam String query,
                @RequestParam(value="pn",defaultValue = "1") Integer pn,
                Model model) {
        PageHelper.startPage(pn, 5);
        List<IndexPageBlog> blog = blogService.findBlogByName(query);
        PageInfo pageInfo = new PageInfo<>(blog);
        model.addAttribute("pageInfo", pageInfo);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String detailBlog(@PathVariable Long id,
                             Model model){
        DetailedBlog blog = blogService.findDetailBlogById(id);
        blogService.getAndConvert(blog.getId());
         model.addAttribute("blog",blog);
        return "blog";
    }
}

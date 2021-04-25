package com.athut.controller;

import com.athut.pojo.Type;
import com.athut.service.impl.BlogServiceImpl;
import com.athut.service.impl.TypeServiceImpl;
import com.athut.vo.IndexPageBlog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-22 20:21
 */
@Controller
public class IndexTypeController {
    @Autowired
    TypeServiceImpl typeService;
    @Autowired
    BlogServiceImpl blogService;
    @GetMapping("/typesList/{typeId}")
    public String type(@RequestParam(defaultValue = "1",value = "pn") Integer pn,
                       @PathVariable Long typeId,Model model){
        List<Type> type = typeService.listTypeWithBlog();
        model.addAttribute("type",type);
        if (typeId == -1){
          typeId =  type.get(0).getId();
        }
        List<IndexPageBlog> blogs = blogService.listBlogByTypeId(typeId);
        PageHelper.startPage(pn,1000);
        PageInfo pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeTypeId",typeId);
        return "category";
    }
}

package com.athut.controller.admin;

import com.athut.pojo.Blog;
import com.athut.pojo.User;
import com.athut.service.impl.BlogServiceImpl;
import com.athut.service.impl.TagServiceImpl;
import com.athut.service.impl.TypeServiceImpl;
import com.athut.vo.BlogQuery;
import com.athut.vo.SearchBlog;
import com.athut.vo.ShowBlog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-12 14:32
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    BlogServiceImpl blogService;
    @Autowired
    TypeServiceImpl typeService;
    @Autowired
    TagServiceImpl tagService;

    @RequestMapping ("/blogs")
    public String blogs(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        String orderBy = "update_time desc";
        PageHelper.startPage(pn,8,orderBy);
        List<BlogQuery> list = blogService.listBlogWithType();
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(list);
        model.addAttribute("types",typeService.listType());
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String blogsSearch(SearchBlog searchBlog,
                              @RequestParam(value="pn",defaultValue = "1") Integer pn,
                              Model model){
        List<BlogQuery> blogQueries = blogService.getSearch(searchBlog);
        PageHelper.startPage(pn,5);
      PageInfo pageInfo =   new PageInfo<>(blogQueries);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs :: blogList";
    }

    @GetMapping("/blogs/input")
    public String blogsInput(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        return "admin/blogs-input";
    }

    @GetMapping("/blogs/{id}/input")
    public String blogsUpdateInput(@PathVariable Long id,Model model){
        model.addAttribute("blog",blogService.findBlogById(id));
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        return "admin/blogs-input";
    }

    @PostMapping("/blogs/add")
    public String blogsAdd(Blog blog, RedirectAttributes attributes
                           ,HttpSession session){
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getTypeById(blog.getType().getId()));
        blog.setTypeId(blog.getType().getId());
        blog.setUserId(blog.getUser().getId());
       int i =  blogService.saveBlog(blog);
       if (i == 0){
           attributes.addFlashAttribute("message","新增博客失败");
       }
       else {
           attributes.addFlashAttribute("message","新增博客成功");
       }
       return "redirect:/admin/blogs";
    }

    @PostMapping("/blogs/{id}/update")
    public String blogsUpdate(ShowBlog showBlog, RedirectAttributes attributes){
        int i =  blogService.updateBlog(showBlog);
        if (i == 0){
            attributes.addFlashAttribute("message","修改博客失败");
        }
        else {
            attributes.addFlashAttribute("message","修改博客成功");
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/{id}/delete")
    public String blogsDelete(@PathVariable Long id){
       blogService.deleteBlogById(id);
        return "redirect:/admin/blogs";
    }

}

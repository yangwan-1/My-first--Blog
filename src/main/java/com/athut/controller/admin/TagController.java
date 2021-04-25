package com.athut.controller.admin;

import com.athut.pojo.Tag;
import com.athut.pojo.Type;
import com.athut.service.impl.TagServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-12 19:00
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    TagServiceImpl tagService;

    @GetMapping("/tags")
    public String tag(@RequestParam(value = "pn",defaultValue = "1")
                        Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Tag> tags = tagService.listTag();
        PageInfo pageInfo = new PageInfo<>(tags,5);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs-tags";
    }

    @GetMapping("/tags/input")
    public String typesInput(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tag-input";
    }

    @PostMapping("/tags")
    public String typesAdd( Tag tag, BindingResult result,
                           RedirectAttributes attributes) {
            boolean flag = tagService.getTagByName(tag.getName());
            if (flag){
                int i = tagService.addTag(tag);
                if (i == 0) {
                    attributes.addFlashAttribute("message", "添加标签失败");
                } else {
                    attributes.addFlashAttribute("message", "添加标签成功");
                }
                return "redirect:/admin/tags";
            }
            else{
                attributes.addFlashAttribute("message","标签不能重复添加");
                return "redirect:/admin/tags/input";
            }
    }

    @PostMapping("/tags/{id}")
    public String typesUpdate( Tag tag, @PathVariable Long id,
                            RedirectAttributes attributes) {
        boolean flag = tagService.getTagByName(tag.getName());
        if (flag){
            int i = tagService.updateTag(id,tag.getName());
            if (i == 0) {
                attributes.addFlashAttribute("message", "更新失败");
            } else {
                attributes.addFlashAttribute("message", "更新成功");
            }
            return "redirect:/admin/tags";
        }
        else{
            attributes.addFlashAttribute("message","标签不能重复添加");
            return "redirect:/admin/tags/input";
        }
    }

    @GetMapping("/tags/{id}/delete")
    public String deleteType(@PathVariable("id")Long id,
                             RedirectAttributes attributes){
             tagService.deleteTag(id);
            attributes.addFlashAttribute("message","删除成功");
            return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/update")
    public String update(@PathVariable Long id,Model model){
       Tag tag =  tagService.getTagById(id);
      model.addAttribute("tag",tag);
       return "/admin/tag-input";
    }
}

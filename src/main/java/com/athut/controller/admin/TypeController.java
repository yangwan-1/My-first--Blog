package com.athut.controller.admin;

import com.athut.pojo.Type;
import com.athut.service.impl.TypeServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-12 19:00
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    TypeServiceImpl typeService;

    @GetMapping("/types")
    public String type(@RequestParam(value = "pn",defaultValue = "1")
                        Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Type> types = typeService.listType();
        PageInfo<Type> pageInfo = new PageInfo<>(types, 5);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs-types";
    }

    @GetMapping("/types/input")
    public String typesInput(Model model){
        model.addAttribute("type",new Type());
        return "admin/type-input";
    }

    @PostMapping("/types")
    public String typesAdd( Type type, BindingResult result,
                           RedirectAttributes attributes) {
            boolean flag = typeService.getTypeByName(type.getName());
            if (flag){
                int i = typeService.addType(type);
                if (i == 0) {
                    attributes.addFlashAttribute("message", "添加失败");
                } else {
                    attributes.addFlashAttribute("message", "添加成功");
                }
                return "redirect:/admin/types";
            }
            else{
                attributes.addFlashAttribute("message","标签不能重复添加");
                return "redirect:/admin/types/input";
            }
    }

    @PostMapping("/types/{id}")
    public String typesAdd( Type type, @PathVariable Long id,
                            RedirectAttributes attributes) {
        boolean flag = typeService.getTypeByName(type.getName());
        if (flag){
            int i = typeService.updateType(id,type.getName());
            if (i == 0) {
                attributes.addFlashAttribute("message", "更新失败");
            } else {
                attributes.addFlashAttribute("message", "更新成功");
            }
            return "redirect:/admin/types";
        }
        else{
            attributes.addFlashAttribute("message","标签不能重复添加");
            return "redirect:/admin/types/input";
        }
    }

    @GetMapping("/types/delete")
    public String deleteType(@RequestParam("id")Long id,
                             RedirectAttributes attributes){
             typeService.deleteType(id);
            attributes.addFlashAttribute("message","删除成功");
            return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/update")
    public String update(@PathVariable Long id,Model model){
       Type type =  typeService.getTypeById(id);
      model.addAttribute("type",type);
       return "/admin/type-input";
    }
}

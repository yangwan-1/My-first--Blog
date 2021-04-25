package com.athut;

import com.athut.pojo.Type;
import com.athut.pojo.User;
import com.athut.service.impl.BlogServiceImpl;
import com.athut.service.impl.TypeServiceImpl;
import com.athut.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    TypeServiceImpl typeService;

    @Autowired
    BlogServiceImpl blogService;
    @Test
    void contextLoads() {
//        User user = userService.checkUser("杨万", "Apple970504");
//        System.out.println(user);
       // List<Type> types = typeService.listType();
        //System.out.println(types);
       List list = blogService.listBlog();
        System.out.println(list.size());
      // List blog = blogService.findBlogByName("大话西游");
       // System.out.println(blog);
      // List blog = blogService.listBlogByTypeId(88L);
        //System.out.println(blog);
       //List list  = typeService.listTypeWithBlog();
       // list.forEach(System.out::println);

    }


}

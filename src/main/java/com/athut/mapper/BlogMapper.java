package com.athut.mapper;

import com.athut.pojo.Blog;
import com.athut.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-14 14:21
 */
@Mapper
public interface BlogMapper {
    Blog findBlogById(@Param("id") Long id);
    List<Blog> listBlog();
    int deleteBlogById(@Param("id") Long id);
    int saveBlog(Blog blog);
    int updateBlog(ShowBlog showBlog);
    List<BlogQuery> searchBlog(SearchBlog blog);
    List<BlogQuery> listBlogWithType();
    List<IndexPageBlog> listIndexBlog();
    List<IndexPageBlog> findBlogByName(String query);
    DetailedBlog findDetailBlogById(Long id);
    List<IndexPageBlog> listBlogByTypeId(Long typeId);
}

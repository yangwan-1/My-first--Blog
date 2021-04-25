package com.athut.service;

import com.athut.pojo.Blog;
import com.athut.vo.*;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-14 14:18
 */
public interface BlogService {
Blog findBlogById(Long id);
List listBlog();
List listBlogWithType();
int deleteBlogById(Long id);
int saveBlog(Blog blog);
int updateBlog(ShowBlog showBlog);
List<BlogQuery> getSearch(SearchBlog searchBlog);
List<IndexPageBlog> listIndexBlog();
List<IndexPageBlog> findBlogByName(String query);
DetailedBlog findDetailBlogById(Long id);
DetailedBlog getAndConvert(Long id);
List<IndexPageBlog> listBlogByTypeId(Long typeId);
}

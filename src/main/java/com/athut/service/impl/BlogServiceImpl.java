package com.athut.service.impl;

import com.athut.NotFoundException;
import com.athut.mapper.BlogMapper;
import com.athut.pojo.Blog;
import com.athut.service.BlogService;
import com.athut.utils.MarkDownUtils;
import com.athut.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-14 14:20
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Override
    public Blog findBlogById(Long id) {
        return blogMapper.findBlogById(id);
    }

    @Override
    public List listBlog() {
        return blogMapper.listBlog();
    }

    @Override
    public List listBlogWithType() {
        return blogMapper.listBlogWithType();
    }

    @Override
    public int deleteBlogById(Long id) {
        return blogMapper.deleteBlogById(id);
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        return blogMapper.saveBlog(blog);
    }

    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogMapper.updateBlog(showBlog);
    }

    @Override
    public List<BlogQuery> getSearch(SearchBlog searchBlog) {
        return blogMapper.searchBlog(searchBlog);
    }

    public List<IndexPageBlog> listIndexBlog() {
       return blogMapper.listIndexBlog();
    }

    @Override
    public List<IndexPageBlog> findBlogByName(String query) {
        return blogMapper.findBlogByName(query);
    }

    @Override
    public DetailedBlog findDetailBlogById(Long id) {
        return blogMapper.findDetailBlogById(id);
    }

    @Override
    public DetailedBlog getAndConvert(Long id) {
        DetailedBlog blog = blogMapper.findDetailBlogById(id);
        if (blog == null){
            throw new NotFoundException("该博客不存在");
        }
        String content = blog.getContent();
        MarkDownUtils.markdownToHtmlExtensions(content);
        blog.setContent(content);
        return blog;
    }

    @Override
    public List<IndexPageBlog> listBlogByTypeId(Long typeId) {
        return blogMapper.listBlogByTypeId(typeId);
    }
}

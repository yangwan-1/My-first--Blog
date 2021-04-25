package com.athut.service;

import com.athut.pojo.Comment;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-21 19:12
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);
    int saveComment(Comment comment);
}

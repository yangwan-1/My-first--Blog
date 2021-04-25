package com.athut.service;

import com.athut.pojo.Tag;
import com.athut.pojo.Type;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-13 19:41
 */
public interface TagService {
    int addTag(Tag tag);
    List<Tag> listTag();
    boolean getTagByName(String name);
    int deleteTag(Long id);
    int updateTag(Long id,String name);
    Tag getTagById(Long id);
    List<Tag> listTagLimit();
}

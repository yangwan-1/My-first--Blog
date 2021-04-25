package com.athut.service.impl;

import com.athut.mapper.TagMapper;
import com.athut.pojo.Tag;
import com.athut.pojo.Type;
import com.athut.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-13 19:42
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;


    @Override
    public int addTag(Tag tag) {
        return tagMapper.addTag(tag);
    }

    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }

    @Override
    public boolean getTagByName(String name) {
        Tag tagName = tagMapper.getTagByName(name);
        if (tagName != null){
            return false;
        }
        return true;
    }

    @Override
    public int deleteTag(Long id) {
        return tagMapper.deleteTag(id);
    }

    @Override
    public int updateTag(Long id, String name) {
        return tagMapper.updateTag(id,name);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagMapper.getTagById(id);
    }

    public List<Tag> listTagLimit() {
        return tagMapper.listTagLimit();
    }
}

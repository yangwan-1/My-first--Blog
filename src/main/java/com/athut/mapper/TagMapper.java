package com.athut.mapper;

import com.athut.pojo.Tag;
import com.athut.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-13 19:32
 */
@Mapper
public interface TagMapper {
    int addTag(Tag tag);
    Tag getTagByName(@Param("name") String name);
    List<Tag> listTag();
    int deleteTag(@Param("id") Long id);
    int updateTag(@Param("id")  Long id,@Param("name") String name);
    Tag getTagById(@Param("id") Long id);

    List<Tag> listTagLimit();
}

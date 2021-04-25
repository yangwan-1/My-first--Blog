package com.athut.mapper;

import com.athut.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-12 16:37
 */
@Mapper
public interface TypeMapper {
    int addType(Type type);
    Type getTypeByName(@Param("name") String name);
    List<Type> listType();
    int deleteType(@Param("id") Long id);
    int updateType(@Param("id")  Long id,@Param("name") String name);
    Type getTypeById(@Param("id") Long id);
    List<Type> listTypeLimit();
    List<Type> listTypeWithBlog();
}

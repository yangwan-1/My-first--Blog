package com.athut.service;

import com.athut.pojo.Type;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-12 16:42
 */
public interface TypeService {
    int addType(Type type);
    List<Type> listType();
    boolean getTypeByName(String name);
    int deleteType(Long id);
    int updateType(Long id,String name);
    Type getTypeById(Long id);
    List<Type> listTypeLimit();
    List<Type> listTypeWithBlog();
}

package com.athut.service.impl;

import com.athut.mapper.TypeMapper;
import com.athut.pojo.Type;
import com.athut.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangwan
 * @create 2021-04-12 16:43
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;


    @Override
    public int addType(Type type) {
        return typeMapper.addType(type);
    }

    @Override
    public List<Type> listType() {
      return typeMapper.listType();
    }

    //返回false,用户名不可用
    @Override
    public boolean getTypeByName(String name) {
        Type typeName = typeMapper.getTypeByName(name);
        if (typeName != null){
            return false;
        }
        return true;
    }

    @Override
    public int deleteType(Long id) {
        return typeMapper.deleteType(id);
    }

    @Override
    public int updateType(Long id, String name) {
        return typeMapper.updateType(id,name);
    }

    @Override
    public Type getTypeById(Long id) {
        return typeMapper.getTypeById(id);
    }

    public List<Type> listTypeLimit() {
     return    typeMapper.listTypeLimit();
    }

    @Override
    public List<Type> listTypeWithBlog() {
        return typeMapper.listTypeWithBlog();
    }
}

package com.baizhi.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T> {
    //分页
    public List<T> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);
    //查所有
    public  List<T> findAll();
    //添加
    public  void  insert(T t);
    //删除
    public  void  delete(T t);
    //修改
    public  void  update(T t);
    //数量
    public  Integer count();
}

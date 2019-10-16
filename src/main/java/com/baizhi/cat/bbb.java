package com.baizhi.cat;


import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
public class bbb implements Cache {
    /*
     * namespace
     * id=com.baizhi.mapper.EmpMapper
     * */
    private String id;

    public bbb(String id) {
        System.out.println(id);
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    /*
     * 添加缓存
     * */
    @Override
    public void putObject(Object key, Object value) {
        RedisTemplate redisTemplate = (RedisTemplate) aaa.getBeanByName("redisTemplate");
        redisTemplate.opsForHash().put(id, key.toString(), value);
        System.out.println("putObject is invoke");
    }

    /*a
     *
     * 获取缓存
     * */
    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = (RedisTemplate) aaa.getBeanByName("redisTemplate");
        Object o = redisTemplate.opsForHash().get(id, key.toString());
        System.out.println("getObject is invoke");
        return o;
    }

    @Override
    public Object removeObject(Object key) {
        System.out.println("removeObject");
        return null;
    }

    @Override
    public void clear() {
        /*清空namespace下的缓存*/
        RedisTemplate redisTemplate = (RedisTemplate) aaa.getBeanByName("redisTemplate");
        redisTemplate.delete(id);
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
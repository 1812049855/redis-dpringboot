package com.baizhi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisSpringbootApplicationTests {


    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1() {
        /*
         * 键相关的指令
         * */
        Set keys = redisTemplate.keys("*");
        System.out.println(keys);
    }

    @Test
    public void test2() {
        /*
         * string   redisTemplate.opsForValue().set("name","zhangsan");
         * list     redisTemplate.opsForList().leftPush("list","a","b");
         * set      redisTemplate.opsForSet().add("set","a","b","c");
         * zset     redisTemplate.opsForZSet().add("zset","aa",20);
         * hash     redisTemplate.opsForHash().put("map","id","1");
         * */
        stringRedisTemplate.opsForValue().set("string", "zhangsan");
        stringRedisTemplate.opsForList().leftPush("list", "aa");
        stringRedisTemplate.opsForSet().add("set", "a", "b", "c");
        stringRedisTemplate.opsForZSet().add("zset", "aa", 20);
        stringRedisTemplate.opsForHash().put("map", "id", "1");
    }


    @Test
    public void test3() {
        String str = stringRedisTemplate.opsForValue().get("string");
        System.out.println(str);
        List<String> list = stringRedisTemplate.opsForList().range("list", 0, -1);
        for (String s : list) {
            System.out.println(s);
        }

        Set<String> set = stringRedisTemplate.opsForSet().members("set");
        for (String s : set) {
            System.out.println(s);
        }
        Set<ZSetOperations.TypedTuple<String>> zset = stringRedisTemplate.opsForZSet().rangeWithScores("zset", 0, -1);
        for (ZSetOperations.TypedTuple<String> stringTypedTuple : zset) {
            System.out.println(stringTypedTuple.getValue());
            System.out.println(stringTypedTuple.getScore());
        }
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("map");
        for (Object o : map.keySet()) {
            System.out.println(o);
            System.out.println(map.get(o));
        }
    }

    @Test
    public void name() {
        BoundValueOperations<String, String> boundvalueOps = stringRedisTemplate.boundValueOps("key1");
        boundvalueOps.set("value1");
        String s = boundvalueOps.get();
        System.out.println(s);
        BoundHashOperations<String, Object, Object> boundHashOperations = stringRedisTemplate.boundHashOps("hash");
        boundHashOperations.put("id","1");
        boundHashOperations.put("name","zhangsan");
        Map<Object, Object> entries = boundHashOperations.entries();
        for (Object o : entries.keySet()) {
            System.out.println(o);
            System.out.println(entries.get(o));
        }
    }

}

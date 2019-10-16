package com.baizhi;


import com.baizhi.entity.Book;
import com.baizhi.mapper.BookMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Testbook {
    @Autowired
    BookMapper bookMapper;


    @Test
    public  void  d1(){
        List<Book> all = bookMapper.findAll();
        for (Book book : all) {
            System.out.println(book);
        }
    }
}

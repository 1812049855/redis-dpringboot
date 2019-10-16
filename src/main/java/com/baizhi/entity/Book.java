package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Book implements Serializable{
    private String id;
    private  String name;
    @JsonFormat(pattern = "yyyy-MM-dd" , timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  createTime;
    private  Double price;
    private  String author;
}

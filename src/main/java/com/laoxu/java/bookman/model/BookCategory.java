package com.laoxu.java.bookman.model;


import lombok.Data;

/**
 * @Description: 图书分类
 * @Author laoxu
 * @Date 2019/12/29 15:26
 **/
@Data
public class BookCategory extends BaseModel {
    private String code;
    private String name;
}

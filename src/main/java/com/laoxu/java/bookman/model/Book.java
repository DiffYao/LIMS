package com.laoxu.java.bookman.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 图书
 * @Author laoxu
 * @Date 2020/1/5 16:18
 **/
@Data
public class Book extends BaseModel {
    // 图书名称
    private String name;
    // 图书编号（ISBN）
    private String isbn;
    // 图书分类编码
    private String categoryCode;
    // 图书分类名称
    private String categoryName;
    // 作者
    private String author;
    // 出版社编码
    private String publisherCode;
    // 出版社名称
    private String publisherName;
    // 单价（元）
    private BigDecimal price;
    // 版次
    private Integer edition;
    // 译者
    private String translator;
    // 语种编码
    private String languageCode;
    // 语种名称
    private String languageName;
    // 页数
    private Integer pages;
    // 字数
    private Integer words;
    // 书架编码
    private String locationCode;
    // 书架名称
    private String locationName;
    // 藏书数量
    private Integer totalNumber;
    // 馆内剩余
    private Integer leftNumber;
    // 内容简介
    private String description;
    // 备注
    private String remark;
    // 图片路径
    private String imgPath;
    // 注册时间
    private Date registerTime;
}

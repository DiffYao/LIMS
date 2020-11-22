package com.laoxu.java.bookman.vo;

import com.laoxu.java.bookman.model.BaseModel;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 借阅管理
 * @Author laoxu
 * @Date 2020/1/12 22:37
 **/
@Data
public class BookBorrowVO extends BaseModel {
    private Long id;
    private String readerCode;
    private String readerName;
    private String readerSex;
    private String readerPhone;
    private String bookIsbn;
    private String bookName;
    private String bookAuthor;
    private String bookCategory;
    private String bookLocation;
    private Integer bookTotal;
    private Integer bookLeft;
    private Date borrowDate;
    private Date returnDate;
    private Date realReturnDate;
    private Integer borrowDays;
    private Integer reBorrowDays;
    private Integer borrowStatus;
    private String remark;

}

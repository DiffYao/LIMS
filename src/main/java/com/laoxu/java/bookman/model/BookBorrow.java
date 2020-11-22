package com.laoxu.java.bookman.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 借阅管理
 * @Author laoxu
 * @Date 2020/1/12 22:37
 **/
@Data
public class BookBorrow extends BaseModel {
    private String readerCode;
    private String bookIsbn;
    private Date borrowDate;
    private Date returnDate;
    // 实际归还日期
    private Date realReturnDate;
    private Integer borrowDays;
    // 续借天数
    private Integer reBorrowDays;
    // 借阅状态 0未还；1已还；2逾期
    private Integer borrowStatus;
    private String remark;

}

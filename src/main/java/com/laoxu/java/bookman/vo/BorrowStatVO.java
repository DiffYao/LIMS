package com.laoxu.java.bookman.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description: 借阅统计
 * @Author laoxu
 * @Date 2020/2/4 14:05
 **/
@Data
public class BorrowStatVO {
    private String name;
    private String type;
    private List<Integer> data;
}

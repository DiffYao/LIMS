package com.laoxu.java.bookman.model;


import lombok.Data;

/**
 * @Description: 读者
 * @Author laoxu
 * @Date 2019/12/29 15:26
 **/
@Data
public class BookReader extends BaseModel {
    private String code;
    private String name;
    private String sex;
    private String phone;

}

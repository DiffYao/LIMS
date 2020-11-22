package com.laoxu.java.bookman.model;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 基本模型字段
 * @Author laoxu
 * @Date 2019/12/29 15:24
 **/
@Data
public abstract class BaseModel {
    private Long id;
    // 创建时间
    private Date createTime;
    // 创建人
    private String creater;
    // 修改时间
    private Date updateTime;
    // 修改人
    private String updater;
}

package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.model.FileModel;
import com.laoxu.java.bookman.framework.AbstractService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description: 文件上传服务
 * @Author laoxu
 * @Date 2019/5/2 9:26
 **/
@Service
public class FileService extends AbstractService {
    public void add(FileModel fileEntity) {
        insert("fileMapper.insert", fileEntity);
    }

    public void remove(String fileId) {
        delete("fileMapper.delete",fileId);
    }

    public FileModel get(String fileId) {
        return selectOne("fileMapper.select",fileId);
    }

    public int count(Map<String, Object> param) {
        return selectOne("fileMapper.count",param);
    }

}

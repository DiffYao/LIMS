package com.laoxu.java.bookman.model;

import java.util.Date;

/**
 * @Description: 上传文件实体
 * @Author laoxu
 * @Date 2019/6/17 23:25
 **/
public class FileModel {
    // 文件ID, UUID
    private String fileId;
    // 对象ID，例如：user.id,post.id
    private Long objectId;
    // 对象类型，例如：user,post
    private String objectType;
    // 文件名
    private String fileName;
    // 文件扩展名
    private String fileExtension;
    // 文件大小，字节
    private Long fileSize;
    // 文件路径，相对路径
    private String filePath;
    // 上传时间
    private Date uploadTime;
    // 上传人
    private String uploader;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}

package com.laoxu.java.bookman.framework;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: ckeditor响应体
 * @Author laoxu
 * @Date 2019/5/13 10:35
 **/
public class FileResponse extends HashMap<String, Object> {

    Map<String,Object> msgMap = new HashMap<>();

    public String error(int code, String msg){
        FileResponse result = new FileResponse();
        msgMap.put("message",msg);
        result.put("uploaded",code);
        result.put("error",msgMap);
        return JSON.toJSONString(result);
    }

    public String success(int code, String fileName ,String url, String msg){
        FileResponse result = new FileResponse();
        if(!StringUtils.isEmpty(msg)){
            msgMap.put("message",msg);
            result.put("error",msgMap);
        }
        result.put("uploaded",code);
        result.put("fileName",fileName);
        result.put("url",url);
        return JSON.toJSONString(result);
    }
}
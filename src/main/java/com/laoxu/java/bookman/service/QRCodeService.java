package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.framework.AbstractService;
import com.github.binarywang.utils.qrcode.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class QRCodeService extends AbstractService {
    public static void CreateQrcode(String text, String savePath){
        QrcodeUtils qrcodeUtils = new QrcodeUtils();
        String file_path = "C:\\Users\\86151\\Desktop\\logofile.png";
        //String savePath = "C:\\Users\\86151\\Desktop\\Qrcode_1.png";
        File logofile = new File(file_path);
        try{
            byte[] res = qrcodeUtils.createQrcode(text, logofile);
            ByteArrayInputStream bais = new ByteArrayInputStream(res);
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File(savePath);
            ImageIO.write(bi1, "jpg", w2);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void CreateQrcode(){
        QrcodeUtils qrcodeUtils = new QrcodeUtils();
        String text = "www.baidu.com";
        String file_path = "C:\\Users\\86151\\Desktop\\logofile.png";
        String savePath = "C:\\Users\\86151\\Desktop\\Qrcode_1.png";
        File logofile = new File(file_path);
        try{
            byte[] res = qrcodeUtils.createQrcode(text, logofile);
            ByteArrayInputStream bais = new ByteArrayInputStream(res);
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File(savePath);
            ImageIO.write(bi1, "jpg", w2);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
/*
    public static void main(String[] args) {
        String text_template = "http://211.81.52.4:8800/bookDetail/";
        String save_template = "C:\\Users\\86151\\Desktop\\Qrcode_";
        for (int i = 1; i <= 100; i++) {
            String text = text_template + i;
            String savePath = save_template+i+".png";
            CreateQrcode(text, savePath);
        }
    }

 */

}

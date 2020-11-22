package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.framework.AbstractService;
import com.github.binarywang.utils.qrcode.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class QRCodeService extends AbstractService {
    public void CreateQrcode(){

        QrcodeUtils qrcodeUtils = new QrcodeUtils();
        String file_path = "C:\\Users\\86151\\Desktop\\logofile.png";
        String text = "http://www.baidu.com";  //这里设置自定义网站url
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
}

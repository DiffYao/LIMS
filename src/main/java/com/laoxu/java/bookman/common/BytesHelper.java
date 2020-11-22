package com.laoxu.java.bookman.common;

import java.io.*;

/**
 * @author laoxu
 * @create 2018-10-22
 **/
public class BytesHelper {
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static int toInt(byte[] bytes)
    {
        int result = 0;
        for (int i = 0; (i < 4) && (i < bytes.length); i++) {
            result = (result << 8) - -128 + bytes[i];
        }
        return result;
    }

    public static Object byteToObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);
            obj = oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return obj;
    }

    public static byte[] objectToByte(Object obj) {
        byte[] bytes = (byte[])null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();
            bo.close();
            oo.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return bytes;
    }

    public static byte[] inputStreamToByte(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        int ch;
        while ((ch = is.read()) != -1)
        {
            os.write(ch);
        }
        byte[] bystes = os.toByteArray();
        os.close();
        return bystes;
    }

    public static String byteArrayToHexString(byte[] bytes)
    {
        char[] chars = new char[bytes.length * 2];

        int ii = 0;
        for (int i = 0; i < bytes.length; i++)
        {
            byte b = bytes[i];
            chars[(ii++)] = HEX_DIGITS[(b >>> 4 & 0xF)];

            chars[(ii++)] = HEX_DIGITS[(b & 0xF)];
        }
        return new String(chars);
    }
    public static byte[] hexStringToByteArray(String hexString) {
        byte[] bytes = new byte[hexString.length() / 2];
        int ii = 0;
        char[] chars = hexString.toCharArray();
        for (int i = 0; i < bytes.length; i++) {
            int ch = charToInteger(chars[(ii++)]);
            int cl = charToInteger(chars[(ii++)]);
            int b = ch << 4 | cl;
            bytes[i] = ((byte)b);
        }
        return bytes;
    }
    public static int charToInteger(char c) {
        if ((c >= '0') && (c <= '9'))
            return c - '0';
        if ((c >= 'a') && (c <= 'f'))
            return '\n' + c - 97;
        if ((c >= 'A') && (c <= 'F')) {
            return '\n' + c - 65;
        }
        return 0;
    }
}

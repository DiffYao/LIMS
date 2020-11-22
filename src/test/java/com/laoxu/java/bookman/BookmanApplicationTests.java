package com.laoxu.java.bookman;

import com.laoxu.java.bookman.common.MD5Util;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookmanApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(MD5Util.encode("123456"));
    }

}

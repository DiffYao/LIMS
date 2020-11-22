package com.laoxu.java.bookman.common;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.encode((String) rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        //user Details Service验证
        return encodedPassword.equals(MD5Util.encode((String) rawPassword));
    }
}

package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  自定义UserService
 */
@Service
public class UserDetailServiceImpl<T extends User> implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userService.getUserByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("用户："+username+"不存在！");
            }
            //用户权限
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            /*if (StringUtils.isNotBlank(user.getRoles())) {
                String[] roles = user.getRoles().split(",");
                for (String role : roles) {
                    if (StringUtils.isNotBlank(role)) {
                        authorities.add(new SimpleGrantedAuthority(role.trim()));
                    }
                }
            }*/
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

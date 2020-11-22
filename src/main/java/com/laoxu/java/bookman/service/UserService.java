package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.common.MD5Util;
import com.laoxu.java.bookman.framework.AbstractService;
import com.laoxu.java.bookman.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: 用户服务
 * @Author laoxu
 * @Date 2019/5/2 9:26
 **/
@Service
public class UserService extends AbstractService {

    public void add(User user) {
        String md5Password = MD5Util.encode(user.getPassword());
        user.setPassword(md5Password);

        insert("userMapper.insert",user);
    }

    public void modify(User user) {
        update("userMapper.update",user);
    }

    public void remove(Long id) {
        delete("userMapper.delete",id);
    }

    public User getUserByUsername(String username) {
        return selectOne("userMapper.selectUserByUsername",username);
    }

    public int countUsername(String username) {
        return selectOne("userMapper.countUsername",username);
    }

    public int count(Map<String, Object> param) {
        return selectOne("userMapper.count",param);
    }

    public List<User> getPageResult(Map<String, Object> param) {
        return selectList("userMapper.selectPageResult",param);
    }


}

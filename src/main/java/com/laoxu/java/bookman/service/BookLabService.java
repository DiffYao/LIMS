package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.framework.AbstractService;
import com.laoxu.java.bookman.model.BookShelf;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: 书架服务
 * @Author laoxu
 * @Date 2020/12/19 9:26
 **/

public class BookLabService extends AbstractService{
    public void add(BookShelf entity) {
        //String username = SecurityUtil.getLoginUser();
        insert("bookLabMapper.insert",entity);
    }

    public void modify(BookShelf entity) {
        update("bookLabMapper.update",entity);
    }

    public void remove(Long id) {
        delete("bookLabMapper.delete",id);
    }

    public void removes(Long[] ids) {
        delete("bookLabMapper.deletes",ids);
    }

    public BookShelf get(Long id) {
        return selectOne("bookLabMapper.select",id);
    }

    public List<BookShelf> getParentList(Long id) {
        return selectList("bookLabMapper.selectParentList",id);
    }

    public int count(Map<String, Object> param) {
        return selectOne("bookLabMapper.count",param);
    }

    public List<BookShelf> getList(Map<String, Object> param) {
        return selectList("bookLabMapper.selectList",param);
    }

    public List<BookShelf> getPageResult(Map<String, Object> param) {
        return selectList("bookLabMapper.selectPageResult",param);
    }

    public int checkCode(BookShelf entity){
        return selectOne("bookLabMapper.countCode",entity);
    }

}

package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.framework.AbstractService;
import com.laoxu.java.bookman.model.BookShelf;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: 书架服务
 * @Author laoxu
 * @Date 2019/5/2 9:26
 **/
@Service
public class BookShelfService extends AbstractService {
    public void add(BookShelf entity) {
        //String username = SecurityUtil.getLoginUser();
        insert("bookShelfMapper.insert",entity);
    }

    public void modify(BookShelf entity) {
        update("bookShelfMapper.update",entity);
    }

    public void remove(Long id) {
        delete("bookShelfMapper.delete",id);
    }

    public void removes(Long[] ids) {
        delete("bookShelfMapper.deletes",ids);
    }

    public BookShelf get(Long id) {
        return selectOne("bookShelfMapper.select",id);
    }

    public List<BookShelf> getParentList(Long id) {
        return selectList("bookShelfMapper.selectParentList",id);
    }

    public int count(Map<String, Object> param) {
        return selectOne("bookShelfMapper.count",param);
    }

    public List<BookShelf> getList(Map<String, Object> param) {
        return selectList("bookShelfMapper.selectList",param);
    }

    public List<BookShelf> getPageResult(Map<String, Object> param) {
        return selectList("bookShelfMapper.selectPageResult",param);
    }

    public int checkCode(BookShelf entity){
        return selectOne("bookShelfMapper.countCode",entity);
    }

}

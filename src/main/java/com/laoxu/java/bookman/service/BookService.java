package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.framework.AbstractService;
import com.laoxu.java.bookman.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: 图书服务
 * @Author laoxu
 * @Date 2019/5/2 9:26
 **/
@Service
public class BookService extends AbstractService {
    public void add(Book entity) {
        //String username = SecurityUtil.getLoginUser();
        insert("bookMapper.insert",entity);
    }

    public void modify(Book entity) {
        update("bookMapper.update",entity);
    }

    public void remove(Long id) {
        delete("bookMapper.delete",id);
    }

    public void removes(Long[] ids) {
        delete("bookMapper.deletes",ids);
    }

    public Book get(Long id) {
        return selectOne("bookMapper.select",id);
    }

    public Book getByIsbn(String isbn) {
        return selectOne("bookMapper.selectByIsbn",isbn);
    }

    public List<Book> getParentList(Long id) {
        return selectList("bookMapper.selectParentList",id);
    }

    public int count(Map<String, Object> param) {
        return selectOne("bookMapper.count",param);
    }

    public List<Book> getList(Map<String, Object> param) {
        return selectList("bookMapper.selectList",param);
    }

    public List<Book> getPageResult(Map<String, Object> param) {
        return selectList("bookMapper.selectPageResult",param);
    }


    public int checkCode(Book entity){
        return selectOne("bookMapper.countCode",entity);
    }

}

package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.framework.AbstractService;
import com.laoxu.java.bookman.model.BookReader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: 读者服务
 * @Author laoxu
 * @Date 2019/5/2 9:26
 **/
@Service
public class BookReaderService extends AbstractService {
    public void add(BookReader entity) {
        //String username = SecurityUtil.getLoginUser();
        insert("bookReaderMapper.insert",entity);
    }

    public void modify(BookReader entity) {
        update("bookReaderMapper.update",entity);
    }

    public void remove(Long id) {
        delete("bookReaderMapper.delete",id);
    }

    public void removes(Long[] ids) {
        delete("bookReaderMapper.deletes",ids);
    }

    public BookReader get(Long id) {
        return selectOne("bookReaderMapper.select",id);
    }

    public List<BookReader> getParentList(Long id) {
        return selectList("bookReaderMapper.selectParentList",id);
    }

    public int count(Map<String, Object> param) {
        return selectOne("bookReaderMapper.count",param);
    }

    public List<BookReader> getList(Map<String, Object> param) {
        return selectList("bookReaderMapper.selectList",param);
    }

    public List<BookReader> getPageResult(Map<String, Object> param) {
        return selectList("bookReaderMapper.selectPageResult",param);
    }


    public int checkCode(BookReader entity){
        return selectOne("bookReaderMapper.countCode",entity);
    }

}

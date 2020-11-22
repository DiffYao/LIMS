package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.framework.AbstractService;
import com.laoxu.java.bookman.model.BookPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: 出版社服务
 * @Author laoxu
 * @Date 2019/5/2 9:26
 **/
@Service
public class BookPublisherService extends AbstractService {
    public void add(BookPublisher entity) {
        //String username = SecurityUtil.getLoginUser();
        insert("bookPublisherMapper.insert",entity);
    }

    public void modify(BookPublisher entity) {
        update("bookPublisherMapper.update",entity);
    }

    public void remove(Long id) {
        delete("bookPublisherMapper.delete",id);
    }

    public void removes(Long[] ids) {
        delete("bookPublisherMapper.deletes",ids);
    }

    public BookPublisher get(Long id) {
        return selectOne("bookPublisherMapper.select",id);
    }

    public List<BookPublisher> getParentList(Long id) {
        return selectList("bookPublisherMapper.selectParentList",id);
    }

    public int count(Map<String, Object> param) {
        return selectOne("bookPublisherMapper.count",param);
    }

    public List<BookPublisher> getList(Map<String, Object> param) {
        return selectList("bookPublisherMapper.selectList",param);
    }

    public List<BookPublisher> getPageResult(Map<String, Object> param) {
        return selectList("bookPublisherMapper.selectPageResult",param);
    }

    public int checkCode(BookPublisher entity){
        return selectOne("bookPublisherMapper.countCode",entity);
    }
}

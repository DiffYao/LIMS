package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.framework.AbstractService;
import com.laoxu.java.bookman.model.BookCategory;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: 图书分类service
 * @Author laoxu
 * @Date 2019/5/2 9:26
 **/
@Service
public class BookCategoryService extends AbstractService {
    public void add(BookCategory entity) {
        //String username = SecurityUtil.getLoginUser();
        insert("bookCategoryMapper.insert",entity);
    }

    public void modify(BookCategory entity) {
        update("bookCategoryMapper.update",entity);
    }

    public void remove(Long id) {
        delete("bookCategoryMapper.delete",id);
    }

    public void removes(Long[] ids) {
        delete("bookCategoryMapper.deletes",ids);
    }

    public BookCategory get(Long id) {
        return selectOne("bookCategoryMapper.select",id);
    }

    public List<BookCategory> getParentList(Long id) {
        return selectList("bookCategoryMapper.selectParentList",id);
    }

    public int count(Map<String, Object> param) {
        return selectOne("bookCategoryMapper.count",param);
    }

    public List<BookCategory> getList(Map<String, Object> param) {
        return selectList("bookCategoryMapper.selectList",param);
    }

    public List<BookCategory> getPageResult(Map<String, Object> param) {
        return selectList("bookCategoryMapper.selectPageResult",param);
    }


    public int checkCode(BookCategory entity){
        return selectOne("bookCategoryMapper.countCode",entity);
    }

}

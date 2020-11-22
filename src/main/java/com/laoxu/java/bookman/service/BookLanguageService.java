package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.framework.AbstractService;
import com.laoxu.java.bookman.model.BookLanguage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: 语种服务
 * @Author laoxu
 * @Date 2019/5/2 9:26
 **/
@Service
public class BookLanguageService extends AbstractService {
    public void add(BookLanguage entity) {
        //String username = SecurityUtil.getLoginUser();
        insert("bookLanguageMapper.insert",entity);
    }

    public void modify(BookLanguage entity) {
        update("bookLanguageMapper.update",entity);
    }

    public void remove(Long id) {
        delete("bookLanguageMapper.delete",id);
    }

    public void removes(Long[] ids) {
        delete("bookLanguageMapper.deletes",ids);
    }

    public BookLanguage get(Long id) {
        return selectOne("bookLanguageMapper.select",id);
    }

    public List<BookLanguage> getParentList(Long id) {
        return selectList("bookLanguageMapper.selectParentList",id);
    }

    public int count(Map<String, Object> param) {
        return selectOne("bookLanguageMapper.count",param);
    }

    public List<BookLanguage> getList(Map<String, Object> param) {
        return selectList("bookLanguageMapper.selectList",param);
    }

    public List<BookLanguage> getPageResult(Map<String, Object> param) {
        return selectList("bookLanguageMapper.selectPageResult",param);
    }
    public int checkCode(BookLanguage entity){
        return selectOne("bookLanguageMapper.countCode",entity);
    }
}

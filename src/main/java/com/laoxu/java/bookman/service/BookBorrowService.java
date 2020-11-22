package com.laoxu.java.bookman.service;

import com.laoxu.java.bookman.framework.AbstractService;
import com.laoxu.java.bookman.model.BookBorrow;
import com.laoxu.java.bookman.vo.BookBorrowVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: 借阅图书服务
 * @Author laoxu
 * @Date 2020/1/12
 **/
@Service
public class BookBorrowService extends AbstractService {
    public void add(BookBorrowVO entity) {
        //String username = SecurityUtil.getLoginUser();
        insert("bookBorrowMapper.insert",entity);
    }

    public void modify(BookBorrowVO entity) {
        update("bookBorrowMapper.update",entity);
    }

    public void remove(Long id) {
        delete("bookBorrowMapper.delete",id);
    }

    public void removes(Long[] ids) {
        delete("bookBorrowMapper.deletes",ids);
    }

    public void returnBook(Map<String, Object> param) {
        delete("bookBorrowMapper.return",param);
    }

    public BookBorrowVO get(Long id) {
        return selectOne("bookBorrowMapper.select",id);
    }

    public List<BookBorrow> getParentList(Long id) {
        return selectList("bookBorrowMapper.selectParentList",id);
    }

    public int count(Map<String, Object> param) {
        return selectOne("bookBorrowMapper.count",param);
    }

    public List<BookBorrow> getList(Map<String, Object> param) {
        return selectList("bookBorrowMapper.selectList",param);
    }

    public List<BookBorrowVO> getPageResult(Map<String, Object> param) {
        return selectList("bookBorrowMapper.selectPageResult",param);
    }


    public int checkBorrow(BookBorrowVO entity){
        return selectOne("bookBorrowMapper.countBorrow",entity);
    }

    public int getBorrowCount(String date){
        return selectOne("bookBorrowMapper.selectBorrowCount",date);
    }

    public int getReturnCount(String date){
        return selectOne("bookBorrowMapper.selectReturnCount",date);
    }
}

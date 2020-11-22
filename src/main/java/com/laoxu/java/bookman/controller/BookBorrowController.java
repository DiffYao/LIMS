package com.laoxu.java.bookman.controller;

import com.laoxu.java.bookman.common.DateUtil;
import com.laoxu.java.bookman.framework.Result;
import com.laoxu.java.bookman.framework.ResultBean;
import com.laoxu.java.bookman.framework.ResultUtil;
import com.laoxu.java.bookman.model.Book;
import com.laoxu.java.bookman.model.BookBorrow;
import com.laoxu.java.bookman.service.BookBorrowService;
import com.laoxu.java.bookman.service.BookReaderService;
import com.laoxu.java.bookman.service.BookService;
import com.laoxu.java.bookman.vo.BookBorrowVO;
import com.laoxu.java.bookman.vo.BorrowStatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 借阅图书控制器
 * @Author laoxu
 * @Date 2020/1/12 23:24
 **/
@RestController
@RequestMapping("/api/bookBorrow")
public class BookBorrowController {
    @Autowired
    BookBorrowService bookBorrowService;

    @Autowired
    BookReaderService bookReaderService;

    @Autowired
    BookService bookService;

    /**
     * 保存（新增/修改）
     *
     * @param entity
     * @return
     */
    @PostMapping("/save")
    public Result<String> modify(@RequestBody BookBorrowVO entity) {
        Long id = entity.getId();
        if(id!=null){
            bookBorrowService.modify(entity);
        }else{
            Map<String,Object> param = new HashMap<>();
            param.put("isbn",entity.getBookIsbn());
            param.put("code",entity.getReaderCode());
            //1.检查读者编号是否存在
            if(bookReaderService.count(param)==0){
                return ResultUtil.fail("读者不存在！");
            }
            //2.检查图书编号是否存在
            if(bookService.count(param)==0){
                return ResultUtil.fail("图书不存在！");
            }
            //3.检查该读者是否已经借过此书
            int count = bookBorrowService.checkBorrow(entity);
            if(count>0){
                return ResultUtil.fail("您已借过该图书！");
            }
            //4.检查图书剩余
            Book book = bookService.getByIsbn(entity.getBookIsbn());
            int leftNumber = book.getLeftNumber();
            if(leftNumber<1){
                return ResultUtil.fail("图书剩余数量为0！");
            }
            //5.扣减图书剩余
            book.setLeftNumber(leftNumber-1);
            bookService.modify(book);
            //6.保存借阅记录
            bookBorrowService.add(entity);
        }


        return ResultUtil.ok();
    }


    @PostMapping("/remove")
    public Result<String> remove(@RequestBody Long[] ids) {
        bookBorrowService.removes(ids);
        return ResultUtil.ok();
    }

    /**
     *  归还
     * @param ids
     * @return
     */
    @PostMapping("/return")
    @Transactional
    public Result<String> returnBook(@RequestBody Long[] ids) {
        // 1.增加图书库存
        Book entity = null;
        for (Long id: ids) {
            entity = bookService.getByIsbn(bookBorrowService.get(id).getBookIsbn());
            entity.setLeftNumber(entity.getLeftNumber()+1);
            bookService.modify(entity);
        }
        // 2.更新借阅状态
        Map<String,Object> param = new HashMap<>();
        param.put("ids", ids);
        param.put("borrowStatus",1);
        bookBorrowService.returnBook(param);

        return ResultUtil.ok();
    }

    @GetMapping("/get")
    public Result<BookBorrowVO> get(@RequestParam("id") Long id) {
        BookBorrowVO entity = bookBorrowService.get(id);

        return ResultUtil.ok(entity);
    }

    @GetMapping("/getPageResult")
    public ResultBean<List<BookBorrowVO>> getPageResult(
            @RequestParam(required = false) Integer[] borrowStatus,
            @RequestParam(required = false) String readerCode,
            @RequestParam(required = false) String isbn,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit) {

        Map<String, Object> param = new HashMap<>();
        // 统计记录数
        int totalRows = bookBorrowService.count(param);
        // 计算起始行号
        int offset = (page - 1) * limit;
        int rows = limit;

        param.put("offset", offset);
        param.put("rows", rows);
        param.put("borrowStatus",borrowStatus);
        param.put("readerCode",readerCode);
        param.put("isbn",isbn);

        // 获取当前页结果集
        List<BookBorrowVO> entities = bookBorrowService.getPageResult(param);

        ResultBean result = new ResultBean(0, "查询成功", totalRows, entities);

        return result;

    }

    @GetMapping("/getBorrowStat")
    public Result<Map<String,Object>> getBorrowStat(){
        Map<String,Object> map = new HashMap<>();
        List<String> days = DateUtil.getDaysBetwwen(6);

        map.put("columnName",days);
        BorrowStatVO borrowVO = new BorrowStatVO();
        BorrowStatVO returnVO = new BorrowStatVO();
        borrowVO.setName("借");
        returnVO.setName("还");
        borrowVO.setType("bar");
        returnVO.setType("bar");
        List<Integer> borrowData = new ArrayList<>();
        List<Integer> returnData = new ArrayList<>();
        for (String day:days) {
            borrowData.add(bookBorrowService.getBorrowCount(day));
            returnData.add(bookBorrowService.getReturnCount(day));
        }
        borrowVO.setData(borrowData);
        returnVO.setData(returnData);

        List<BorrowStatVO> list = new ArrayList<>();
        list.add(borrowVO);
        list.add(returnVO);

        map.put("columnValue",list);

        return ResultUtil.ok(map);

    }
}

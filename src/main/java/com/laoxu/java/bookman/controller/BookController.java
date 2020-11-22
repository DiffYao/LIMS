package com.laoxu.java.bookman.controller;

import com.laoxu.java.bookman.framework.Result;
import com.laoxu.java.bookman.framework.ResultBean;
import com.laoxu.java.bookman.framework.ResultUtil;
import com.laoxu.java.bookman.model.Book;
import com.laoxu.java.bookman.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 图书控制器
 * @Author laoxu
 * @Date 2019/5/2 10:16
 **/
@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookService bookService;

    /**
     * 保存（新增/修改）
     *
     * @param entity
     * @return
     */
    @PostMapping("/save")
    public Result<String> modify(@RequestBody Book entity) {
        String code = entity.getIsbn();
        int count = bookService.checkCode(entity);
        if(count>0){
            return ResultUtil.fail("ISBN已存在！");
        }
        if(entity.getId()!=null){
            bookService.modify(entity);
        }else{
            bookService.add(entity);
        }

        return ResultUtil.ok();
    }


    @PostMapping("/remove")
    public Result<String> remove(@RequestBody Long[] ids) {
        bookService.removes(ids);
        return ResultUtil.ok();
    }

    @GetMapping("/get")
    public Result<Book> get(@RequestParam("id") Long id) {
        Book entity = bookService.get(id);

        return ResultUtil.ok(entity);
    }

    @GetMapping("/list")
    public ResultBean<List<Book>> getPageResult(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) String author,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit) {

        Map<String, Object> param = new HashMap<>();

        // 计算起始行号
        int offset = (page - 1) * limit;
        int rows = limit;

        param.put("name",name);
        param.put("isbn",isbn);
        param.put("author",author);
        param.put("offset", offset);
        param.put("rows", rows);

        // 统计记录数
        int totalRows = bookService.count(param);

        // 获取当前页结果集
        List<Book> entities = bookService.getPageResult(param);

        ResultBean result = new ResultBean(0, "查询成功", totalRows, entities);

        return result;

    }
}

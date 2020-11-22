package com.laoxu.java.bookman.controller;

import com.laoxu.java.bookman.framework.Result;
import com.laoxu.java.bookman.framework.ResultBean;
import com.laoxu.java.bookman.framework.ResultUtil;
import com.laoxu.java.bookman.model.BookReader;
import com.laoxu.java.bookman.service.BookReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 读者控制器
 * @Author laoxu
 * @Date 2019/5/2 10:16
 **/
@RestController
@RequestMapping("/api/bookReader")
public class BookReaderController {
    @Autowired
    BookReaderService bookReaderService;

    /**
     * 保存（新增/修改）
     *
     * @param entity
     * @return
     */
    @PostMapping("/save")
    public Result<String> modify(@RequestBody BookReader entity) {
        int count = bookReaderService.checkCode(entity);
        if(count>0){
            return ResultUtil.fail("编码已存在！");
        }
        if(entity.getId()!=null){
            bookReaderService.modify(entity);
        }else{
            bookReaderService.add(entity);
        }

        return ResultUtil.ok();
    }


    @PostMapping("/remove")
    public Result<String> remove(@RequestBody Long[] ids) {
        bookReaderService.removes(ids);
        return ResultUtil.ok();
    }

    @GetMapping("/get")
    public Result<BookReader> get(@RequestParam("id") Long id) {
        BookReader entity = bookReaderService.get(id);

        return ResultUtil.ok(entity);
    }

    @GetMapping("/list")
    public ResultBean<List<BookReader>> list(){
        List<BookReader> entities = bookReaderService.getList(null);
        return new ResultBean(0, "查询成功", entities.size(), entities);
    }

    @GetMapping("/getPageResult")
    public ResultBean<List<BookReader>> getPageResult(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit) {

        Map<String, Object> param = new HashMap<>();
        // 统计记录数
        int totalRows = bookReaderService.count(param);
        // 计算起始行号
        int offset = (page - 1) * limit;
        int rows = limit;

        param.put("offset", offset);
        param.put("rows", rows);

        // 获取当前页结果集
        List<BookReader> entities = bookReaderService.getPageResult(param);

        ResultBean result = new ResultBean(0, "查询成功", totalRows, entities);

        return result;

    }
}

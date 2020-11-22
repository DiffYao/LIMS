package com.laoxu.java.bookman.controller;

import com.laoxu.java.bookman.framework.Result;
import com.laoxu.java.bookman.framework.ResultBean;
import com.laoxu.java.bookman.framework.ResultUtil;
import com.laoxu.java.bookman.model.BookLanguage;
import com.laoxu.java.bookman.service.BookLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 语种控制器
 * @Author laoxu
 * @Date 2019/5/2 10:16
 **/
@RestController
@RequestMapping("/api/bookLanguage")
public class BookLanguageController {
    @Autowired
    BookLanguageService bookLanguageService;

    /**
     * 保存（新增/修改）
     *
     * @param entity
     * @return
     */
    @PostMapping("/save")
    public Result<String> modify(@RequestBody BookLanguage entity) {
        String code = entity.getCode();
        int count = bookLanguageService.checkCode(entity);
        if(count>0){
            return ResultUtil.fail("编码已存在！");
        }

        if(entity.getId()!=null){
            bookLanguageService.modify(entity);
        }else{
            bookLanguageService.add(entity);
        }

        return ResultUtil.ok();
    }


    @PostMapping("/remove")
    public Result<String> remove(@RequestBody Long[] ids) {
        bookLanguageService.removes(ids);
        return ResultUtil.ok();
    }

    @GetMapping("/get")
    public Result<BookLanguage> get(@RequestParam("id") Long id) {
        BookLanguage entity = bookLanguageService.get(id);

        return ResultUtil.ok(entity);
    }

    @GetMapping("/list")
    public ResultBean<List<BookLanguage>> list(){
        List<BookLanguage> entities = bookLanguageService.getList(null);
        return new ResultBean(0, "查询成功", entities.size(), entities);
    }

    @GetMapping("/getPageResult")
    public ResultBean<List<BookLanguage>> getPageResult(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit) {

        Map<String, Object> param = new HashMap<>();
        // 统计记录数
        int totalRows = bookLanguageService.count(param);
        // 计算起始行号
        int offset = (page - 1) * limit;
        int rows = limit;

        param.put("offset", offset);
        param.put("rows", rows);

        // 获取当前页结果集
        List<BookLanguage> entities = bookLanguageService.getPageResult(param);

        ResultBean result = new ResultBean(0, "查询成功", totalRows, entities);

        return result;

    }
}

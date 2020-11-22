package com.laoxu.java.bookman.controller;

import com.laoxu.java.bookman.model.Book;
import com.laoxu.java.bookman.model.BookBorrow;
import com.laoxu.java.bookman.service.BookBorrowService;
import com.laoxu.java.bookman.service.BookService;
import com.laoxu.java.bookman.vo.BookBorrowVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 跳转控制器
 * @Author laoxu
 * @Date 2020/1/9 22:40
 **/
@Controller
public class IndexController {
    @Autowired
    BookService bookService;

    @Autowired
    BookBorrowService bookBorrowService;

    /**
     *  修改图书
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/bookEdit/{id}")
    public String bookEdit(@PathVariable Long id, Model model){
        Book book = bookService.get(id);
        model.addAttribute("book",book);

        return "bookEdit";
    }

    /**
     *  图书详情
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/bookDetail/{id}")
    public String book(@PathVariable Long id, Model model){
        Book book = bookService.get(id);
        model.addAttribute("book",book);

        return "bookDetail";
    }

    /**
     *  修改借书
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/bookBorrowEdit/{id}")
    public String bookBorrowEdit(@PathVariable Long id, Model model){
        BookBorrowVO bookBorrow = bookBorrowService.get(id);
        model.addAttribute("bookBorrow",bookBorrow);

        return "bookBorrowEdit";
    }

    /**
     *  续借借书
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/bookReBorrowEdit/{id}")
    public String bookReBorrowEdit(@PathVariable Long id, Model model){
        BookBorrowVO bookBorrow = bookBorrowService.get(id);
        model.addAttribute("bookBorrow",bookBorrow);

        return "bookReBorrowEdit";
    }
}

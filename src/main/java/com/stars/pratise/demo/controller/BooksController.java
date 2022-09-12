package com.stars.pratise.demo.controller;

import com.stars.pratise.demo.common.ResponseData;
import com.stars.pratise.demo.domain.Book;
import com.stars.pratise.demo.service.BookService;
import com.stars.pratise.demo.util.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    //
    @GetMapping("／books")
    public <T> ResponseData getAllBook() {
//        Book book = new Book();
////        book.setId(2);
////        book.setAuthor("dogs");
////        book.setName("离散数学及其应用");
////        book.setPrice(Float.valueOf("43.21"));
////        book.setCreateTime(new Date());
////        book.setDescription("this is a demo data");
////        this.bookService.save(book);
//        System.out.println(bookService.selectAll());
        return ResponseDataUtil.success(this.bookService.selectAll());

    }
}

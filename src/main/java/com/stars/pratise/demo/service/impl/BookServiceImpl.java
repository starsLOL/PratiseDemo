package com.stars.pratise.demo.service.impl;

import com.stars.pratise.demo.domain.Book;
import com.stars.pratise.demo.service.BookService;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl extends BaseService<Book> implements BookService {

}

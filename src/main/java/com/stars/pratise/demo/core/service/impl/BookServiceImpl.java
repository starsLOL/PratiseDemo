package com.stars.pratise.demo.core.service.impl;

import com.stars.pratise.demo.core.service.BookService;
import com.stars.pratise.demo.domain.Book;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl extends BaseService<Book> implements BookService {

}

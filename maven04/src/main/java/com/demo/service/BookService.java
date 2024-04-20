package com.demo.service;

import com.demo.dao.BookDao;
import com.demo.pojo.Book;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();
    public List<Book> findAll(){
        return bookDao.findAll();
    }

    public void insertBook(Book book){

    }
}

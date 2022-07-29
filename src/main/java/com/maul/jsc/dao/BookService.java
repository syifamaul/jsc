package com.maul.jsc.dao;

import java.util.List;

import com.maul.jsc.models.Book;

  
public interface BookService {
	List < Book > getAll();
    void saveBook(Book book);
    Book getBookById(long id);
    void deleteBookById(long id);
}

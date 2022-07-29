package com.maul.jsc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maul.jsc.models.Book;
@Service
public class BookImpl implements BookService {

	@Autowired
    private BookRepository bookRepository;
	
	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public void saveBook(Book book) {
		this.bookRepository.save(book);

	}

	@Override
	public Book getBookById(long id) {
		return this.bookRepository.getById(id);
	}

	@Override
	public void deleteBookById(long id) {
		this.bookRepository.deleteById(id);
	}

}

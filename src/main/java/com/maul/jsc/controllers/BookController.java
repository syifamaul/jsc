package com.maul.jsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maul.jsc.dao.BookService;
import com.maul.jsc.dao.PublisherService;
import com.maul.jsc.models.Book;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
    private BookService bookService;
	
	@Autowired
    private PublisherService publisherService;
	
    @GetMapping("")
    public String viewHomePage(Model model) {
        model.addAttribute("listbooks", bookService.getAll());
        return "books/index";
    }
    
    @GetMapping("/new")
    public String showNewBookForm(Model model) {
        Book Book = new Book();
        model.addAttribute("Book", Book);
        model.addAttribute("listpublisher", publisherService.getAll());
        return "books/new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("Book") Book Book) {
        bookService.saveBook(Book);
        return "redirect:/book/";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Book Book = bookService.getBookById(id);
        model.addAttribute("listpublisher", publisherService.getAll());
        model.addAttribute("Book", Book);
        return "books/update_Book";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") long id) {
        this.bookService.deleteBookById(id);
        return "redirect:/book/";
    }

}

package com.codingdojo.allbooks.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.allbooks.models.Book;
import com.codingdojo.allbooks.services.BookService;

// ... imports removed for brevity

@Controller

public class BookController {
	
	private BookService bookService;
    
    public BookController(BookService bookService) {
    	
        this.bookService = bookService;
    }
    
    // Shows all books
    
    @RequestMapping("/books")
    
    public String index(Model model) {
    	
        List<Book> books = bookService.allBooks();
        
        model.addAttribute("books", books);
        
        return "index.jsp";
    }
    
    // Shows One Book
    
    @RequestMapping("/showbook/{id}")
    
    public String findBook(@PathVariable("id") Long id, Model model) {
    	
    	model.addAttribute("books", bookService.findBook(id));
    	
    	return "show.jsp";
    	
    }
	
	
	
    // other methods removed for brevity
    
    @RequestMapping("/books/new")
    
    public String newBook(@ModelAttribute("book") Book book) {
    	
        return "new.jsp";
        
    }
    
    // Shows Errors Or Creates New Book
    
    @RequestMapping(value="/books", method=RequestMethod.POST)
    
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	
        if (result.hasErrors()) {
        	
            return "new.jsp";
            
        } 
        
        else {
        	
            BookService bookService = new BookService(null);
            
			bookService.createBook(book);
           
            return "redirect:/books";
            
        }
    }
}

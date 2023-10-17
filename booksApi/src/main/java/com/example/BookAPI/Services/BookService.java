package com.example.BookAPI.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.BookAPI.Model.Book;
import com.example.BookAPI.Repository.BookRepository;


@Service
public class BookService {
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // UPDATE
    public Book updateBook(Book b) {
		return bookRepository.save(b);
	}
    // DELETE
 	public void deleteBook(Long id) {
 		bookRepository.deleteById(id);
 	}
}

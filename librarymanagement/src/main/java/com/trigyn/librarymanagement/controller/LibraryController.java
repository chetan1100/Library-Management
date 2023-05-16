package com.trigyn.librarymanagement.controller;

import com.trigyn.librarymanagement.entity.Book;
import com.trigyn.librarymanagement.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return libraryService.getBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return libraryService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        libraryService.deleteBook(id);
    }
}

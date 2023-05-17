package com.trigyn.librarymanagement.controller;

import com.trigyn.librarymanagement.model.BookVO;
import com.trigyn.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/getbook")
    List<BookVO> getBook(@RequestParam(required = false) String name) {
        if (name != null)
            return bookService.findBookByName(name);
        else
            return bookService.getAll();
    }

    @PostMapping("/savebook")
    Boolean createBook(@RequestBody BookVO bookVO){
        return bookService.createbook(bookVO);
    }

    @GetMapping("/getbookbyname")
    List<BookVO> getBookByName(@RequestParam (required = false) String name) {
        if (name != null)
            return bookService.getBookByName(name);
        else
            return bookService.getAll();
    }
    @GetMapping("/getbookbynamenative")
    List<BookVO> getBookByNameNative(@RequestParam (required = false) String name) {
        if (name != null)
            return bookService.getBookByNameNative(name);
        else
            return bookService.getAll();
    }

    @GetMapping("/getbookbydeptid")
    List<BookVO> getBookByDeptId(@RequestParam (required = false) Long id) {
        if (id != null)
            return bookService.getBookByDept(id);
        else
            return bookService.getAll();
    }

}

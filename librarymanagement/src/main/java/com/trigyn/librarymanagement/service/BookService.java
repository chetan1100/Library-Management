package com.trigyn.librarymanagement.service;

import com.trigyn.librarymanagement.entity.Book;
import com.trigyn.librarymanagement.entity.Department;
import com.trigyn.librarymanagement.model.BookVO;
import com.trigyn.librarymanagement.repository.BookRepository;
import com.trigyn.librarymanagement.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    DeptRepository deptRepository;
    @Autowired
    BookRepository bookRepository;

    private Book convertVO(BookVO bookVO) {
        Book book = new Book();
        book.setId(bookVO.getId());
        book.setAuthor(bookVO.getAuthor());
        book.setName(bookVO.getName());
        Department dept = null;
        if(bookVO.getDeptID()!= null){
            dept = deptRepository.findById(bookVO.getDeptID()).get();
            book.setDepartment(dept);
        }
        return book;
    }
    public Boolean createbook(BookVO bookVO) {
        Book book = convertVO(bookVO);
        try {
            bookRepository.save(book);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    private BookVO convertEntity(Book book) {
        BookVO bookVO = new BookVO();
        bookVO.setId(book.getId());
        bookVO.setAuthor(book.getAuthor());
        bookVO.setName(book.getName());
        bookVO.setDeptID(book.getDepartment().getId());
        return bookVO;
    }

    public List<BookVO> getAll(){
        List<BookVO> bookVOList = new ArrayList<>();
        for(Book book : bookRepository.findAll()){
            bookVOList.add(convertEntity(book));
        }
        return bookVOList;
    }
    public List<BookVO> findBookByName(String name){
        List<BookVO> bookVOList = new ArrayList<>();
        for(Book book : bookRepository.findBookByName(name)){
            bookVOList.add(convertEntity(book));
        }
        return bookVOList;
    }

    public List<BookVO> getBookByName(String name){
        List<BookVO> bookVOList = new ArrayList<>();
        for(Book book : bookRepository.findBookBySname("%" + name + "%")){
            bookVOList.add(convertEntity(book));
        }
        return bookVOList;
    }
    public List<BookVO> getBookByNameNative(String name){
        List<BookVO> bookVOList = new ArrayList<>();
        for(Book book : bookRepository.findBookBySnameNative("%" + name + "%")){
            bookVOList.add(convertEntity(book));
        }
        return bookVOList;
    }
    public List<BookVO> getBookByDept(Long id){
        List<BookVO> bookVOList = new ArrayList<>();
        for(Book book : bookRepository.findBookByDept(id)){
            bookVOList.add(convertEntity(book));
        }
        return bookVOList;
    }
}


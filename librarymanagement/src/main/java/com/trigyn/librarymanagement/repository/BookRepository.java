package com.trigyn.librarymanagement.repository;

import com.trigyn.librarymanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findBookByName(String name);
    @Query("Select s from Book s where s.name like :sName")
    List<Book> findBookBySname(String sName);
    @Query(value = "Select * from Book where book_name like :sName", nativeQuery = true)
    List<Book> findBookBySnameNative(String sName);
    @Query("Select s from Book s where s.department.id = :id")
    List<Book> findBookByDept(Long id);
}

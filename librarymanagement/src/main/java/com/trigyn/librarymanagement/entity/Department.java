package com.trigyn.librarymanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id
    Long id;
    String deptName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Deptartment{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", books=" + books +
                '}';
    }
}

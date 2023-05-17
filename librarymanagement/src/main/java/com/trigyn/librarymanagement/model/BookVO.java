package com.trigyn.librarymanagement.model;

import com.trigyn.librarymanagement.entity.Department;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class BookVO {
    @Id
    private Long id;
    Long deptID;
    private String name;
    private String author;

    @Override
    public String toString() {
        return "BookVO{" +
                "id=" + id +
                ", deptID=" + deptID +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeptID() {
        return deptID;
    }

    public void setDeptID(Long deptID) {
        this.deptID = deptID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}

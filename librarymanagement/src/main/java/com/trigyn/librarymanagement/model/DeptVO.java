package com.trigyn.librarymanagement.model;

import javax.persistence.*;
import java.util.List;

public class DeptVO {
    @Id
    Long id;
    String deptName;
    @OneToMany(mappedBy = "deptVO", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<BookVO> bookVOS;

    @Override
    public String toString() {
        return "DeptVO{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", bookVOS=" + bookVOS +
                '}';
    }

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

    public List<BookVO> getBookVOS() {
        return bookVOS;
    }

    public void setBookVOS(List<BookVO> bookVOS) {
        this.bookVOS = bookVOS;
    }

}

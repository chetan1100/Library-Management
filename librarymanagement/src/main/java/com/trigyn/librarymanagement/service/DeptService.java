package com.trigyn.librarymanagement.service;

import com.trigyn.librarymanagement.entity.Book;
import com.trigyn.librarymanagement.entity.Department;
import com.trigyn.librarymanagement.model.BookVO;
import com.trigyn.librarymanagement.model.DeptVO;
import com.trigyn.librarymanagement.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptService {

    @Autowired
    DeptRepository departmentRepository;

    private Department convertVO(DeptVO departmentVO) {
        Department dept = new Department();
        dept.setId(departmentVO.getId());
        dept.setDeptName(departmentVO.getDeptName());

        return dept;
    }
    public Boolean createDept(DeptVO departmentVO) {

        Department dept = convertVO(departmentVO);
        try {
            departmentRepository.save(dept);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    private List<BookVO> convertBooks(List<Book> books){

        List<BookVO> bookVOS = new ArrayList<>();

        for(Book book : books){
            BookVO bookVO = new BookVO();
            bookVO.setId(book.getId());
            bookVO.setAuthor(book.getAuthor());
            bookVO.setName(book.getName());
            bookVO.setDeptID(book.getDepartment().getId());
            bookVOS.add(bookVO);
        }
        return bookVOS;
    }
    private DeptVO convertEntity(Department dept) {
        DeptVO departmentVO = new DeptVO();
        departmentVO.setId(dept.getId());
        departmentVO.setDeptName(dept.getDeptName());
        departmentVO.setBookVOS(convertBooks(dept.getBooks()));
        return departmentVO;
    }

    public List<DeptVO> getAll(){
        List<DeptVO> departmentList = new ArrayList<>();
        for(Department dept : departmentRepository.findAll()){
            departmentList.add(convertEntity(dept));
        }
        return departmentList;
    }


}

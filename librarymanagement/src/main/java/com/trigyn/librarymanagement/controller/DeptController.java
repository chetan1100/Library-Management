package com.trigyn.librarymanagement.controller;

import com.trigyn.librarymanagement.model.DeptVO;
import com.trigyn.librarymanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;
    @GetMapping("/department")
    List<DeptVO> getBook(){
        return deptService.getAll();
    }

    @PostMapping("/department")
    Boolean createBook(@RequestBody DeptVO deptVO){
        return deptService.createDept(deptVO);
    }
}

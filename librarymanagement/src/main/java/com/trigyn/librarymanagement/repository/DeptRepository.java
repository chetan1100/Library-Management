package com.trigyn.librarymanagement.repository;

import com.trigyn.librarymanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Department,Long> {
}

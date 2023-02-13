package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.entity.Employee;

//indicate that the class provides the mechanism for storage, retrieval, update, delete and search operation on objects. 
@Repository
public interface EmpRepo  extends JpaRepository<Employee, Integer>{

}
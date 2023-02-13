package com.prog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prog.entity.Employee;
import com.prog.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired(required=false)
	private EmpRepo repo;   //here autowired EmpRepo and object of EmpRepo is repo

	
	
//**********FOR ADD DATA***********//
	public void addEmp(Employee e) {  // here pass object of Employee in parameter//
		repo.save(e);             // employee object e will be dsave in repository(database)
	}

	
	
	
	public List<Employee> getAllEmp() {  // when call this class's method then will get all data from database//
		return repo.findAll();
	}

	
	
	
	public Employee getEMpById(int id) {
		Optional<Employee> e = repo.findById(id);  // to get particular user data//
		if (e.isPresent()) {    // if value is present 
			return e.get();     // then return all data
		}
		return null;             // or return null
	}

	
//***********FOR DELETE DATA*************// 
	public void deleteEMp(int id) {   // this method will delete data of particular id  // 
		repo.deleteById(id);    // delete method of repository //
	}

	
	
	
	
	// pageable is a interface which provide getPageNUmber() method to get number of the current page, 
	//getPageSize() method to get page size, getSort() for sorting parameters
	public Page<Employee> getEMpByPaginate(int currentPage, int size) {
		Pageable p = PageRequest.of(currentPage, size);     //The most common way to create a Pageable instance is 
															//to use the PageRequest implementation
		return repo.findAll(p);
	}

}
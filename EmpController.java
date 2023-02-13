package com.prog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.prog.entity.Employee;
import com.prog.service.EmpService;


// This is controller class
@Controller
public class EmpController {

	@Autowired        //property based autowiring 
	private EmpService service;

	@GetMapping("/")
	public String Fp()
	{
		return "index";
	}
	
	@RequestMapping("/signup")
	public String signup()
	{
		return "signup";
	}
	

	
	@GetMapping("/home")
	public String home(Model m) {
		return findPaginated(0, m);
	}

	@GetMapping("/home2")
	public String userview(Model m)
	{
		return userfindPaginated(0,m);
	}
	
	
//	@RequestMapping("/home")
//	public String home()
//	{
//		return "FirstP";
//	}
	
	
	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}
	
	
	
	

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Emplyoee Added Sucessfully..");
		return "redirect:/home";
	}

	
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = service.getEMpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}

	
	
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e); // so,data will be updated//
		session.setAttribute("msg", "Emp Data Update Sucessfully..");
		return "redirect:/home"; // then goto home page//
	}

	
	
	
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {

		service.deleteEMp(id);  //here call the deleteEmp method from service class //
		session.setAttribute("msg", "Emp Data Delete Sucessfully..");
		return "redirect:/home";
	}
	
	
	
	

	@GetMapping("/page/{pageno}")
	public String findPaginated(@PathVariable int pageno, Model m) {

		Page<Employee> emplist = service.getEMpByPaginate(pageno, 10);  // getEMpBYPaginate method is calling from class EmpService//
		m.addAttribute("emp", emplist);
		m.addAttribute("currentPage", pageno);
		m.addAttribute("totalPages", emplist.getTotalPages());
		m.addAttribute("totalItem", emplist.getTotalElements());
		return "FirstP";
	}
	
	

	@GetMapping("/page/{pageno1}")
	public String userfindPaginated(@PathVariable int pageno1, Model m) {

		Page<Employee> emplist = service.getEMpByPaginate(pageno1, 10);  // getEMpBYPaginate method is calling from class EmpService//
		m.addAttribute("emp", emplist);
		m.addAttribute("currentPage", pageno1);
		m.addAttribute("totalPages", emplist.getTotalPages());
		m.addAttribute("totalItem", emplist.getTotalElements());
		return "userview";
	}

}
package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.interfac.customAnnotation;
import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;
import com.javainuse.service.TestAspect;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	TestAspect testAspect;

	@RequestMapping(value = "/add/employee", method = RequestMethod.GET)
	public Employee addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

		return employeeService.createEmployee(name, empId);

	}

	@RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
	public String removeEmployee(@RequestParam("empId") String empId) {

		employeeService.deleteEmployee(empId);

		return "Employee removed";
	}

	@RequestMapping(value = "/testAspect", method = RequestMethod.GET)
	@customAnnotation
	public String testAspect() {

		testAspect.sayBye();
		testAspect.sayHi("sdfdsf");

		return "said";

	}

}
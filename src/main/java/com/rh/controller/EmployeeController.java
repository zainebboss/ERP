package com.rh.controller;

import java.util.List;

import com.rh.entity.Employee;
import com.rh.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    
    
@GetMapping("/all")
	
	@ResponseBody
	public List<Employee>getEmployees(){
		List<Employee> ListEmployees =employeeService.getAllEmployees();
		return ListEmployees;
		
	}
    

@PostMapping("/add")

@ResponseBody

public Employee addEmployee(@RequestBody Employee e)

{

	Employee employee = employeeService.addEmployee(e);

return employee;

}

@DeleteMapping("/remove/{employee-id}")

@ResponseBody

public void removeEmployee(@PathVariable("employee-id") Long id) {

	employeeService.deleteEmployeeById(id);

}
@PutMapping("/modify")

@ResponseBody

public Employee modifyEmployee(@RequestBody Employee e) {

return employeeService.updateEmployee(e);

}
@GetMapping("/retrieve/{employee-id}")

@ResponseBody

public Employee retrieveEmployee(@PathVariable("employee-id") Long id) {

return employeeService.getEmployeeById(id);

}


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;

        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployees", listEmployees);
        return "index";
    }
}

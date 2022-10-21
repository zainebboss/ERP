package com.rh.controller;

import com.rh.entity.Employee;
import com.rh.entity.Vacation;
import com.rh.service.VacationService;
import com.rh.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacations")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Vacation>getVacation(){
		List<Vacation> ListVacation =vacationService.getAllVacations();
		return ListVacation;
   
    }

    // @GetMapping("/new")
    // public String showNewEmployeeForm(Model model) {
    // model.addAttribute("employee", new Employee());
    // return "employees/new";
    // }

    @PostMapping("/add/{employee_id}")
    public String saveVacation(@ModelAttribute("vacation") Vacation vacation,
            @PathVariable(value = "employee_id") long id) {
        Employee employee = employeeService.getEmployeeById(id);

        vacationService.saveVacation(vacation, employee);
        return "" + employee.getId();
    }
    
    @DeleteMapping("/remove/{vacation-id}")

    @ResponseBody

    public void removeVacation(@PathVariable("vacation-id") Long id) {

    	vacationService.deleteVacationById(id);

    }
    @PutMapping("/modify")

    @ResponseBody

    public Vacation modifyVacation(@RequestBody Vacation v) {

    return vacationService.updateVacation(v);

    }
    @GetMapping("/retrieve/{vacation-id}")

    @ResponseBody

    public Vacation retrieveVacation(@PathVariable("vacation-id") Long id) {

    return vacationService.getVacationById(id);

    }
    

    // @GetMapping("/details/{id}")
    // public String details(@PathVariable(value = "id") long id, Model model) {
    // Employee employee = vacationService.getEmployeeById(id);

    // model.addAttribute("employee", employee);
    // return "employees/details";
    // }

    // @GetMapping("/edit/{id}")
    // public String showFormForUpdate(@PathVariable(value = "id") long id, Model
    // model) {
    // Employee employee = vacationService.getEmployeeById(id);

    // model.addAttribute("employee", employee);
    // return "employees/edit";
    // }

    // @GetMapping("/delete/{id}")
    // public String deleteEmployee(@PathVariable(value = "id") long id) {

    // this.vacationService.deleteEmployeeById(id);
    // return "redirect:/employees/all";
    // }
}

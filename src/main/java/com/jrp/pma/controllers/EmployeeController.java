package com.jrp.pma.controllers;


import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired//give responsibility to spring to inject an auto created instance without our input
    EmployeeRepository empRepo;


    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee anEmployee = new Employee();

        model.addAttribute("employee", anEmployee);

        return "new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model){
        //this should handle saving to database...
        empRepo.save(employee);

        //use a redirect whenever save to a db to prevent duplicates!!!
        return "redirect:/employees/new";
    }

}

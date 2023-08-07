package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.DemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class DemoController {

    private DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @GetMapping(value = "/test")
    public String getMessage(){
        return "testing...";
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){

        return new ResponseEntity<>(service.createUser(employeeDto) , HttpStatus.CREATED);

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")long id){
        return new ResponseEntity<>(service.getEmployeeById(id),HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>>getAllEmployee(){

        return new ResponseEntity<>(service.getAllEmployee(),HttpStatus.OK);
    }
}

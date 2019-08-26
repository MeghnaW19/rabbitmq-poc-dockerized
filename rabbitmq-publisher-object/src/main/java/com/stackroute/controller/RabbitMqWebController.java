package com.stackroute.controller;

import com.stackroute.domain.Employee;
import com.stackroute.service.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
public class RabbitMqWebController {

    @Autowired
    RabbitMqSender rabbitMqSender;

    @GetMapping(value = "/employee")
    public String producer(@RequestParam("employeeName") String employeeName, @RequestParam("employeeId") String employeeId) {

        Employee emp=new Employee();
        emp.setEmployeeId(employeeId);
        emp.setEmployeeName(employeeName);
        rabbitMqSender.send(emp);
        return "Message sent to the RabbitMQ EmployeeInUse Successfully";
    }

}
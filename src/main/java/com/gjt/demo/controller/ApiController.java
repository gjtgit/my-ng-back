package com.gjt.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gjt.demo.model.Task;
import com.gjt.demo.model.User;
import com.gjt.demo.repository.TaskRepository;
import com.gjt.demo.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @Autowired
    UserRepository userRepo;
    
    @Autowired
    TaskRepository repo;

    @PostMapping(value="/insertUser")
    public Object getData(Principal principal) {
        User u = new User(principal.getName());
        userRepo.save(u);
        return u;
    }
    
    @PostMapping(value="/getUsername")
    public Object getUserNameOfToken(Principal principal) {
        return principal.getName();
    }
    
    @PostMapping(value="/insertTask",produces="applicaiton/json")
    public Object insertTask(Principal principal,@RequestParam("task") String task) {
        this.repo.save(new Task(task,principal.getName()));
        return "{\"message\":\"Success\"}";
    }
    
    @PostMapping(value="/getTasks")
    public List<Task> getTasks(Principal principal){
        return this.repo.getTasksByHolderName(principal.getName());
    }
    
}

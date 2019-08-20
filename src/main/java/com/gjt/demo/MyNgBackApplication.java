package com.gjt.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gjt.demo.model.Task;
import com.gjt.demo.repository.TaskRepository;

@SpringBootApplication
public class MyNgBackApplication implements CommandLineRunner{

    private Logger logger = LoggerFactory.getLogger(MyNgBackApplication.class);

    @Autowired
    TaskRepository repo;
    
	public static void main(String[] args) {
		SpringApplication.run(MyNgBackApplication.class, args);
	}
	
    @Override
    public void run(String... args) throws Exception {
//        Task t = new Task();
//        t.setTask("task1");
//        repo.save(t);
        repo.findAll();
     }
}

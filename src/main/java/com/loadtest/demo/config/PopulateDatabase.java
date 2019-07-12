/**
 * The Spring Boot app triggers the run method on successful start up and 
 * the code basically initializes the in-memory h2 databsae with 20K records. 
 * 
 * @author Rafiullah Hamedy
 */

package com.loadtest.demo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.loadtest.demo.dao.StudentDAO;
import com.loadtest.demo.model.Student;

@Component
public class PopulateDatabase implements ApplicationRunner {
	Logger logger = LoggerFactory.getLogger(PopulateDatabase.class);
	
	@Autowired
	private StudentDAO studentRepo; 
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.debug("Populating the database with 20K Dummy Records ... In Progress");
		List<Student> students = new ArrayList<>(); 
		
		IntStream.range(1,20000).forEach(id -> {
			Student student = new Student(); 
			student.setFirstName("f" + id);
			student.setLastName("l" + id);
			
			int randomClass = ThreadLocalRandom.current().nextInt(1, 12 + 1);
			
			student.setKlass(randomClass);
			
			students.add(student);
		});
		
		studentRepo.saveAll(students);
		
		logger.debug("Database filled up!");
	}
}

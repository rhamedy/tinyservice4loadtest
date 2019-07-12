/**
 * A Sample Controller that exposes a bunch of endpoints that allow operations 
 * such as CREATE, READ, DELETE and LIST users. 
 * 
 * @author Rafiullah Hamedy
 */

package com.loadtest.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.loadtest.demo.dao.StudentDAO;
import com.loadtest.demo.dto.inbound.StudentInDTO;
import com.loadtest.demo.dto.outbound.StudentOutDTO;
import com.loadtest.demo.model.Student;

@Controller
public class StudentController {
	@Autowired
	private StudentDAO studentRepo; 
	
	@GetMapping("/students/list")
	@ResponseBody
	public List<StudentOutDTO> list() {
		Iterable<Student> studentsIterable = studentRepo.findAll(); 
		List<StudentOutDTO> outDTOs = new ArrayList<>(); 
		studentsIterable.forEach(entry -> outDTOs.add(new StudentOutDTO(entry)));
		return outDTOs; 
	}
	
	@GetMapping("/students/{sid}")
	@ResponseBody
	public StudentOutDTO getById(@PathVariable("sid") Long id) {
		Optional<Student> student = studentRepo.findById(id); 
		
		nullCheck(student, id);
		
		return new StudentOutDTO(student.get());
	}
	
	@PostMapping("/students")
	@ResponseBody
	public StudentOutDTO save(@RequestBody StudentInDTO dto) {
		Student student = dto.toEntity(); 
		
		studentRepo.save(student);
		
		return new StudentOutDTO(student); 
	}
	
	@DeleteMapping("/students/{sid}")
	public ResponseEntity<?> delete(@PathVariable("sid") Long id) {
		Optional<Student> existingStudent = studentRepo.findById(id); 
		
		nullCheck(existingStudent, id);
		
		studentRepo.delete(existingStudent.get());
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void nullCheck(Optional<Student> student, Long id) {
		if(!student.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					"Studnet with id " + id + " is not found.", null);
		}
	}
}

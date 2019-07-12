/**
 * Incoming Student Data Request.
 * 
 * @author Rafiullah Hamedy
 */

package com.loadtest.demo.dto.inbound;

import com.loadtest.demo.model.Student;

public class StudentInDTO {
	private String firstName; 
	private String lastName; 
	private Integer klass; 

	
	public StudentInDTO() {
	}
	
	public Student toEntity() {
		Student student = new Student(); 
		
		student.setFirstName(firstName); 
		student.setLastName(lastName);
		student.setKlass(klass);
		
		return student;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getKlass() {
		return klass;
	}

	public void setKlass(Integer klass) {
		this.klass = klass;
	}
}

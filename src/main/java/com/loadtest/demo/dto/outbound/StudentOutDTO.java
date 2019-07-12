/**
 * Outgoing Student Record.
 * 
 * @author Rafiullah Hamedy
 */

package com.loadtest.demo.dto.outbound;

import com.loadtest.demo.model.Student;

public class StudentOutDTO {
	private Long id; 
	private String firstName; 
	private String lastName; 
	private Integer klass; 
	
	public StudentOutDTO(Long id, String firstName, String lastName, Integer klass) {
		this.id = id; 
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.klass = klass; 
	}
	
	public StudentOutDTO(Student entity) {
		this.id = entity.getId();
		this.firstName = entity.getFirstName(); 
		this.lastName = entity.getLastName(); 
		this.klass = entity.getKlass(); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

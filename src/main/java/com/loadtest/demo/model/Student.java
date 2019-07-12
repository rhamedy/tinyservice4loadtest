package com.loadtest.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id; 
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName; 
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	@Column(name = "CLASS", nullable = false)
	private Integer klass;

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

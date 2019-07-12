package com.loadtest.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loadtest.demo.model.Student;

@Repository
public interface StudentDAO extends CrudRepository<Student, Long>{
	List<Student> findByFirstNameLike(String firstName); 
}

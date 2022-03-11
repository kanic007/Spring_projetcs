package com.example.demo.controller;

import java.net.URI;
import java.security.Principal;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.hibernate.query.criteria.internal.ValueHandlerFactory.DoubleValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path="/api/v1")
@Slf4j
public class StduentController {

	@Autowired
	@Qualifier("ram")
	private Student student;
	@Autowired
	@Qualifier("kanic")
	private Student anotherStudent;
	
	@Autowired
	private StudentService service;
	
//	@GetMapping(path="/students")
//	public Student getStudent() {
//		return student;
//	}
	
	
	@GetMapping(path="/students")
	//@RolesAllowed(value={"ROLE_ADMIN","ROLE_GUEST"})
	public List<Student> findAll(Principal pricipal){
		System.out.println("Current User:="+ pricipal );
		
		log.info("======Info Message");
		log.trace("======Trace Message");
		return this.service.findAll();
	}
	
	@GetMapping(path="/students/{id}")
	@Operation(description = "will Get the Details of student by roll Number")
	@Parameter(description = "should be the roll Number in three digitd",example ="100,200 upto 999")
	
	public Student getStudentById(@PathVariable("id") int rollNumber){
		
		 
		
//		if (id<100) {
//			return student;
//		} else {
//           return anotherStudent;
//		}
		
		return this.service.findById(rollNumber).orElseThrow(() -> new IdNotFoundException("Element with"+ rollNumber));
	}
//	
//	@GetMapping(path="/students/{branch}/{id}")
//	public Student getStudentById(@PathVariable("id") int id,@PathVariable("branch") String branch ){
//		
//		System.out.println("Branch : ========" +branch);
//		System.out.println("Id : ========" +id);
//		if (id<100) {
//			return student;
//		} else {
//           return anotherStudent;
//		}
//	
//	}
	
	// Sending the newly created resource
//	@PostMapping(path="/students")
//	public Student addStudent(@RequestBody Student student) {
//		
//		System.out.println(student);
//		return student;
//	}
	
	//Sending the newly created resource along with status code 201 using ResponseEntity
	// resource using ResponseEntity
//	@PostMapping(path="/students")
//	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
//		
//		System.out.println(student);
//		return ResponseEntity.status(201).body(student);
//	}
	
	
	@PostMapping(path="/students")
//	@RolesAllowed(value={"ROLE_ADMIN"})
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		
		URI uri=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/id")
				.buildAndExpand(student.getRollNumber())
				.toUri();
		
		
		      Student addedEnity = this.service.add(student);
		
		      return ResponseEntity.created(uri).body(addedEnity);
		         
	}
	
	@DeleteMapping(path="/students")
	public ResponseEntity<Student> removeStudent(@RequestBody Student entity){
		Student deleted = this.service.remove(entity)
				.orElseThrow(()-> new RuntimeException("Element with"+ entity.getRollNumber()));
		
		return ResponseEntity.status(200).body(deleted);
				
	}
	
	@DeleteMapping(path="/students/delete/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void removeStudentById(@PathVariable("id") int id){
	
		this.service.removeById(id)
		       .orElseThrow(() -> new RuntimeException("Element with "+ id +"Not Present"));
				
		
	}
	
	@PutMapping(path="/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		
		Student updated = this.service.updateStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}
	
	@PatchMapping(path="/students/{rollNumber}/{latestMark}")
	public ResponseEntity<String> updateMark(@PathVariable("rollNumber") int rollNumber, @PathVariable("latestMark") double latestMark){
		
		int rowsUpdated =this.service.updateMark(rollNumber,latestMark);
		String message= rowsUpdated +":=Rows(s) updated";
		return ResponseEntity.ok(message);
	}
	
	
	@GetMapping(path="/students/sort")
	public List<Student> getSortedStudentList(@RequestParam String proName){
		return this.service.sortByProperty(proName);
	}
	
	@GetMapping(path="/students/pageable/{pageNum}/{size}")
	public List<Student> getStudensPaged(@PathVariable int pageNum,@PathVariable int size){
		return this.service.findByPage(pageNum, size);
	}
	
	
	
	
}  

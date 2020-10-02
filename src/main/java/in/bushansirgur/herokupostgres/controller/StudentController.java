package in.bushansirgur.herokupostgres.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.herokupostgres.entity.Student;
import in.bushansirgur.herokupostgres.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository sRepo;
	
	@GetMapping("/students")
	public List<Student> findAll() {
		return sRepo.findAll();
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> save(@RequestBody Student student) {
		sRepo.save(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> find(@PathVariable("id") Long id) {
		Optional<Student> student = sRepo.findById(id);
		if (student.isPresent()) {
			return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
		}
		throw new RuntimeException("Unable to find the object");
	}
	
	@PutMapping("/students")
	public ResponseEntity<Student> update(@RequestBody Student student) {
		sRepo.save(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student> delete(@PathVariable("id") Long id) {
		Optional<Student> student = sRepo.findById(id);
		if (student.isPresent()) {
			sRepo.delete(student.get());
			return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
		}
		throw new RuntimeException("Unable to find the object!!");
	}
}

package fr.efrei.studentserver.web.rest;

import fr.efrei.studentserver.domain.Student;
import fr.efrei.studentserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    public final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }
    //Get
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudents(@PathVariable Integer id){
        return studentService.findById(id);
    }

    //Post
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.create(student.getName(), student.getAge());
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    //Put
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student){
        Student updatedStudent = studentService.update(id, student.getName(), student.getAge());
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer id){
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

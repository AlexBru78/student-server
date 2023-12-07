package fr.efrei.studentserver.web.rest;

import fr.efrei.studentserver.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    @GetMapping("/students/{id}")
    public Student getStudents(@PathVariable Integer id){
        Student student = new Student(id,"John",20);
        return student;
    }
}

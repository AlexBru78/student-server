package fr.efrei.studentserver.service;

import fr.efrei.studentserver.domain.Student;
import fr.efrei.studentserver.repository.StudentRepository;
import fr.efrei.studentserver.web.rest.StudentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    public Student create(String name, Integer age) {
        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setAge(age);
        return studentRepository.save(newStudent);
    }
}

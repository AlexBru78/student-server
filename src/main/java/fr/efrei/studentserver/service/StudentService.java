package fr.efrei.studentserver.service;

import fr.efrei.studentserver.domain.Student;
import fr.efrei.studentserver.repository.StudentRepository;
import fr.efrei.studentserver.web.rest.StudentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Student update(Integer id, String name, Integer age) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(name);
            student.setAge(age);
            return studentRepository.save(student);
        } else {
            return null;
        }
    }
}

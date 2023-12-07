package fr.efrei.studentserver.web.rest;

import fr.efrei.studentserver.domain.Student;
import fr.efrei.studentserver.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class StudentResourceIT {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    void createStudent() throws Exception {
        int databaseSizeBeforeCreate = studentRepository.findAll().size();
        assertThat(databaseSizeBeforeCreate).isEqualTo(0);

        Student student = new Student();
        student.setName("Alex");
        student.setAge(20);
        studentRepository.save(student);

        List<Student> studentList = studentRepository.findAll();
        assertThat(studentList).hasSize(databaseSizeBeforeCreate + 1);
    }

    @Test
    @Transactional
    void updateStudent() throws Exception {
        Student student = new Student();
        student.setName("Alex");
        student.setAge(20);
        studentRepository.save(student);

        int databaseSizeBeforeUpdate = studentRepository.findAll().size();
        assertThat(databaseSizeBeforeUpdate).isEqualTo(1);

        student.setName("Alexandre");
        student.setAge(21);
        studentRepository.save(student);

        List<Student> studentList = studentRepository.findAll();
        assertThat(studentList).hasSize(databaseSizeBeforeUpdate);
        assertThat(studentList.get(0).getName()).isEqualTo("Alexandre");
        assertThat(studentList.get(0).getAge()).isEqualTo(21);
    }

    @Test
    @Transactional
    void deleteStudent() throws Exception {
        Student student = new Student();
        student.setName("Alex");
        student.setAge(20);
        studentRepository.save(student);

        int databaseSizeBeforeDelete = studentRepository.findAll().size();
        assertThat(databaseSizeBeforeDelete).isEqualTo(1);

        studentRepository.delete(student);

        List<Student> studentList = studentRepository.findAll();
        assertThat(studentList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

package fr.efrei.studentserver.repository;

import fr.efrei.studentserver.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAll();
    Student findById(int id);
    Student save(Student student);
    void deleteById(Integer id);

}
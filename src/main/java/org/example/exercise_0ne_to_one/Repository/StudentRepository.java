package org.example.exercise_0ne_to_one.Repository;

import org.example.exercise_0ne_to_one.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);
}

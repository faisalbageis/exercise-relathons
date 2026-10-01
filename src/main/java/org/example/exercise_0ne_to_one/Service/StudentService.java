package org.example.exercise_0ne_to_one.Service;

import lombok.RequiredArgsConstructor;
import org.example.exercise_0ne_to_one.Api.ApiException;
import org.example.exercise_0ne_to_one.Model.Course;
import org.example.exercise_0ne_to_one.Model.Student;
import org.example.exercise_0ne_to_one.Repository.CourseRepository;
import org.example.exercise_0ne_to_one.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
private  final StudentRepository studentRepository;
private final CourseRepository courseRepository;



    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student) {

        Student oldStudent = studentRepository.findStudentById(id);

        if (oldStudent == null) {
            throw  new ApiException("student not found");
        }

        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());

        studentRepository.save(oldStudent);

    }

    public void deleteStudent(Integer id) {

        Student student = studentRepository.findStudentById(id);

        if (student == null) {
            throw  new ApiException("student not found");
        }

        studentRepository.delete(student);

    }

    public void assignStudentToCourse(Integer student_id,Integer course_id){
         Student student= studentRepository.findStudentById(student_id);

        Course course = courseRepository.findCourseById(course_id);

        if(student==null||course==null){
            throw new ApiException("student or course not found");
        }
       course.getStudents().add(student);
        student.getCourses().add(course);

        courseRepository.save(course);
        studentRepository.save(student);
    }
    public void changeMajor(Integer student_id,String Major){
        Student student = studentRepository.findStudentById(student_id);
        if(student==null){
            throw new ApiException("student not found");
        }

        student.setMajor(Major);
        Set<Course> courses = student.getCourses();
        for(Course i:courses){
            i.getStudents().remove(student);
            courseRepository.save(i);
        }

        student.getCourses().clear();
        studentRepository.save(student);
    }

}

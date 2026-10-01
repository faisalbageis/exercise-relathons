package org.example.exercise_0ne_to_one.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exercise_0ne_to_one.Model.Course;
import org.example.exercise_0ne_to_one.Model.Student;
import org.example.exercise_0ne_to_one.Service.Courseservice;
import org.example.exercise_0ne_to_one.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity<?> getStudents(){
        List<Student> students= studentService.getStudents();

        return ResponseEntity.status(200).body(students);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);

        return ResponseEntity.status(201).body("student added successfully");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id,@Valid @RequestBody Student student){
        studentService.updateStudent(id,student);

        return ResponseEntity.status(200).body("student updated successfully");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);

        return ResponseEntity.status(200).body("student deleted successfully");
    }


    @PutMapping("/assignCourse/{student_id}/{course_id}")
    public ResponseEntity<?> assignStudentToCourse(@PathVariable Integer student_id,@PathVariable Integer course_id){
        studentService.assignStudentToCourse(student_id,course_id);

        return ResponseEntity.status(200).body("student assigned to course successfully");
    }


    @PutMapping("/changeMajor/{student_id}/{Major}")
    public ResponseEntity<?> changeMajor(@PathVariable Integer student_id,@PathVariable String Major){
        studentService.changeMajor(student_id,Major);

        return ResponseEntity.status(200).body("student major changed successfully");
    }

}

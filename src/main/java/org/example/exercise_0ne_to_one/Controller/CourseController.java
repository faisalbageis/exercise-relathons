package org.example.exercise_0ne_to_one.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exercise_0ne_to_one.Api.ApiException;
import org.example.exercise_0ne_to_one.Api.ApiResponse;
import org.example.exercise_0ne_to_one.Dto.AddressDto;
import org.example.exercise_0ne_to_one.Model.Address;
import org.example.exercise_0ne_to_one.Model.Course;
import org.example.exercise_0ne_to_one.Model.Student;
import org.example.exercise_0ne_to_one.Service.AddressService;
import org.example.exercise_0ne_to_one.Service.Courseservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private  final Courseservice courseservice;


    @GetMapping("/get")
    public ResponseEntity<?> getCourses(){
        List<Course> courses = courseservice.getCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid Course course){
        courseservice.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("course added successfully"));
    }

    @PutMapping("/update/{course_id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer course_id,@RequestBody @Valid Course course){
        courseservice.updateCourse(course_id,course);
        return ResponseEntity.status(200).body(new ApiResponse("course updated successfully"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        courseservice.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("course deleted successfully"));
    }

    @PutMapping("/assign/{course_id}/{teacher_id}")
    public ResponseEntity<?> assignTeacherToCourse(@PathVariable Integer course_id,@PathVariable Integer teacher_id){
        courseservice.assignTeacherToCourse(course_id, teacher_id);
        return ResponseEntity.status(200).body(new ApiResponse("assigned successfully"));
    }

    @GetMapping("/get/students/{course_id}")
    public ResponseEntity<?> getStudents(@PathVariable Integer course_id){
        Set<Student> students = courseservice.getstudent(course_id);
        if(students.isEmpty()){
            throw new ApiException("there is no student in this course");
        }
        return ResponseEntity.status(200).body(students);
    }
}

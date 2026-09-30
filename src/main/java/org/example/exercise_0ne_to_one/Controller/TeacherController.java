package org.example.exercise_0ne_to_one.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exercise_0ne_to_one.Api.ApiResponse;
import org.example.exercise_0ne_to_one.Model.Teacher;
import org.example.exercise_0ne_to_one.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity<?> getTeachers(){
        List<Teacher> teachers = teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated successfully"));
    }
    @GetMapping("/get/id/{id}")
    public ResponseEntity<?> getByTeacherId(@PathVariable Integer id){
        Teacher teacher = teacherService.getTeacherByID(id);
        return ResponseEntity.status(200).body(teacher);
    }
}

package org.example.exercise_0ne_to_one.Service;

import lombok.RequiredArgsConstructor;
import org.example.exercise_0ne_to_one.Api.ApiException;
import org.example.exercise_0ne_to_one.Model.Course;
import org.example.exercise_0ne_to_one.Model.Student;
import org.example.exercise_0ne_to_one.Model.Teacher;
import org.example.exercise_0ne_to_one.Repository.CourseRepository;
import org.example.exercise_0ne_to_one.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class Courseservice {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getCourses(){
        List<Course> courses= courseRepository.findAll();
        if(courses.isEmpty()){
            throw new ApiException("there is no courses in the system");
        }

        return courses;
    }


    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer course_id,Course course){
        Course oldcourse = courseRepository.findCourseById(course_id);

        if(course==null){
            throw new ApiException("course not found");
        }

        oldcourse.setName(course.getName());
        courseRepository.save(oldcourse);
    }


    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);

        if(course==null){
            throw new ApiException("course not found");
        }

        courseRepository.delete(course);
    }

    public void assignTeacherToCourse(Integer course_id,Integer teacher_id){
        Course course = courseRepository.findCourseById(course_id);

        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if(course==null||teacher==null){
            throw new ApiException("course or teacher not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public Set<Student> getstudent(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        return course.getStudents();
    }

}

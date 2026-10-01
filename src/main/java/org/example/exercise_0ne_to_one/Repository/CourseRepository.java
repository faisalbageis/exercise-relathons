package org.example.exercise_0ne_to_one.Repository;

import org.example.exercise_0ne_to_one.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);
}

package org.example.exercise_0ne_to_one.Service;

import lombok.RequiredArgsConstructor;
import org.example.exercise_0ne_to_one.Api.ApiException;
import org.example.exercise_0ne_to_one.Model.Teacher;
import org.example.exercise_0ne_to_one.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }


    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);

        if(oldTeacher==null){
            throw new ApiException("teacher not found");
        }

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setAddress(teacher.getAddress());
        teacherRepository.save(oldTeacher);
    }



    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);

        if(teacher==null){
            throw new ApiException("teacher not found");
        }

        teacherRepository.delete(teacher);
    }


    public Teacher getTeacherByID(Integer teacherID){
        Teacher teacher = teacherRepository.findTeacherById(teacherID);
        if(teacher==null){
            throw new ApiException("there is no teacher with this id");
        }

        return teacher;
    }

}

package com.icr.springdatajpatutorialcretu.repository;

import com.icr.springdatajpatutorialcretu.entity.Course;
import com.icr.springdatajpatutorialcretu.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
 @Test
    public void    saveTeacher(){

        Course courseDBA = Course.builder()
                .title("DBsssA")
                .credit(5)
                .build();

        Course courseDJava = Course.builder()
                .title("Javsssa")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("t2")
                .lastName("T2")
                .courses(List.of(courseDBA, courseDJava))
                .build();
        teacherRepository.save(teacher);
    }
}
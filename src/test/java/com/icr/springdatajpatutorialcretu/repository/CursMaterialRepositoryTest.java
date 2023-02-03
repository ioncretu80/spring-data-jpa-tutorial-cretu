package com.icr.springdatajpatutorialcretu.repository;

import com.icr.springdatajpatutorialcretu.entity.Course;
import com.icr.springdatajpatutorialcretu.entity.CourseMaterial;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CursMaterialRepositoryTest {
    @Autowired
    CourseMaterialRepository coursMaterialRepository;

    @Test
    public void SaveCourseMaterial(){

        Course course = Course.builder()
                .title(".net")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.daylycode.com")
                .course(course)
                .build();

        coursMaterialRepository.save(courseMaterial);

    }

    @Test
    public void printAllCurses(){
        List<CourseMaterial> list =coursMaterialRepository.findAll();
        System.out.println("courseMaterial " + list);
    }


}
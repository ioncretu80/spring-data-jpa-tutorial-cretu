package com.icr.springdatajpatutorialcretu.repository;

import com.icr.springdatajpatutorialcretu.entity.Course;
import com.icr.springdatajpatutorialcretu.entity.CourseMaterial;
import com.icr.springdatajpatutorialcretu.entity.Student;
import com.icr.springdatajpatutorialcretu.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
@SpringBootTest
class CourseRepositoryTest {
@Autowired
    CourseRepository courseRepository;

    @Test
    public void printAllCurses(){
        List<Course>  list =courseRepository.findAll();
        System.out.println("course " + list);
    }

    @Test
    public void saveCourseWithTeacherObject(){
        Teacher teacher =Teacher.builder()
                .firstName("Ion")
                .lastName("Dudca")
                .build();
        Course course = Course.builder()
               .title("Python")
               .credit(6)
               .teacher(teacher)
               .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCredit = PageRequest.of(0,2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDescending = PageRequest.of(0,2, Sort.by("title").descending().and(Sort.by("credit")));
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Courses "+courses);

    }

    @Test
    public void findAllPagination(){


        Pageable firstPageWithTwoElements = PageRequest.of(0, 3);

        Pageable secondPageWithFiveElements = PageRequest.of(1, 2);



        List<Course> courses = courseRepository.findAll(firstPageWithTwoElements).getContent();

        long totalElements = courseRepository.findAll(firstPageWithTwoElements).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithTwoElements).getTotalPages();

        System.out.println("TotalElements" + totalElements);
        System.out.println("TotalPages" + totalPages);



    }


    @Test
    public void saveCourseWithTeacherAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Lazy")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("sddsdsd")
                .lastName("sadsad")
                .emailId("hkf@mail.ru").build();

        CourseMaterial curseMaterial = CourseMaterial.builder()
                .url("www.tyu.de").build();

        Course course =Course.builder()
                .title("title")
                .credit(12)
                .teacher(teacher)
                .students(List.of(student))
                .build();

        course.getStudents();
        //course.addStudent(student);
        courseRepository.save(course);
    }
}
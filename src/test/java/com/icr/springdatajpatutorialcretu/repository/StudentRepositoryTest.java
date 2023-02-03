package com.icr.springdatajpatutorialcretu.repository;

import com.icr.springdatajpatutorialcretu.entity.Student.Guardian;
import com.icr.springdatajpatutorialcretu.entity.Student.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void testUpdate(){
        studentRepository.updateStudentNameByEmailId("Ionica","i1@mail.md");
        Student student = studentRepository.findStudentByEmail("i1@mail.md");
            assertEquals("Ionica", student.getFirstName());

        }


    @Test
    public void findByStudentByEmail(){
        Student list = studentRepository.findStudentByEmail("i@mail.md");
            assertEquals("i@mail.md", list.getEmailId());


    }

    @Test
    public void findByLastName(){
        List<Student> list = studentRepository.findByLastName("cretu");
        if(list.size()!=0){

            assertEquals("cretu", list.get(0).getLastName());

        }
    }

    @Test
    public void findByFirstNameContains(){
        List<Student> list = studentRepository.findByFirstNameContains("on");
        if(list.size()!=0){

            assertEquals("Ion", list.get(0).getFirstName());

        }
    }
    @Test
    public void findByFirstName(){
        List<Student> list = studentRepository.findByFirstName("Ion");
        assertEquals("Ion", list.get(0).getFirstName());
    }
@Test
    public void saveStudent(){
        Student student= Student.builder()
                .emailId("i@mail.md")
                .firstName("Ion")
                .lastName("cretu")
              //  .guardianName("Guardian name")
              //  .guardianEmail("io@gmail.com")
              //  .guardianMobile("12321321")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Petru")
                .email("pe@gmail.com")
                .mobile("1234567866")
                .build();
        Student student= Student.builder()
                .emailId("i1@mail.md")
                .firstName("Ion")
                .lastName("cretu")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }



    @Test
    public void printAllStudents(){
        List<Student> list = studentRepository.findAll();

        System.out.println("Student list: "+list);
    }
}
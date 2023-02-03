package com.icr.springdatajpatutorialcretu.repository;

import com.icr.springdatajpatutorialcretu.entity.CourseMaterial;
import com.icr.springdatajpatutorialcretu.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {



}


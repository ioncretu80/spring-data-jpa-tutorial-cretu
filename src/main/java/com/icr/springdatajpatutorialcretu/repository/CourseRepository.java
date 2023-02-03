package com.icr.springdatajpatutorialcretu.repository;

import com.icr.springdatajpatutorialcretu.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {



}


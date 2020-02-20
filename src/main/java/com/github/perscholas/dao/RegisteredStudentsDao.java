package com.github.perscholas.dao;

import com.github.perscholas.model.CourseInterface;
import com.github.perscholas.model.StudentInterface;

import java.util.List;

/**
 * Created by leon on 2/19/2020.
 */
public interface RegisteredStudentsDao extends Dao {
    List<CourseInterface> getAllCourses(String studentEmail);
    List<StudentInterface> getAllStudents(String courseName);
    List<StudentInterface> getAllStudents(Integer courseId);
}

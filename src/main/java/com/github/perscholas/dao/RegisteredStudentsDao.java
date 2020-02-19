package com.github.perscholas.dao;

import com.github.perscholas.model.CourseInterface;

import java.util.List;

/**
 * Created by leon on 2/19/2020.
 */
public interface RegisteredStudentsDao {
    List<CourseInterface> getAllCourses(String studentEmail);
}

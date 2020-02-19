package com.github.perscholas.service;

import com.github.perscholas.dao.RegisteredStudentsDao;
import com.github.perscholas.model.CourseInterface;

import java.util.List;

/**
 * Created by leon on 2/19/2020.
 */
public class RegisteredStudentsService implements RegisteredStudentsDao {
    @Override
    public List<CourseInterface> getAllCourses(String studentEmail) {
        return null;
    }
}

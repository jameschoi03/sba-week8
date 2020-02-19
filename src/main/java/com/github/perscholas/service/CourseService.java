package com.github.perscholas.service;

import com.github.perscholas.DatabaseConnection;
import com.github.perscholas.dao.CourseDao;
import com.github.perscholas.model.Course;
import com.github.perscholas.model.CourseInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// TODO - Implement respective DAO interface
public class CourseService implements CourseDao {
    @Override
    public List<CourseInterface> getAllCourses() {
        List<CourseInterface> list = new ArrayList<>();
        ResultSet rs = DatabaseConnection.MANAGEMENT_SYSTEM.executeQuery("SELECT * FROM courses");
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String insturctor = rs.getString("instructor");
                Course course = new Course(id, name, insturctor);
                list.add(course);
            }
        } catch (SQLException e) {
            throw new Error(e);
        }
        return list;
    }

    @Override
    public List<Integer> getAllCourseIds() {
        return getAllCourses()
                .stream()
                .map(course -> course.getId())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllCourseNames() {
        return getAllCourses()
                .stream()
                .map(course -> course.getId() + " - " + course.getName())
                .collect(Collectors.toList());
    }
}

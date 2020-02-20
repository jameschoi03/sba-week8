package com.github.perscholas.service;

import com.github.perscholas.DatabaseConnection;
import com.github.perscholas.dao.CourseDao;
import com.github.perscholas.dao.RegisteredStudentsDao;
import com.github.perscholas.model.CourseInterface;
import com.github.perscholas.model.StudentInterface;
import jdk.internal.org.objectweb.asm.commons.InstructionAdapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2/19/2020.
 */
public class RegisteredStudentsService implements RegisteredStudentsDao {
    @Override
    public List<CourseInterface> getAllCourses(String studentEmail) {
        List<CourseInterface> list = new ArrayList<>();
        CourseDao courseService = new CourseService();
        ResultSet emailsAndIds = getDatabaseConnection().executeQuery("SELECT * FROM RegisteredStudents WHERE `email` = '" + studentEmail + "'");
        try {
            while (emailsAndIds.next()) {
                Integer id = emailsAndIds.getInt("id");
                CourseInterface course = courseService.getCourse(id);
                list.add(course);
            }
        } catch (SQLException e) {
            throw new Error(e);
        }
        return list;
    }


    @Override
    public List<StudentInterface> getAllStudents(String courseName) {
        return null;
    }

    @Override
    public List<StudentInterface> getAllStudents(Integer courseId) {
        return null;
    }

    @Override
    public DatabaseConnection getDatabaseConnection() {
        return DatabaseConnection.MANAGEMENT_SYSTEM;
    }
}

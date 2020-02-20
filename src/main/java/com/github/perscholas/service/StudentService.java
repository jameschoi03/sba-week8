package com.github.perscholas.service;

import com.github.perscholas.DatabaseConnection;
import com.github.perscholas.dao.StudentDao;
import com.github.perscholas.model.CourseInterface;
import com.github.perscholas.model.Student;
import com.github.perscholas.model.StudentInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TODO - Implement respective DAO interface
public class StudentService implements StudentDao {

    public List<StudentInterface> getAllStudentsWhere(String condition) {
        ResultSet result = getDatabaseConnection().executeQuery("SELECT * FROM students WHERE " + condition + ";");
        List<StudentInterface> list = new ArrayList<>();
        try {
            while (result.next()) {
                String studentEmail = result.getString("email");
                String name = result.getString("name");
                String password = result.getString("password");
                StudentInterface student = new Student(studentEmail, name, password);
                list.add(student);
            }
        } catch (SQLException se) {
            throw new Error(se);
        }

        return list;
    }

    @Override
    public List<StudentInterface> getAllStudents() {
        return getAllStudentsWhere("true");
    }

    @Override
    public StudentInterface getStudentByEmail(String studentEmail) {
        return getAllStudentsWhere("`email` = '" + studentEmail + "'").get(0);
    }

    @Override
    public Boolean validateStudent(String studentEmail, String password) {
        return getStudentByEmail(studentEmail).getPassword().equals(password);
    }

    @Override
    public void registerStudentToCourse(String studentEmail, int courseId) {

    }

    @Override
    public List<CourseInterface> getStudentCourses(String studentEmail) {
        return null;
    }

    @Override
    public DatabaseConnection getDatabaseConnection() {
        return DatabaseConnection.MANAGEMENT_SYSTEM;
    }
}

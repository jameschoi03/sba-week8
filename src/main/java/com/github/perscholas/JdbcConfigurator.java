package com.github.perscholas;

import com.github.perscholas.utils.DirectoryReference;
import com.github.perscholas.utils.FileReader;
import org.mariadb.jdbc.Driver;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfigurator {
    static {
        // Attempt to register JDBC Driver
        try {
            DriverManager.registerDriver(Driver.class.newInstance());
        } catch (InstantiationException | IllegalAccessException | SQLException e1) {
            throw new Error(e1);
        }
    }

    private static final DatabaseConnection dbc = DatabaseConnection.MANAGEMENT_SYSTEM;

    public static void initialize() {
        dbc.drop();
        dbc.create();
        dbc.use();
        createTable("courses.create-table.sql");
        createTable("students.create-table.sql");
    }

    private static void createTable(String fileName) {
        File creationStatementFile = DirectoryReference.RESOURCE_DIRECTORY.getFileFromDirectory(fileName);
        FileReader fileReader = new FileReader(creationStatementFile.getAbsolutePath());
        String creationStatement = fileReader.toString();
        dbc.executeStatement(creationStatement);
    }
}

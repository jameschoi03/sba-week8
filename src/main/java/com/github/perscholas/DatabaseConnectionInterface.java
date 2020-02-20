package com.github.perscholas;

import com.github.perscholas.utils.ConnectionBuilder;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DatabaseConnectionInterface {

    String getDatabaseName();

    Connection getDatabaseConnection();

    Connection getDatabaseEngineConnection();

    void drop();

    void create();

    void use();

    void executeStatement(String sqlStatement);

    ResultSet executeQuery(String sqlQuery);
}

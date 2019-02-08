package com.horiaconstantin.integration.testutils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Handles DB connections. Defaults to localhost and default ports for databases
 */
public class DatabaseTestUtilities {

    private String mysqlHost = "localhost";
    private int mysqlPort = 3306;
    private String username;
    private String password;
    private String dbName;

    public DatabaseTestUtilities(String username, String password, String dbName) {
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }

    public DatabaseTestUtilities setMysqlHost(String mysqlHost) {
        this.mysqlHost = mysqlHost;
        return this;
    }

    public DatabaseTestUtilities setMysqlPort(int mysqlPort) {
        this.mysqlPort = mysqlPort;
        return this;
    }

    public Connection getMySqlConnection() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");

        String connectionUrl = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&allowMultiQueries=true",
                mysqlHost, mysqlPort, dbName, username, password);

        return DriverManager.getConnection(connectionUrl);
    }
}

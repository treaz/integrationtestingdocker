package com.horiaconstantin.integration;

import com.horiaconstantin.integration.testutils.DatabaseTestUtilities;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DatabaseIntegrationTest {


    @Test
    public void selectFirstCandidate() throws Exception {
        DatabaseTestUtilities databaseTestUtilities = new DatabaseTestUtilities("root", "1234", "mysqljdbc");
        databaseTestUtilities.setMysqlPort(63306);

        try (Connection mySqlConnection = databaseTestUtilities.getMySqlConnection()) {
            Statement statement = mySqlConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM candidates");

//                1, 'Carine ', 'Schmitt', '1980-01-01', '(403) 225-5556', 'carine.s@gmail.com\r'
            resultSet.next();
            assertThat(resultSet.getInt(1), is(1));
            assertThat(resultSet.getString(2), is("Carine"));
            assertThat(resultSet.getString(3), is("Schmitt"));
        }

    }
}

package javaExamplesJDBC.ex002_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/carsshop";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
         registerDriver();

        Connection connection = null;
        Statement statement = null;


        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

//            statement.execute("INSERT INTO cars(mark_id, model, price) VALUES (2, '911 turbo S', 200000)");
//            int res = statement.executeUpdate("UPDATE clients SET age = age + 1 WHERE name = 'petro'");
//            System.out.println(res);

//            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (1, 'A6', 40000)");
//            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (2, 'Cayenne turbo', 140000)");
//            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (1, 'S7', 100000)");
//
//            statement.executeBatch();

            boolean closed = statement.isClosed();
            System.out.println(closed);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

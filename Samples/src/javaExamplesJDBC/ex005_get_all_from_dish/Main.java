package javaExamplesJDBC.ex005_get_all_from_dish;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Arrays;
import java.util.Calendar;


public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/carsshop";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String GET_ALL = "SELECT * FROM dish";

    public static void main(String[] args) {
        registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;


        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(GET_ALL);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
               int id = resultSet.getInt("id");
               String title = resultSet.getString("title");
               String description = resultSet.getString("description");
               double rating = resultSet.getDouble("rating");
               boolean published = resultSet.getBoolean("published");
               Date date = resultSet.getDate("created");
               byte[] bytes = resultSet.getBytes("icon");

                System.out.println(id + " " + " " + title + " " + description
                                  + " " + rating + " " + published + " " + date
                                   );
               // System.out.println(Arrays.toString(bytes));
            }

        } catch (SQLException  e) {
            e.printStackTrace();
        }  finally {
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

package javaExamplesJDBC.ex006_delete_from_dish;

import java.sql.*;


public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/carsshop";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String DELETE = "DELETE FROM dish WHERE id = ?";

    public static void main(String[] args) {
        registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;


        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(DELETE);

            statement.setInt(1,3);

            statement.executeUpdate();


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

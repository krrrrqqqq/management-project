package com.example.attendensmanagmentsystem;
import java.sql.ResultSet;


 import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUsers, dbPass);
        return dbConnection;
    }


    public void signUpUser(String FirstName, String LastName, String username,
                           String password, String role)
            throws SQLException, ClassNotFoundException {

        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
                Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," +
                Const.USERS_ROLE + ")" +
                "VALUES(?,?,?,?,?)";

        try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {
            prSt.setString(1, FirstName);
            prSt.setString(2, LastName);
            prSt.setString(3, username);
            prSt.setString(4, password);
            prSt.setString(5, role);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String username, String password) {
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";

        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(select)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int userId = resultSet.getInt(Const.USERS_ID);  // Use the correct column name
                    String userName = resultSet.getString(Const.USERS_USERNAME);
                    String userPassword = resultSet.getString(Const.USERS_PASSWORD);

                    User user = new User(userId, userName, userPassword);
                    return user;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception appropriately, you might want to log or throw it
        }

        return null; // Return null if no user is found
    }



}




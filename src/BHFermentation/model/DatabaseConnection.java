/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author Mitchell
 */
public class DatabaseConnection {
    public DatabaseConnection() throws SQLException
    {
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/history", "nbuser", "nbuser");
        System.out.println("Connection Created");
    }
}

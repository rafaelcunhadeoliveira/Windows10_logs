/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;
import java.util.*;

/**
 *
 * @author rafaelcunhadeoliveira
 */
public class DataBase {

    Connection connection;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    String serverName = "localhost";    //caminho do servidor do BD
    String mydatabase = "Windows10_Logs";   //nome do seu banco de dados
    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    String username = "root";        //nome de um usuário de seu BD      
    String password = "root";      //sua senha de acesso

    public void conectar() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        if (connection != null) {
            System.out.println("STATUS--->Conectado com sucesso!");
        } else {
            System.out.println("STATUS--->Não foi possivel realizar conexão");
        }

    }

    public void insertIntoGroups(String name, String desc) throws SQLException {
        String insertIntoTable = "INSERT INTO Windows10_Logs.Group (Name, Description) VALUES (?,?);";

        try {
            preparedStatement = connection.prepareStatement(insertIntoTable);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, desc);

            preparedStatement.executeUpdate();

            System.out.println("Linhas inseridas!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Boolean insertIntoComputer(String name, String group) throws SQLException {
        String insertIntoTable = "INSERT INTO Windows10_Logs.Group (Name, Group_idGroup) VALUES (?,?);";

        try {
            preparedStatement = connection.prepareStatement(insertIntoTable);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, group);

            preparedStatement.executeUpdate();

            System.out.println("Linhas inseridas!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return true;
    }

    public List<String> selectFromGroup() throws SQLException {
        String selectTableSQL = "SELECT NAME FROM Windows10_Logs.Group;";
        List<String> allGroups = new ArrayList<>();
        try {

            statement = connection.createStatement();

            System.out.println(selectTableSQL);

            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {
                allGroups.add(rs.getString("Name"));
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {

                statement.close();

            }

        }
        return allGroups;
    }

    public List<String> selectFromComputers() throws SQLException {
        String selectTableSQL = "SELECT NAME FROM Windows10_Logs.Computer;";
        List<String> allComp = new ArrayList<>();
        try {

            statement = connection.createStatement();

            System.out.println(selectTableSQL);

            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {
                allComp.add(rs.getString("Name"));
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {

                statement.close();

            }

        }
        return allComp;
    }

}

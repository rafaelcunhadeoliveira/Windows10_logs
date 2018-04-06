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

    public void closeCon() throws SQLException {
        connection.close();
    }

    /**
     *
     * @param name
     * @param desc
     * @throws SQLException
     */
    public void insertIntoGroups(String name, String desc) throws SQLException {
        String insertIntoTable = "INSERT INTO Windows10_Logs.Group (Name, Description) VALUES (?,?);";

        try {
            preparedStatement = connection.prepareStatement(insertIntoTable, Statement.RETURN_GENERATED_KEYS);

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

    public void insertIntoComputer(String name, int group) throws SQLException {
        String insertIntoTable = "INSERT INTO Windows10_Logs.Computer (Name, Group_idGroup) VALUES (?,?);";

        try {
            preparedStatement = connection.prepareStatement(insertIntoTable, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, group);

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

    public void insertIntoFile(String address, int computer) throws SQLException {
        String insertIntoTable = "INSERT INTO Windows10_Logs.File (Address, Computer_idComputer) VALUES (?,?);";

        try {
            preparedStatement = connection.prepareStatement(insertIntoTable, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, address);
            preparedStatement.setInt(2, computer);

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

    public HashMap<Integer, String> selectFromGroup() throws SQLException {
        String selectTableSQL = "SELECT * FROM Windows10_Logs.Group;";
        HashMap<Integer, String> allGroups = new HashMap<>();
        try {

            preparedStatement = connection.prepareStatement(selectTableSQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.executeQuery();

            int id;
            String name;
            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                allGroups.put(id, name);
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

    public HashMap<Integer, String> selectFromComputers() throws SQLException {
        String selectTableSQL = "SELECT * FROM Windows10_Logs.Computer;";
        HashMap<Integer, String> allComputers = new HashMap<>();
        try {

            preparedStatement = connection.prepareStatement(selectTableSQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.executeQuery();

            int id;
            String name;
            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                allComputers.put(id, name);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {

                statement.close();

            }

        }
        return allComputers;
    }

    public HashMap<Integer, String> selectFromComputersUsingWhere(int groupId) throws SQLException {
        String selectTableSQL = "SELECT * from Windows10_Logs.Computer  WHERE  Group_idGroup = " + groupId + ";";
        HashMap<Integer, String> allComputers = new HashMap<>();
        try {

            preparedStatement = connection.prepareStatement(selectTableSQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.executeQuery();

            int id;
            String name;
            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                allComputers.put(id, name);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {

                preparedStatement.close();

            }

        }
        return allComputers;
    }

}

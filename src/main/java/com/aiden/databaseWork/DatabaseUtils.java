package com.aiden.databaseWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtils {
    private String url;
    private String username;
    private String password;

    public void setUrl(String url){this.url = url;}
    public void setUsername(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}

    public void createTable(Table table){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(this.url, this.username, this.password);

            Statement statement = connection.createStatement();

            String sql = "CREATE TABLE " + table.getName() + " (" +
                    "  student_id INT NOT NULL,\n" +
                    "  first_name VARCHAR(50),\n" +
                    "  last_name VARCHAR(50),\n" +
                    "  student_present BOOL,\n" +
                    "  PRIMARY KEY (student_id)\n" +
                    ");";

            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("---------------------------");
            System.out.println("Rows Affected: " + rowsAffected);

            connection.close();
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public void addToTable(Table table){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(this.url, this.username, this.password);

            Statement statement = connection.createStatement();

            String tableString = table.toString();

            String sql1 = "INSERT INTO " + table.getName() + " (student_id, first_name, last_name, student_present)\n" +
                    "VALUES\n" + tableString + ";";
            System.out.println(sql1);

            int rowsAffected1 = statement.executeUpdate(sql1);
            System.out.println("---------------------------");
            System.out.println("Rows Affected: " + rowsAffected1);

            connection.close();
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public String showTable(String tableName){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(this.url, this.username, this.password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student_attendance." + tableName);

            while (resultSet.next()){

                int student_id = resultSet.getInt(1);
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);
                boolean present = resultSet.getBoolean(4);

                stringBuilder.append(student_id).append(" ").append(first_name).append(" ").append(last_name).append(" ").append(present).append("|");
            }

            connection.close();

            return stringBuilder.toString();
        }
        catch (Exception e){

            return "Error: " + e;
        }

    }

}

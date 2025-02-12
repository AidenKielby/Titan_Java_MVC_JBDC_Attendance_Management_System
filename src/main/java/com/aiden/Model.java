package com.aiden;

import com.aiden.databaseWork.Row;
import com.aiden.databaseWork.Table;
import com.aiden.databaseWork.DatabaseUtils;

import java.util.Objects;

public class Model {
    DatabaseUtils databaseUtils = new DatabaseUtils();


    public void createTable(String tableName){
        Table table = new Table(tableName);
        this.databaseUtils.createTable(table);
    }

    public void addToTable(Table table, int Id, String firstName, String lastName, boolean present){
        Row row = new Row(Id, firstName, lastName, present);
        table.addRow(row);
    }

    public void setTableValues(Table table){
        databaseUtils.setPassword("A!den13$");
        databaseUtils.setUrl("jdbc:mysql://localhost:3306/student_attendance");
        databaseUtils.setUsername("root");

        if (!Objects.equals(table.toString(), "")) {
            this.databaseUtils.setTableValues(table);
        }
    }

}

package com.aiden;

import com.aiden.databaseWork.Row;
import com.aiden.databaseWork.Table;
import com.aiden.databaseWork.DatabaseUtils;

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

    public void addRowToTable(Table table){
        this.databaseUtils.addToTable(table);
    }
}

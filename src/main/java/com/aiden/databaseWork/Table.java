package com.aiden.databaseWork;

import java.util.ArrayList;

public class Table {
    private ArrayList<Row> rows = new ArrayList<>();
    public String name;

    public Table(String name){
        this.name = name;
    }

    public void addRow(Row row){
        this.rows.add(row);
    }

    public ArrayList<Row> getRows(){
        return this.rows;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.rows.size(); i++){
            Row row = this.rows.get(i);
            String rowString = "";
            if (i < this.rows.size()-1){
                rowString = "(" + row.getID() + ", '" + row.getFirstName() + "', '" + row.getLastName() + "', " + row.getIsPresent() + "), \n";
            }
            else {
                rowString = "(" + row.getID() + ", '" + row.getFirstName() + "', '" + row.getLastName() + "', " + row.getIsPresent() + ")";
            }

            s.append(rowString);
        }
        return s.toString();

    }
}

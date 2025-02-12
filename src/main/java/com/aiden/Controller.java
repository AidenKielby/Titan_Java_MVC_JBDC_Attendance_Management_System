package com.aiden;

import com.aiden.databaseWork.DatabaseUtils;
import com.aiden.databaseWork.Row;
import com.aiden.databaseWork.Table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class Controller {
    private View view;
    private Model model;
    private DatabaseUtils databaseUtills;


    public Controller(View view, Model model, DatabaseUtils databaseUtils){
        this.view = view;
        this.model = model;
        this.databaseUtills = databaseUtils;

        databaseUtils.setPassword("A!den13$");
        databaseUtils.setUrl("jdbc:mysql://localhost:3306/student_attendance");
        databaseUtils.setUsername("root");



        this.view.addNewRowListener(new RowListener());
        this.view.addNewRowToDatabaseListener(new RowToDatabaseListener());
        this.view.removeBottomRowListener(new RemoveBottomRowListener());
        this.view.showTableListener(new ShowTableListener());

    }

    class RowListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.newRow();
        }
    }

    class RowToDatabaseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Objects.equals(view.getInputtedTableName(), "")) {
                Object[][] data = view.getOutData();
                String tableName = view.getInputtedTableName();
                Table table = new Table(tableName);
                try {
                    for (Object[] rowOjb : data) {
                        Row row = new Row();
                        row.fromList(rowOjb);
                        table.addRow(row);
                    }

                    model.setTableValues(table);
                } catch (Exception e1) {
                    view.displayError("Error: " + e1);
                }
            }
        }
    }

    class RemoveBottomRowListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.removeBottomRow();
        }
    }

    class ShowTableListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Objects.equals(view.getInputtedTableName(), "")) {
                String table = databaseUtills.showTable(view.getInputtedTableName());
                view.setData(table);
            }
        }
    }

}

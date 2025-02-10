package com.aiden;

import com.aiden.databaseWork.DatabaseUtils;
import com.aiden.databaseWork.Row;
import com.aiden.databaseWork.Table;

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

        view.setData(databaseUtils.showTable("first_one"));
    }



}

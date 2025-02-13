package com.aiden;

import com.aiden.databaseWork.DatabaseUtils;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        DatabaseUtils databaseUtils = new DatabaseUtils();
        Controller controller = new Controller(view, model, databaseUtils);
        view.setVisible(true);
    }
}
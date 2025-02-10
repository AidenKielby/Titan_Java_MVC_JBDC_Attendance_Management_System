package com.aiden.databaseWork;

public class Row {
    private final int ID;
    private final String firstName;
    private final String lastName;
    private final boolean isPresent;

    public Row(int ID, String firstName, String lastName, boolean isPresent){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isPresent = isPresent;
    }

    public int getID(){
        return ID;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public boolean getIsPresent(){
        return isPresent;
    }

}

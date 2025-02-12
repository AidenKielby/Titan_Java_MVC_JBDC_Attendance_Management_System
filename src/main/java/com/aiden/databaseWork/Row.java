package com.aiden.databaseWork;

public class Row {
    private int ID;
    private String firstName;
    private String lastName;
    private boolean isPresent;

    public Row(int ID, String firstName, String lastName, boolean isPresent){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isPresent = isPresent;
    }

    public Row(){
        this.ID = -1;
        this.firstName = null;
        this.lastName = null;
        this.isPresent = false;
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

    @Override
    public String toString() {
        return "(" + ID + ", " + firstName + ", " + lastName + ", " + isPresent + ")";
    }

    public void fromList(Object[] list){
        this.ID = Integer.parseInt(list[0].toString());
        this.firstName = (String) list[1];
        this.lastName = (String) list[2];
        this.isPresent = Boolean.parseBoolean(list[3].toString());
    }
}

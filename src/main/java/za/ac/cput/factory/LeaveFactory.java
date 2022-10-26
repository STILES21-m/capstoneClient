package za.ac.cput.factory;


import za.ac.cput.domain.Leaves;
/*
LEAVE_FACTORY.java
AUTHOR KULULO MANGCUNYANA
Student Number 219387117
Date 19 Sep 2022
 */

public class LeaveFactory {

    public  static Leaves build( Long daysOfLeave){

        return new Leaves.Builder()
                .setDaysOfLeave(daysOfLeave).build();

    }


}
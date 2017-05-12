package com.perfpr.draganddrop2;

/**
 * Created by Gmurray68w on 4/17/2017.
 */

public class JobScheduleCompleted {
    private String mWeekNumber;
    private String mJobDate;
    private String mJobTime;
    private String mEmployeeAssigned;
    private String mAuthor;

    public JobScheduleCompleted(String mWeekNumber, String mJobDate, String mJobTime, String
            mEmployeeAssigned, String mAuthor) {
        this.mWeekNumber = mWeekNumber;
        this.mJobDate = mJobDate;
        this.mJobTime = mJobTime;
        this.mEmployeeAssigned = mEmployeeAssigned;
        this.mAuthor = mAuthor;
    }

    public String getmWeekNumber() {
        return mWeekNumber;
    }

    public String getmJobDate() {
        return mJobDate;
    }

    public String getmJobTime() {
        return mJobTime;
    }

    public String getmEmployeeAssigned() {
        return mEmployeeAssigned;
    }

    public String getmAuthor() {
        return mAuthor;
    }
}

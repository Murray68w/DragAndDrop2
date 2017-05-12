package com.perfpr.draganddrop2;

/**
 * Created by Gmurray68w on 4/17/2017.
 */

public class Job {
    private String id;
    private String mCustomerName;
    private String mDate;
    private String mType;
    private String mLength;

    public Job(String id, String mCustomerName, String mDate, String mType, String mLength) {
        this.id = id;
        this.mCustomerName = mCustomerName;
        this.mDate = mDate;
        this.mType = mType;
        this.mLength = mLength;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getmCustomerName() {
        return mCustomerName;
    }

    public void setmCustomerName(String mCustomerName) {
        this.mCustomerName = mCustomerName;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmLength() {
        return mLength;
    }

    public void setmLength(String mLength) {
        this.mLength = mLength;
    }
}

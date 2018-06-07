package com.test.Models;

import java.sql.Timestamp;

/**
 * Created by Aaron on 6/7/2018.
 */
public class RecentActivity {
    String date;
    String activity;
    String dreamName;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDreamName() {
        return dreamName;
    }

    public void setDreamName(String dreamName) {
        this.dreamName = dreamName;
    }
}

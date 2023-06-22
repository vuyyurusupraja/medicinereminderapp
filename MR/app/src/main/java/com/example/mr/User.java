package com.example.mr;
public  class User {
    public String mname;
    public String date;
    public String time;
    public String dosage;
    public String days;
    public User() {
        //DataSnapshot.getValue(User.class);
    }
    public User(String mname, String date, String time,String dosage,String days) {
        this.mname = mname;
        this.date = date;
        this.time=time;
        this.dosage=dosage;
        this.days=days;
    }
    public String getmname() {
        return mname;
    }
    public String getdate() {
        return date;
    }
    public String gettime() {return time;}
    public String getdosage() {
        return dosage;
    }
    public String getdays() {
        return days;
    }
    public void setmname(String mname) {
        this.mname = mname;
    }
    public void setdate(String date) {
        this.date = date;
    }
    public void settime(String time) {
        this.time = time;
    }
    public void setdosage(String dosage) {
        this.dosage = dosage;
    }
    public void setdays(String days) {
        this.days = days;
    }

}

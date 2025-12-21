package com.First.pojo;

public class user {
private int userid;
    private String username;
    private String userpwd;
    private String usersex;
    private String  phonenumber;
    private String qqnumberl;

    public user() {
    }

    public user(int userid, String username, String userpwd, String phonenumber, String usersex, String qqnumberl) {
         this.userid = userid;
        this.username = username;
        this.userpwd = userpwd;
        this.phonenumber = phonenumber;
        this.usersex = usersex;
        this.qqnumberl = qqnumberl;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getQqnumberl() {
        return qqnumberl;
    }

    public void setQqnumberl(String qqnumberl) {
        this.qqnumberl = qqnumberl;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

}

package com.liyan.pojo;

public class College {
    private Integer collegeid;
    private String collegename;

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public College(Integer collegeid, String collegename) {
        this.collegeid = collegeid;
        this.collegename = collegename;
    }

    public College() {
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeid=" + collegeid +
                ", collegename='" + collegename + '\'' +
                '}';
    }
}

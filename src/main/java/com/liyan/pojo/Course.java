package com.liyan.pojo;

public class Course {
    private Integer courseid;

    private String coursename;

    private Integer teacherid;

    private String coursetime;

    private String classroom;

    private Integer courseweek;

    private String coursetype;

    private Integer collegeid;

    private Integer score;

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", teacherid=" + teacherid +
                ", coursetime='" + coursetime + '\'' +
                ", classroom='" + classroom + '\'' +
                ", courseweek=" + courseweek +
                ", coursetype='" + coursetype + '\'' +
                ", collegeid=" + collegeid +
                ", score=" + score +
                '}';
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Integer getCourseweek() {
        return courseweek;
    }

    public void setCourseweek(Integer courseweek) {
        this.courseweek = courseweek;
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Course(Integer courseid, String coursename, Integer teacherid, String coursetime, String classroom, Integer courseweek, String coursetype, Integer collegeid, Integer score) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.teacherid = teacherid;
        this.coursetime = coursetime;
        this.classroom = classroom;
        this.courseweek = courseweek;
        this.coursetype = coursetype;
        this.collegeid = collegeid;
        this.score = score;
    }

    public Course() {
    }
}
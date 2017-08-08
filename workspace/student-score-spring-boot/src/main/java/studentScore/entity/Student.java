package studentScore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Created by rsma on 26/07/2017.
 */
public class Student {

    private String id;
    private List<Course> courseList;
    private String name;
    private String idCardNum;
    private String email;
    private String phoneNum;
    private String nativePlace;

    public Student(){}

    public Student(String id,String name,List<Course> courseList) {
        this.id = id;
        this.name = name;
        this.courseList = courseList;
    }

    public Student(String name,List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String getId() {
        return id;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @JsonIgnore
    public double getAverageScore(){
        return ((double)getTotalScore())/courseList.size();
    }
    @JsonIgnore
    public int getTotalScore(){
        int totalScore = 0;
        for (Course course:courseList) {
            totalScore += course.getCourseScore();
        }
        return totalScore;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()){
            return false;
        }
        if(this.id.equals(((Student)obj).getId())){
            return true;
        }

        return false;
    }
}

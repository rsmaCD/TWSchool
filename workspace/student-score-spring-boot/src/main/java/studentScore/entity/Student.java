package studentScore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsma on 26/07/2017.
 */
public class Student implements Cloneable, Serializable{

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

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()){
            if(this.id.equals(((Student)obj).getId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student cloneStudent = (Student) super.clone();
        cloneStudent.courseList = new ArrayList<>();
        if(this.courseList != null) {
            for (Course simple : this.courseList) {
                cloneStudent.courseList.add(simple.clone());
            }

        }
        return cloneStudent;
    }
}

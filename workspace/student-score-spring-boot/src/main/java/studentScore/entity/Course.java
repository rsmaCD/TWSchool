package studentScore.entity;

import java.io.Serializable;

/**
 * Created by rsma on 29/07/2017.
 */
public class Course implements Cloneable, Serializable {

    private String courseName;
    private int courseScore;

    public Course (){}

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(int courseScore) {
        this.courseScore = courseScore;
    }

    public Course(String courseName, int courseScore){
        this.courseName = courseName;
        this.courseScore = courseScore;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.equals(obj))
            return true;
        if(obj.getClass() == this.getClass()){
            if(((Course)obj).getCourseName().equals(this.courseName)){
                if (((Course)obj).getCourseScore() == this.courseScore){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected Course clone() throws CloneNotSupportedException {
        Course course = (Course)super.clone();
        return course;
    }
}

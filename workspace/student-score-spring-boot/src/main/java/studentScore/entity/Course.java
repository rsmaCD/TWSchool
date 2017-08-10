package studentScore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by rsma on 29/07/2017.
 */
@Entity
public class Course implements Cloneable, Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
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

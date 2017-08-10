package studentScore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rsma on 29/07/2017.
 */
@Entity
public class Course implements Cloneable, Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",
            strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn (name="student_id")
    @JsonBackReference
    private Student student;
    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
    private int courseScore;

    public Course (){}

    public Course(String courseName, int courseScore, Student student) {
        this.courseName = courseName;
        this.courseScore = courseScore;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

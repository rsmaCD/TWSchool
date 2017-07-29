package studentScore;

import java.util.List;

/**
 * Created by rsma on 26/07/2017.
 */
public class Student {

    private String id;
    private List<Course> courseList;
    private String name;

    public Student(String id,String name,List<Course> courseList) {
        this.id = id;
        this.name = name;
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

    public double getAverageScore(){
        return ((double)getTotalScore())/courseList.size();
    }

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

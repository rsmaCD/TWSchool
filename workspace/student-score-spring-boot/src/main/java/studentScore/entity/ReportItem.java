package studentScore.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by rsma on 07/08/2017.
 */
public class ReportItem {

    private String stuName;
    private double averageScore;
    private int totalScore;
    private Map<String,Course> courseMap;

    public double getAverageScore() {
        //return ((double)getTotalScore())/courseMap.size();

        return averageScore;
    }

    public int getTotalScore() {
//        int totalScore = 0;
//        List<Course> courseList = new ArrayList<>(courseMap.values());
//        for (Course course:courseList) {
//            totalScore += course.getCourseScore();
//        }
//        return totalScore;
        return totalScore;
    }

    public Map<String, Course> getCourseMap() {
        return courseMap;
    }

    public String getStuName() {
        return stuName;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public void setCourseMap(Map<String, Course> courseMap) {
        this.courseMap = courseMap;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}

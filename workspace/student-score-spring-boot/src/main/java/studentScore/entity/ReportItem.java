package studentScore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
        return averageScore;
    }

    public int getTotalScore() {
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

    public void calAverageScore(){
        this.averageScore =  ((double)getTotalScore())/courseMap.size();
    }
    public void calTotalScore(){
        int totalScore = 0;
        for (Course course:new ArrayList<>(courseMap.values())) {
            totalScore += course.getCourseScore();
        }
        this.totalScore =  totalScore;
    }
}

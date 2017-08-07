package studentScore.entity;

import studentScore.global.Global;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by rsma on 26/07/2017.
 */
public class Reports {


    private List<Student> studentList = new ArrayList<>();

    public Reports() {

    }

    public String createReports(List<Student> studentList) {

        this.studentList = studentList;
        StringBuilder sb = new StringBuilder();
        if(studentList.size() == 0){
            return sb.append(Global.reportsHeadTemplate).append(String.format(Global.reportsTailTemplate,0.0,0.0)).toString();
        }

        sb.append(Global.reportsHeadTemplate)
                .append(formatStudentsScore())
                .append(String.format(Global.reportsTailTemplate,calcAverageScore(), calcMedianScore()));

        return sb.toString();
    }

    private String formatStudentsScore(){

        StringBuilder sb = new StringBuilder();
        for (Student student:studentList) {
            Map<String,Course> courseMap = student.getCourseList().stream().collect(Collectors.toMap(Course::getCourseName,(p)->p));
            sb.append(String.format(Global.reportsStudentAndScoreTemplate
                    ,student.getName()
                    ,courseMap.get(Global.mathCourseName).getCourseScore()
                    ,courseMap.get(Global.languageCourseName).getCourseScore()
                    ,courseMap.get(Global.englishCourseName).getCourseScore()
                    ,courseMap.get(Global.programCourseName).getCourseScore()
                    ,student.getAverageScore()
                    ,student.getTotalScore()));
        }
        return sb.toString();
    }

    private double calcMedianScore(){

        List<Integer> totalScoreList = new ArrayList<>();
        for (Student student:studentList) {
            totalScoreList.add(student.getTotalScore());
        }
        totalScoreList.sort(Comparator.naturalOrder());

        if(totalScoreList.size()%2 == 0){
            return ((double) (totalScoreList.get(totalScoreList.size()/2 - 1) + totalScoreList.get(totalScoreList.size()/2)))/2;

        }
        return ((double)totalScoreList.get(totalScoreList.size()/2));
    }

    private double calcAverageScore(){
        double totalScore = 0;
        for (Student student:studentList) {
            totalScore += student.getAverageScore();
        }
        return ((double) totalScore)/studentList.size();
    }
}

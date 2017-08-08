package studentScore.entity;

import studentScore.global.Global;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rsma on 08/08/2017.
 */
public class Reports {

    private List<ReportItem> reportItems = new ArrayList<>();
    private double medianScore = 0;
    private double averageScore = 0;

    public Reports(){}

    public List<ReportItem> getReportItems() {
        return reportItems;
    }

    public void setReportItems(List<ReportItem> reportItems) {
        this.reportItems = reportItems;
    }

    public double getMedianScore() {
        return medianScore;
    }

    public void setMedianScore(double medianScore) {
        this.medianScore = medianScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String createReportsWithTemplate(List<Student> studentList) {
        this.getReportItems(studentList);
        StringBuilder sb = new StringBuilder();
        if(studentList.size() == 0){
            return sb.append(Global.reportsHeadTemplate).append(String.format(Global.reportsTailTemplate,0.0,0.0)).toString();
        }

        this.calcMedianScore();
        this.calcAverageScore();
        sb.append(Global.reportsHeadTemplate)
                .append(formatStudentsScore())
                .append(String.format(Global.reportsTailTemplate, averageScore,medianScore));

        return sb.toString();
    }


    public void createReports(List<Student> studentList){

        this.getReportItems(studentList);
        this.calcMedianScore();
        this.calcAverageScore();
    }

    private void getReportItems(List<Student> studentList){
        for (Student student:studentList) {
            ReportItem reportItem = new ReportItem();
            reportItem.setStuName(student.getName());
            reportItem.setCourseMap(student.getCourseList().stream()
                    .collect(Collectors.toMap(Course::getCourseName, account -> account)));
            reportItem.calTotalScore();
            reportItem.calAverageScore();
            reportItems.add(reportItem);
        }
    }

    private String formatStudentsScore(){

        StringBuilder sb = new StringBuilder();
        for (ReportItem item:reportItems) {
            sb.append(String.format(Global.reportsStudentAndScoreTemplate
                    ,item.getStuName()
                    ,item.getCourseMap().get(Global.mathCourseName).getCourseScore()
                    ,item.getCourseMap().get(Global.languageCourseName).getCourseScore()
                    ,item.getCourseMap().get(Global.englishCourseName).getCourseScore()
                    ,item.getCourseMap().get(Global.programCourseName).getCourseScore()
                    ,item.getAverageScore()
                    ,item.getTotalScore()));
        }

        return sb.toString();
    }

    private void calcMedianScore(){

        List<Integer> totalScoreList = new ArrayList<>();

        for (ReportItem item:this.reportItems){
            totalScoreList.add(item.getTotalScore());
        }
        totalScoreList.sort(Comparator.naturalOrder());

        if(totalScoreList.size()%2 == 0){
            double i = totalScoreList.get(totalScoreList.size()/2 - 1);
            double j = totalScoreList.get(totalScoreList.size()/2);
            this.medianScore =  ((double) ( i + j))/2;
        }else {
            this.medianScore = ((double) totalScoreList.get(totalScoreList.size() / 2));
        }
    }

    private void calcAverageScore(){
        double totalScore = 0;
        for (ReportItem item:reportItems) {
            totalScore += item.getAverageScore();
        }
        averageScore = ((double) totalScore)/reportItems.size();
    }
}

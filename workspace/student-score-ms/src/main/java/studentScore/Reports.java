package studentScore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rsma on 26/07/2017.
 */
public class Reports {


    private List<Student> studentList = new ArrayList<>();
    private static StudentManager manager = StudentManager.getInstance();

    public Reports() {

    }

    public Reports(StudentManager manager) {
        this.manager = manager;
    }

    private void setStudentList(List<String> studentsId) {
        studentList = new ArrayList<>();
        for (String id:studentsId) {
            Student student = manager.getStudentById(id);
            if(student != null){
                studentList.add(student);
            }
        }
    }

    public String createReports(List<String> studentsId) {

        setStudentList(studentsId);
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
            sb.append(String.format(Global.reportsStudentAndScoreTemplate
                    ,student.getName()
                    ,student.getScore().getMathScore()
                    ,student.getScore().getLanguageScore()
                    ,student.getScore().getEnglishScore()
                    ,student.getScore().getProgrammingScore()
                    ,student.getScore().getAverageScore()
                    ,student.getScore().getTotalScore()));
        }
        return sb.toString();
    }

    private double calcMedianScore(){

        List<Integer> totalScoreList = new ArrayList<>();
        for (Student student:studentList) {
            totalScoreList.add(student.getScore().getTotalScore());
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
            totalScore += student.getScore().getAverageScore();
        }
        return ((double) totalScore)/studentList.size();
    }
}

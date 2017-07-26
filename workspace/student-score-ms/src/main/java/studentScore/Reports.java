package studentScore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rsma on 26/07/2017.
 */
public class Reports {


    private List<Student> studentList = new ArrayList<>();
    private final static String reportsHeadTemplate = "成绩单\n姓名|数学|语文|英语|编程|平均分|总分 \n========================\n";
    private final static String reportsTailTemplate = "========================\n全班总平均分：%.2f\n全班总分中位数：%.2f";
    public static StudentManager manager = StudentManager.getInstance();
    private final static String reportsStudentAndScoreTemplate = "%s|%d|%d|%d|%d|%.2f|%d\n";

    public Reports(List<String> studentsId) {
        for (String id:studentsId) {
            Student student = manager.getStudentById(id);
            if(student != null){
                studentList.add(student);
            }
        }
    }

    public String createReports() {

        StringBuilder sb = new StringBuilder();
        if(studentList.size() == 0){
            return sb.append(reportsHeadTemplate).append(String.format(reportsTailTemplate,0.0,0.0)).toString();
        }

        sb.append(reportsHeadTemplate)
                .append(formatStudentsScore())
                .append(String.format(reportsTailTemplate,calcAverageScore(), calcMedianScore()));

        return sb.toString();
    }

    private String formatStudentsScore(){
        StringBuilder sb = new StringBuilder();
        for (Student student:studentList) {
            sb.append(String.format(reportsStudentAndScoreTemplate
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

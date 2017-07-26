package studentScore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsma on 26/07/2017.
 */
public class Reports {


    private List<Student> studentList = new ArrayList<>();
    private final static String reportsHeadTemplate = "成绩单\n姓名|数学|语文|英语|编程|平均分|总分 \n========================\n";
    private final static String reportsTailTemplate = "========================\n全班总平均分：%.2f\n全班总分中位数：%d";
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

        if(studentList.size() == 0){
            return new StringBuilder().append(reportsHeadTemplate).append(String.format(reportsTailTemplate,0.0,0)).toString();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(reportsHeadTemplate);
        for (Student student:studentList) {
            sb.append(String.format(reportsStudentAndScoreTemplate
                    ,student.getName()
                    ,student.getScore().getMathScore()
                    ,student.getScore().getLanguageScore()
                    ,student.getScore().getEnglishScore()
                    ,student.getScore().getProgrammingScore()
                    ,student.getScore().getAverageScore()
                    ,student.getScore().getTotalScore()));
            sb.append(String.format(reportsTailTemplate,student.getScore().getAverageScore(),student.getScore().getTotalScore()));
        }

        return sb.toString();
    }
}

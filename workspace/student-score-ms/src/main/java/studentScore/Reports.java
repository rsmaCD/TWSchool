package studentScore;

import java.util.List;

/**
 * Created by rsma on 26/07/2017.
 */
public class Reports {


    private List<Student> studentList;
    private final static String reportsHeadTemplate = "成绩单\n姓名|数学|语文|英语|编程|平均分|总分 \n========================\n";
    private final static String reportsTailTemplate = "========================\n全班总平均分：0\n全班总分中位数：0";

    public Reports(List<Student> students) {
        this.studentList = students;
    }

    public String createReports() {

        return reportsHeadTemplate +
                reportsTailTemplate;
    }
}

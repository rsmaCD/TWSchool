package studentScore;

import java.util.List;

/**
 * Created by rsma on 26/07/2017.
 */
public class Reports {


    private List<Student> studentList;

    public Reports(List<Student> students) {
        this.studentList = students;
    }

    public String creatReports() {
        return "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分 \n" +
                "========================\n" +
                "========================\n" +
                "全班总平均分：0\n" +
                "全班总分中位数：0";
    }
}

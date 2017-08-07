package studentScore.service;

import studentScore.global.Global;
import studentScore.entity.StudentManager;
import studentScore.entity.Course;
import studentScore.entity.Reports;
import studentScore.entity.Student;

import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by rsma on 26/07/2017.
 */
public class StudentScoreService {

    private static StudentManager manager = StudentManager.getInstance();
    private Reports reports = new Reports();

    public StudentScoreService(){}

    public StudentScoreService(StudentManager manager, Reports reports) {
        this.manager = manager;
        this.reports = reports;
    }

    public Student createStudent(String createStudentInput) {
        try{
            String[] split = createStudentInput.split(",");
            Course mathCourse = new Course(Global.mathCourseName,Integer.valueOf(split[2]));
            Course languageCourse = new Course(Global.languageCourseName,Integer.valueOf(split[3]));
            Course englishCourse = new Course(Global.englishCourseName,Integer.valueOf(split[4]));
            Course programCourse = new Course(Global.programCourseName,Integer.valueOf(split[5]));
            Student student = manager.createStudent(split[1], split[0]
                    , asList(mathCourse,languageCourse,englishCourse,programCourse));
            return student;
        }catch (Exception e){
            return null;
        }
    }

    public String createReports(String createReportsInput) {

        return reports.createReports(manager.getStudentsByIdList(asList(createReportsInput
                .split(","))
                .stream()
                .collect(Collectors.toList())));
    }
}

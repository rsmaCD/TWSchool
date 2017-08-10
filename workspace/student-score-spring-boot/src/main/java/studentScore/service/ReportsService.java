package studentScore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentScore.entity.Reports;
import studentScore.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsma on 26/07/2017.
 */
@Service
public class ReportsService {

    @Autowired
    private StudentServiceInterface studentService;


    public ReportsService() {
    }

    public Reports createReportsAll(){
        List<Student> students = studentService.getAllStudents();
        Reports reports = new Reports();
        reports.createReports(students);
        return reports;
    }


    public Reports createReports(List<Student> studentList) throws CloneNotSupportedException {
        List<Student> students = new ArrayList<>();
        for (Student student:studentList) {
            students.add(studentService.getStudentById(student.getId()));
        }
        Reports reports = new Reports();
        reports.createReports(students);
        return reports;
    }

    public String createReportsWithTemplate(List<Student> studentList){
        Reports reports = new Reports();
        return reports.createReportsWithTemplate(studentList);
    }
}







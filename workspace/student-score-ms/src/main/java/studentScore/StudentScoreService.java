package studentScore;

import java.util.Arrays;
import java.util.stream.Collectors;

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
            Student student = manager.createStudent(split[1], split[0]
                    , new Score(Integer.valueOf(split[2])
                            , Integer.valueOf(split[3])
                            , Integer.valueOf(split[4])
                            , Integer.valueOf(split[5])));
            return student;
        }catch (Exception e){
            return null;
        }
    }

    public String createReports(String createReportsInput) {
        return reports.createReports(Arrays.asList(createReportsInput
                .split(","))
                .stream()
                .collect(Collectors.toList()));
    }
}

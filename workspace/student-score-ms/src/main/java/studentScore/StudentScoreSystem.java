package studentScore;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by rsma on 26/07/2017.
 */
public class StudentScoreSystem {

    private static StudentManager manager;
    private final static String createStudentInputTemplate = "[0-9]+,[a-zA-Z]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+";
    private final static String createReportsInputTemplate = "([0-9]+(,)?)*[0-9]+$";
    private Reports reports;

    public StudentScoreSystem(StudentManager manager,Reports reports){
        this.manager = manager;
        this.reports = reports;
    }

    public boolean createStudent(String createStudentInput) {
        if(createStudentInput.matches(createStudentInputTemplate)){
            String[] split = createStudentInput.split(",");
            boolean createStudentFlag = manager.createStudent(split[0],split[1]
                    ,new Score(Integer.valueOf(split[2])
                    ,Integer.valueOf(split[3])
                    ,Integer.valueOf(split[4])
                    ,Integer.valueOf(split[5])));
            return createStudentFlag;
        }
        return false;
    }

    public String createReports(String createReportsInput) {
        if(createReportsInput.matches(createReportsInputTemplate)){
            reports = new Reports(Arrays.asList(createReportsInput
                    .split(","))
                    .stream()
                    .collect(Collectors.toList()));
            return reports.createReports();
        }
        return null;
    }
}

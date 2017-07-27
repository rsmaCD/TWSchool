package studentScore;

/**
 * Created by rsma on 27/07/2017.
 */
public class StudentScoreApp {

    private final static String createStudentInputTemplate = "[0-9]+,[a-zA-Z]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+";
    private final static String createReportsInputTemplate = "([0-9]+(,)?)*[0-9]+$";
    private StudentScoreService studentScoreService = new StudentScoreService();

    public StudentScoreApp(){}

    public StudentScoreApp(StudentScoreService studentScoreService){
        this.studentScoreService = studentScoreService;
    }

    public boolean creatStudent(String createStudentInput) {
        if(createStudentInput.matches(createStudentInputTemplate)){
            return studentScoreService.createStudent(createStudentInput);
        }
        return false;
    }

    public String createReports(String createReportsInput) {
        if(createReportsInput.matches(createReportsInputTemplate)){
            return studentScoreService.createReports(createReportsInput);
        }
        return null;
    }
}

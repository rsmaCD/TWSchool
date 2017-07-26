package studentScore;

/**
 * Created by rsma on 26/07/2017.
 */
public class StudentScoreSystem {

    public static StudentManager manager = StudentManager.getInstance();
    private final static String createStudentInputTemplate = "[0-9]+,[a-zA-Z]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+";

    public boolean CreateStudent(String createStudentInput) {
        if(createStudentInput.matches(createStudentInputTemplate)){
            String input[] = createStudentInput.split(",");
            boolean createStudentFlag = manager.createStudent(input[0],input[1],new Score(Integer.valueOf(input[2])
                    ,Integer.valueOf(input[3])
                    ,Integer.valueOf(input[4])
                    ,Integer.valueOf(input[5])));
            return createStudentFlag;
        }
        return false;
    }
}

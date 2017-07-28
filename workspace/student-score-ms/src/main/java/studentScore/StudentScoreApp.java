package studentScore;

import java.util.Scanner;

/**
 * Created by rsma on 27/07/2017.
 */
public class StudentScoreApp {

    private String status = Global.MAIN_INTERFACE_STATUS;


    private StudentScoreService studentScoreService = new StudentScoreService();

    public StudentScoreApp() {}

    public StudentScoreApp(StudentScoreService studentScoreService) {
        this.studentScoreService = studentScoreService;
    }

    public String getStatus() {
        return status;
    }

    public void appInterface() {
        while (this.status != Global.EXIT_APP_STATUS){
            if(this.status.equals(Global.MAIN_INTERFACE_STATUS)){
                print(Global.mainInterfaceTemplate);
                mainInterface(getInput());
            }
            if(this.status.equals(Global.CREATE_STUDENT_INTERFACE_STATUS)){
                print(Global.createStudentNotice);
                String createStu = createStudentInterface(getInput());
                while (createStu.equals(Global.createStudentWarning)){
                    print(createStu);
                    createStu = createStudentInterface(getInput());
                }
                print(createStu);
            }
            if(this.status.equals(Global.CREATE_REPORTS_INTERFACE_STATUS)){
                print(Global.createReportsNotice);
                String createRep = createReportsInterface(getInput());
                while (createRep.equals(Global.createReportsWarning)){
                    print(createRep);
                    createRep = createReportsInterface(getInput());
                }
                print(createRep);
            }
        }
        System.exit(0);
    }

    public void changeStatus(String command) {

        if(command.equals(Global.jumpToMainInterfaceCommand)){
            this.status = Global.MAIN_INTERFACE_STATUS;
        }else if (command.equals(Global.jumpToCreateStudentInterfaceCommand)) {
            this.status = Global.CREATE_STUDENT_INTERFACE_STATUS;
        } else if (command.equals(Global.jumpToCreateReportsInterfaceCommand)) {
            this.status = Global.CREATE_REPORTS_INTERFACE_STATUS;
        } else if (command.equals(Global.exitAppCommand)) {
            this.status = Global.EXIT_APP_STATUS;
        }
    }

    public void mainInterface(String input) {
        if (input.matches(Global.mainInterfaceInputTemplate)) {
            changeStatus(input);
        }
    }

    public String createReportsInterface(String input) {
        if (input.matches(Global.createReportsInputTemplate)) {
            String reports = studentScoreService.createReports(input);
            if(reports != null){
                changeStatus(Global.jumpToMainInterfaceCommand);
                return reports;
            }
        }
        return Global.createReportsWarning;
    }

    public String createStudentInterface(String input) {
        if (input.matches(Global.createStudentInputTemplate)) {
            Student student = studentScoreService.createStudent(input);
            if (student != null) {
                changeStatus(Global.jumpToMainInterfaceCommand);
                return String.format(Global.createStudentSuccessNoticeTemplate, student.getName());
            }
        }
        return Global.createStudentWarning;
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        StudentScoreApp studentScoreApp = new StudentScoreApp();
        studentScoreApp.appInterface();
    }
}

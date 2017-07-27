package studentScore;

import java.util.Scanner;

/**
 * Created by rsma on 27/07/2017.
 */
public class StudentScoreApp {

    private final static String createStudentInputTemplate = "[a-zA-Z]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+";
    private final static String createReportsInputTemplate = "([0-9]+(,)?)*[0-9]+$";
    private final static String mainInterfaceInputTemplate = "[1|2|3]";
    private final static String mainInterfaceTemplate = "1. 添加学生 \n2. 生成成绩单 \n3. 退出\n请输入你的选择（1～3）：";
    private final static String createStudentNotice = "请输入学生信息（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交：";
    private final static String createStudentWarning = "请按正确的格式输入（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数）：";
    private final static String createReportsNotice = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    private final static String createReportsWarning = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    private final static String createStudentSuccessNoticeTemplate = "学生%s的成绩被添加";
    private final static String mainInterfaceStatus = "MAIN_INTERFACE_STATUS";
    private final static String createStudentInterfaceStatus = "CREATE_STUDENT_INTERFACE_STATUS";
    private final static String createReportsInterfaceStatus = "CREATE_REPORTS_INTERFACE_STATUS";
    private final static String exitAppStatus = "EXIT_APP_STATUS";
    private final static String jumpToCreateStudentInterfaceCommand = "1";
    private final static String jumpToCreateReportsInterfaceCommand = "2";
    private final static String exitAppCommand = "3";
    private final static String jumpToMainInterfaceCommand = "JUMP_TO_MAIN_STATUS";
    private String status = mainInterfaceStatus;


    private StudentScoreService studentScoreService = new StudentScoreService();

    public StudentScoreApp() {
    }

    public StudentScoreApp(String status) {
        this.status = status;
    }

    public StudentScoreApp(StudentScoreService studentScoreService) {
        this.studentScoreService = studentScoreService;
    }

    public void appInterface() {
        while (this.status != exitAppStatus){
            if(this.status.equals(mainInterfaceStatus)){
                print(mainInterfaceTemplate);
                mainInterface(getInput());
            }
            if(this.status.equals(createStudentInterfaceStatus)){
                print(createStudentNotice);
                String createStu = createStudentInterface(getInput());
                while (createStu.equals(createStudentWarning)){
                    print(createStu);
                    createStu = createStudentInterface(getInput());
                }
                print(createStu);
            }
            if(this.status.equals(createReportsInterfaceStatus)){
                print(createReportsNotice);
                String createRep = createReportsInterface(getInput());
                while (createRep.equals(createReportsWarning)){
                    print(createRep);
                    createRep = createReportsInterface(getInput());
                }
                print(createRep);
            }
        }
        System.exit(0);
    }

    public void changeStatus(String command) {

        if(command.equals(jumpToMainInterfaceCommand)){
            this.status = mainInterfaceStatus;
        }else if (command.equals(jumpToCreateStudentInterfaceCommand)) {
            this.status = createStudentInterfaceStatus;
        } else if (command.equals(jumpToCreateReportsInterfaceCommand)) {
            this.status = createReportsInterfaceStatus;
        } else if (command.equals(exitAppCommand)) {
            this.status = exitAppStatus;
        }
    }

    public void mainInterface(String input) {
        if (input.matches(mainInterfaceInputTemplate)) {
            changeStatus(input);
        }
    }

    public String createReportsInterface(String input) {
        if (input.matches(createReportsInputTemplate)) {
            String reports = studentScoreService.createReports(input);
            if(reports != null){
                changeStatus(jumpToMainInterfaceCommand);
                return reports;
            }
        }
        return createReportsWarning;
    }

    public String createStudentInterface(String input) {
        if (input.matches(createStudentInputTemplate)) {
            Student student = studentScoreService.createStudent(input);
            if (student != null) {
                changeStatus(jumpToMainInterfaceCommand);
                return String.format(createStudentSuccessNoticeTemplate, student.getName());
            }
        }
        return createStudentWarning;
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

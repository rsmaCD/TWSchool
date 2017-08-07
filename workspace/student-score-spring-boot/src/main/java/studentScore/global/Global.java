package studentScore.global;

/**
 * Created by rsma on 28/07/2017.
 */
public class Global {

    public final static String mainInterfaceTemplate = "1. 添加学生 \n2. 生成成绩单 \n3. 退出\n请输入你的选择（1～3）：\n";
    public final static String createStudentNotice = "请输入学生信息（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交：\n";
    public final static String createStudentWarning = "请按正确的格式输入（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数）：\n";
    public final static String createReportsNotice = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
    public final static String createReportsWarning = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
    public final static String createStudentSuccessNoticeTemplate = "学生%s的成绩被添加\n";

    public final static String reportsHeadTemplate = "成绩单\n姓名|数学|语文|英语|编程|平均分|总分 \n========================\n";
    public final static String reportsTailTemplate = "========================\n全班总平均分：%.2f\n全班总分中位数：%.2f\n";
    public final static String reportsStudentAndScoreTemplate = "%s|%d|%d|%d|%d|%.2f|%d\n";


    public final static String createStudentInputTemplate = "[a-zA-Z]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+";
    public final static String createReportsInputTemplate = "([0-9]+(,)?)*[0-9]+$";
    public final static String mainInterfaceInputTemplate = "[1|2|3]";


    public final static String MAIN_INTERFACE_STATUS = "MAIN_INTERFACE_STATUS";
    public final static String CREATE_STUDENT_INTERFACE_STATUS = "CREATE_STUDENT_INTERFACE_STATUS";
    public final static String CREATE_REPORTS_INTERFACE_STATUS = "CREATE_REPORTS_INTERFACE_STATUS";
    public final static String EXIT_APP_STATUS = "EXIT_APP_STATUS";

    public final static String jumpToCreateStudentInterfaceCommand = "1";
    public final static String jumpToCreateReportsInterfaceCommand = "2";
    public final static String exitAppCommand = "3";
    public final static String jumpToMainInterfaceCommand = "JUMP_TO_MAIN_STATUS";
    public final static String jumpToCreateReportsAfterErrInterfaceCommand = "JUMP_TO_CREATE_REPORTS_AFTER_ERR_STATUS";
    public final static String jumpToCreateStudentAfterErrInterfaceCommand = "JUMP_TO_CREATE_STUDENT_AFTER_ERR_STATUS";


    public final static String mathCourseName = "math";
    public final static String englishCourseName = "english";
    public final static String languageCourseName = "language";
    public final static String programCourseName = "program";

}

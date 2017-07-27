package studentScore;

import com.sun.javaws.exceptions.ExitException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by rsma on 27/07/2017.
 */
public class StudentScoreAppTest {

    StudentScoreService studentScoreService;
    private StudentScoreApp studentScoreApp;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final static String jumpToCreateStudentInterfaceCommand = "1";
    private final static String createStudentInterfaceStatus = "CREATE_STUDENT_INTERFACE_STATUS";
    private final static String mainInterfaceStatus = "MAIN_INTERFACE_STATUS";

    private final static String mainInterfaceTemplate = "1. 添加学生 \n2. 生成成绩单 \n3. 退出\n请输入你的选择（1～3）：";
    private final static String createStudentNotice = "请输入学生信息（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交：";
    private final static String createStudentWarning = "请按正确的格式输入（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数）：";
    private final static String createReportsNotice = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    private final static String createReportsWarning = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    private final static String createStudentSuccessNoticeTemplate = "学生%s的成绩被添加";

//    @Rule
//    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() throws Exception {
        studentScoreService = mock(StudentScoreService.class);
        studentScoreApp = new StudentScoreApp(studentScoreService);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void should_call_creatstudent_when_input_legal() throws Exception {
        studentScoreApp.createStudentInterface("Tom,111,2,2,2,2");
        verify(studentScoreService,times(1)).createStudent("Tom,111,2,2,2,2");
    }

    @Test
    public void should_call_creatreport_when_input_legal() throws Exception {
        studentScoreApp.createReportsInterface("111,111,110");
        verify(studentScoreService,times(1)).createReports("111,111,110");
    }

    @Test
    public void should_change_status_to_create_student() throws Exception {
        studentScoreApp.changeStatus(jumpToCreateStudentInterfaceCommand);
        assertEquals(createStudentInterfaceStatus,studentScoreApp.getStatus());
    }
    
    @Test
    public void should_not_change_status() throws Exception {
        studentScoreApp.changeStatus("12");
        assertEquals(mainInterfaceStatus,studentScoreApp.getStatus());
    }

    @Test
    public void integration_test() throws Exception {

        //exit.expectSystemExitWithStatus(0);

        //0.1、test error command
        inputString("11");
        //0.2、test create student command
        inputString("1");
        //1.1、test create student by error data
        inputString("Tom,111,2,2,2,a");
        //1.2、test create student by right data
        inputString("Tom,111,2,2,2,2");
        //2.1、test create reports by error data
        inputString("11,");
        //2.2、test create reports by right data
        inputString("111");
        //3
        inputString("3");

        studentScoreApp.appInterface();

        //verify(studentScoreService,times(1)).createStudent("Tom,111,2,2,2,2");


    }

    public void inputString(String string){
        ByteArrayInputStream in = new ByteArrayInputStream(string.getBytes());
        System.setIn(in);
    }
}

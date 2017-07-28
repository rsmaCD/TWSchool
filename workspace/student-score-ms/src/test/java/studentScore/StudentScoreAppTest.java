package studentScore;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;

/**
 * Created by rsma on 27/07/2017.
 */
public class StudentScoreAppTest {

    StudentScoreService studentScoreService;
    private StudentScoreApp studentScoreApp;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog().mute();


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
        studentScoreApp.changeStatus(Global.jumpToCreateStudentInterfaceCommand);
        assertEquals(Global.CREATE_STUDENT_INTERFACE_STATUS,studentScoreApp.getStatus());
    }
    
    @Test
    public void should_not_change_status() throws Exception {
        studentScoreApp.changeStatus("12");
        assertEquals(Global.MAIN_INTERFACE_STATUS,studentScoreApp.getStatus());
    }

    @Test
    public void integration_test() throws Exception {

        exit.expectSystemExitWithStatus(0);
        System.out.print("132323");

//        //0.1、test error command
//        systemInMock.provideLines("11");
//        //0.2、test create student command
//        systemInMock.provideLines("1");
//        //1.1、test create student by error data
//        systemInMock.provideLines("111");
//        //1.2、test create student by right data
//        systemInMock.provideLines("tom,111,1,1,1,1");
//        //2.1、test create reports by error data
//        systemInMock.provideLines("2");
//        //2.2、test create reports by right data
//        systemInMock.provideLines("111");
        //3
        systemInMock.provideLines("4");
        assertEquals(Global.mainInterfaceTemplate+"11",systemOutRule.getLog());
        systemInMock.provideLines("3");
        studentScoreApp.appInterface();


        //verify(studentScoreService,times(1)).createStudent("Tom,111,2,2,2,2");


    }
}

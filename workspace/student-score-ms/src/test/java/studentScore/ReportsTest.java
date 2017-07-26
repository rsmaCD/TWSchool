package studentScore;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 26/07/2017.
 */
public class ReportsTest {


    @Test
    public void get_empty_reports_when_input_no_student_id() throws Exception {
        //Given
        Reports reports = new Reports(Arrays.asList());
        String emptyReports = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分 \n" +
                "========================\n" +
                "========================\n" +
                "全班总平均分：0\n" +
                "全班总分中位数：0";
        //When
        String  actual = reports.creatReports();
        //Then
        assertEquals(emptyReports,actual);

    }
}

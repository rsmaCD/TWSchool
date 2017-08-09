package studentScore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


//@Configuration
//@ComponentScan(useDefaultFilters = true,
//        includeFilters = {@ComponentScan.Filter(
//                type = FilterType.ASSIGNABLE_TYPE, classes = {CROSSFilter.class})})
//@EnableAutoConfiguration
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
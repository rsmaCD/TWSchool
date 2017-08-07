package refactor;

import org.junit.Test;
import studentScore.App;
import studentScore.refactor.io.FileIO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by rsma on 29/07/2017.
 */
public class AppTest {

    private String fileNameOutput = "output.txt";
    private String fileNameOutputTemplate = "outputTemplate.txt";

    @Test
    public void should_get_output_equal_to_outputtemplate() throws Exception {
        App app = new App(new FileIO());
        app.Start();
        app.Run();

        List<String> output = new ArrayList<>();
        List<String> outputTemplate = new ArrayList<>();

        try {
            output = Files.lines(Paths.get(this.fileNameOutput), StandardCharsets.UTF_8)
                    .collect(java.util.stream.Collectors.toList());

            outputTemplate = Files.lines(Paths.get(this.fileNameOutputTemplate), StandardCharsets.UTF_8)
                    .collect(java.util.stream.Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(output,outputTemplate);
    }
}

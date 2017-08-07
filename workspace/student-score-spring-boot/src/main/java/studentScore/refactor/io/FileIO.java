package studentScore.refactor.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;

/**
 * Created by rsma on 29/07/2017.
 */
public class FileIO implements IOInterface {

    private List<String> inputList = new ArrayList<>();
    private int location = -1;
    private String fileNameInput = "input.txt";
    private String fileNameTarget = "output.txt";

    @Override
    public void Start() {
        try {
            this.inputList = Files.lines(Paths.get(this.fileNameInput), StandardCharsets.UTF_8)
                    .collect(java.util.stream.Collectors.toList());
            Files.deleteIfExists(Paths.get(this.fileNameTarget));
            Files.createFile(Paths.get(this.fileNameTarget));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getInput() {
        this.location++;
        return this.inputList.get(this.location);
    }

    @Override
    public void output(String output) {
        try {
            Files.write(Paths.get(this.fileNameTarget),output.getBytes(), APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exit() {

    }
}

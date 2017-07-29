package studentScore.refactor.io;

import java.util.Scanner;

/**
 * Created by rsma on 28/07/2017.
 */
public class ConsoleIO implements IOInterface {

    @Override
    public void Start() {}

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void output(String output) {
        System.out.println(output);
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}

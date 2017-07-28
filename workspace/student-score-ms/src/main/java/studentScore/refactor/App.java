package studentScore.refactor;

import studentScore.refactor.io.ConsoleIO;
import studentScore.refactor.io.IOInterface;
import studentScore.refactor.status.*;

/**
 * Created by rsma on 28/07/2017.
 */
public class App {

    private IOInterface ioInterface;
    private MainStatus mainStatus;
    private CreateStudentStatus createStudentStatus;
    private CreateReportsStatus createReportsStatus;
    private ExitStatus exitStatus;

    private Status status;

    public App(IOInterface ioInterface){
        this.ioInterface = ioInterface;
        this.mainStatus = new MainStatus(this,this.ioInterface);
        this.createReportsStatus = new CreateReportsStatus(this,this.ioInterface);
        this.createStudentStatus = new CreateStudentStatus(this,this.ioInterface);
        this.exitStatus = new ExitStatus(this,this.ioInterface);
        this.status = this.mainStatus;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MainStatus getMainStatus() {
        return mainStatus;
    }

    public ExitStatus getExitStatus() {
        return exitStatus;
    }

    public CreateReportsStatus getCreateReportsStatus() {
        return createReportsStatus;
    }

    public CreateStudentStatus getCreateStudentStatus() {
        return createStudentStatus;
    }

    public void run() {
        this.status.input();
    }

    public static void main(String[] args) {
        App app = new App(new ConsoleIO());
        app.run();
    }
}

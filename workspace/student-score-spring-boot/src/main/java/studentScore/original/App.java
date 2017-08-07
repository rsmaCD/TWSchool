package studentScore.original;

import studentScore.original.io.IOInterface;
import studentScore.original.status.*;

/**
 * Created by rsma on 28/07/2017.
 */
public class App {

    private IOInterface ioInterface;
    private MainStatus mainStatus;
    private CreateStudentStatus createStudentStatus;
    private CreateReportsStatus createReportsStatus;
    private ExitStatus exitStatus;
    private CreateReportsAfterErrStatus createReportsAfterErrStatus;
    private CreateStudentAfterErrStatus createStudentAfterErrStatus;

    private Status status;

    public App(IOInterface ioInterface){
        this.ioInterface = ioInterface;
        this.mainStatus = new MainStatus(this,this.ioInterface);
        this.createReportsStatus = new CreateReportsStatus(this,this.ioInterface);
        this.createStudentStatus = new CreateStudentStatus(this,this.ioInterface);
        this.exitStatus = new ExitStatus(this,this.ioInterface);
        this.createReportsAfterErrStatus = new CreateReportsAfterErrStatus(this,this.ioInterface);
        this.createStudentAfterErrStatus = new CreateStudentAfterErrStatus(this,this.ioInterface);
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

    public CreateReportsAfterErrStatus getCreateReportsAfterErrStatus() {
        return createReportsAfterErrStatus;
    }

    public CreateStudentAfterErrStatus getCreateStudentAfterErrStatus() {
        return createStudentAfterErrStatus;
    }

    public void Run() {
        this.status.input();
    }

    public void Start(){
        this.ioInterface.Start();
    }

    public static void main(String[] args) {
//        App app = new App(new ConsoleIO());
//        app.Start();
//        app.Run();
    }
}

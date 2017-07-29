package studentScore.refactor.status;

import studentScore.Global;
import studentScore.Student;
import studentScore.StudentScoreService;
import studentScore.refactor.App;
import studentScore.refactor.io.IOInterface;

/**
 * Created by rsma on 29/07/2017.
 */
public class CreateStudentAfterErrStatus implements Status {

    IOInterface ioInterface;
    App app;
    private StudentScoreService studentScoreService = new StudentScoreService();

    public CreateStudentAfterErrStatus(App app,IOInterface ioInterface){
        this.app = app;
        this.ioInterface = ioInterface;
    }

    @Override
    public void input() {
        ioInterface.output(Global.createStudentWarning);
        String input = ioInterface.getInput();
        if(!input.matches(Global.createStudentInputTemplate)){
            input();
        }else {
            Student student = studentScoreService.createStudent(input);
            if (student != null) {
                ChangeStatus.changeStatus(app, Global.jumpToMainInterfaceCommand);
                ioInterface.output(String.format(Global.createStudentSuccessNoticeTemplate, student.getName()));
                app.Run();
            } else {
                input();
            }
        }
    }
}

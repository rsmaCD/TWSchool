package studentScore.original.status;

import studentScore.global.Global;
import studentScore.entity.Student;
import studentScore.service.StudentScoreService;
import studentScore.original.App;
import studentScore.global.Validate;
import studentScore.original.io.IOInterface;

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
        if(!Validate.validateCreateStudentInput(input)){
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

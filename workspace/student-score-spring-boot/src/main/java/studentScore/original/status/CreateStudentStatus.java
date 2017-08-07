package studentScore.original.status;

import studentScore.global.Global;
import studentScore.entity.Student;
import studentScore.service.StudentScoreService;
import studentScore.original.App;
import studentScore.global.Validate;
import studentScore.original.io.IOInterface;

/**
 * Created by rsma on 28/07/2017.
 */
public class CreateStudentStatus implements Status{

    IOInterface ioInterface;
    App app;
    private StudentScoreService studentScoreService = new StudentScoreService();

    public CreateStudentStatus(App app,IOInterface ioInterface){
        this.app = app;
        this.ioInterface = ioInterface;
    }

    @Override
    public void input() {
        ioInterface.output(Global.createStudentNotice);
        String input = ioInterface.getInput();
        if(!Validate.validateCreateStudentInput(input)){
            ChangeStatus.changeStatus(app,Global.jumpToCreateStudentAfterErrInterfaceCommand);
            app.Run();
        }else {
            Student student = studentScoreService.createStudent(input);
            if (student != null) {
                ChangeStatus.changeStatus(app, Global.jumpToMainInterfaceCommand);
                ioInterface.output(String.format(Global.createStudentSuccessNoticeTemplate, student.getName()));
                app.Run();
            } else {
                ChangeStatus.changeStatus(app, Global.jumpToCreateStudentAfterErrInterfaceCommand);
                app.Run();
            }
        }
    }
}

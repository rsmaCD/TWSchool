package studentScore.original.status;

import studentScore.global.Global;
import studentScore.service.StudentScoreService;
import studentScore.original.App;
import studentScore.global.Validate;
import studentScore.original.io.IOInterface;

/**
 * Created by rsma on 28/07/2017.
 */
public class CreateReportsStatus implements Status {

    IOInterface ioInterface;
    App app;
    private StudentScoreService studentScoreService = new StudentScoreService();

    public CreateReportsStatus(App app, IOInterface ioInterface) {
        this.app = app;
        this.ioInterface = ioInterface;
    }

    @Override
    public void input()  {
        ioInterface.output(Global.createReportsNotice);
        String input = ioInterface.getInput();
        if (!Validate.validateCreateReportsInput(input)) {
            ChangeStatus.changeStatus(app, Global.jumpToCreateReportsAfterErrInterfaceCommand);
            app.Run();
        } else {
            String reports = studentScoreService.createReports(input);
            ChangeStatus.changeStatus(app, Global.jumpToMainInterfaceCommand);
            ioInterface.output(reports);
            app.Run();
        }
    }
}

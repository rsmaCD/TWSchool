package studentScore.original.status;

import studentScore.global.Global;
import studentScore.service.StudentScoreService;
import studentScore.original.App;
import studentScore.global.Validate;
import studentScore.original.io.IOInterface;

/**
 * Created by rsma on 29/07/2017.
 */
public class CreateReportsAfterErrStatus implements Status {

    IOInterface ioInterface;
    App app;
    private StudentScoreService studentScoreService = new StudentScoreService();

    public CreateReportsAfterErrStatus(App app, IOInterface ioInterface) {
        this.app = app;
        this.ioInterface = ioInterface;
    }

    @Override
    public void input() {
        ioInterface.output(Global.createReportsWarning);
        String input = ioInterface.getInput();
        if (!Validate.validateCreateReportsInput(input)) {
            input();
        } else {
            String reports = studentScoreService.createReports(input);
            ChangeStatus.changeStatus(app, Global.jumpToMainInterfaceCommand);
            ioInterface.output(reports);
            app.Run();
        }

    }
}

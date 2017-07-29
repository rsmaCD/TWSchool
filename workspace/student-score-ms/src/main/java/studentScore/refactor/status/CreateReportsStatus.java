package studentScore.refactor.status;

import studentScore.Global;
import studentScore.StudentScoreService;
import studentScore.refactor.App;
import studentScore.refactor.Validate;
import studentScore.refactor.io.IOInterface;

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
    public void input() {
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

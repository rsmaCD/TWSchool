package studentScore.refactor.status;

import studentScore.Global;
import studentScore.refactor.App;
import studentScore.refactor.io.IOInterface;

/**
 * Created by rsma on 28/07/2017.
 */
public class MainStatus implements Status{

    IOInterface ioInterface;
    App app;

    public MainStatus(App app,IOInterface ioInterface){
        this.app = app;
        this.ioInterface = ioInterface;
    }

    @Override
    public void input() {
        ioInterface.output(Global.mainInterfaceTemplate);
        String command = ioInterface.getInput();
        if(!command.matches(Global.mainInterfaceInputTemplate)){
            input();
        }
        ChangeStatus.changeStatus(app,command);
        app.run();
    }
}

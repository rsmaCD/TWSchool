package studentScore.refactor.status;

import studentScore.refactor.App;
import studentScore.refactor.io.IOInterface;

/**
 * Created by rsma on 28/07/2017.
 */
public class ExitStatus implements Status{

    IOInterface ioInterface;
    App app;

    public ExitStatus(App app, IOInterface ioInterface){
        this.app = app;
        this.ioInterface = ioInterface;
    }

    @Override
    public void input() {
        ioInterface.exit();
    }
}

package studentScore.original.status;

import studentScore.original.App;
import studentScore.original.io.IOInterface;

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

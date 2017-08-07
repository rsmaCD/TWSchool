package studentScore.original.status;

import studentScore.global.Global;
import studentScore.original.App;
import studentScore.global.Validate;
import studentScore.original.io.IOInterface;

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
        if(!Validate.validateMainInterfaceInput(command)){
            input();
        }
        ChangeStatus.changeStatus(app,command);
        app.Run();
    }
}

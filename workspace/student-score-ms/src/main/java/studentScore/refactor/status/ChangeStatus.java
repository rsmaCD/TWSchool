package studentScore.refactor.status;

import studentScore.Global;
import studentScore.refactor.App;

/**
 * Created by rsma on 28/07/2017.
 */
public class ChangeStatus {

    public static void changeStatus(App app, String command){
        if(command.equals(Global.jumpToMainInterfaceCommand)){
            app.setStatus(app.getMainStatus());
        }else if (command.equals(Global.jumpToCreateStudentInterfaceCommand)) {
            app.setStatus(app.getCreateStudentStatus());
        } else if (command.equals(Global.jumpToCreateReportsInterfaceCommand)) {
            app.setStatus(app.getCreateReportsStatus());
        } else if (command.equals(Global.exitAppCommand)) {
            app.setStatus(app.getExitStatus());
        }
    }
}

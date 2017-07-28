package studentScore.refactor;

import studentScore.Global;

/**
 * Created by rsma on 28/07/2017.
 */
public class Validate {

    public boolean validateCreateStudentInput(String createStudentInput){
        return createStudentInput.matches(Global.createStudentInputTemplate);
    }

    public boolean validateCreateReportsInput(String createReportsInput){
        return createReportsInput.matches(Global.createReportsInputTemplate);
    }

    public boolean validateMainInterfaceInput(String mainInterfaceInput){
        return mainInterfaceInput.matches(Global.mainInterfaceInputTemplate);
    }

}

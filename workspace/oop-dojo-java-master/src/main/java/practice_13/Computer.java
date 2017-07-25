package practice_13;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by rsma on 24/07/2017.
 */
public class Computer implements X{

    private String name = "the Machine";

    @Override
    public void inform(String str) {
        System.out.print(String.format(notifyInformationTemplate,this.name,str));
    }

    public void myAddObserver(KClass kclass) {
        kclass.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        inform((String)arg);
    }
}

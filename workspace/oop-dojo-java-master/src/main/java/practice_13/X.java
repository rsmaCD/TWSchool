package practice_13;

import java.util.Observer;

/**
 * Created by rsma on 24/07/2017.
 */
public interface X extends Observer{
    final String notifyInformationTemplate = "I am %s. I know %s";
    public void inform(String str) ;

}

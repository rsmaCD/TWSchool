package practice_13;

import java.util.Observer;

/**
 * Created by rsma on 24/07/2017.
 */
public interface X extends Observer{
    public void inform(String str) ;

    public void myAddObserver(KClass kclass);

}

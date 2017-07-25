package practice_13;

import java.util.List;
import java.util.Observable;

/**
 * Created by rsma on 24/07/2017.
 */
public class Teacher extends Person implements X{

    private final String teachNoClassIntroduceTemplate = " I am a Teacher. I teach No Class.";
    private final String teachClassesIntroduceTemplate = " I am a Teacher. I teach Class %s.";
    private List<KClass> kClassList = null;

    public Teacher(String id, String name, int age, List<KClass> kclass) {
        super(id,name, age);
        this.kClassList = kclass;
        myAddObserver();

    }

    public Teacher(String id, String name, int age) {
        super(id,name,age);
    }

    @Override
    public String introduce() {
        if(this.kClassList != null){

            return super.introduce() + String.format(teachClassesIntroduceTemplate,getTeachClassesNum());
        }
        return super.introduce() + teachNoClassIntroduceTemplate;
    }

    private String getTeachClassesNum(){
        String kClassNumStr = "";
        for (int i = 0; i < kClassList.size();i++) {
            kClassNumStr += kClassList.get(i).getClassNum() + ", ";
        }
        return kClassNumStr.substring(0,kClassNumStr.length() - 2);
    }

    public boolean isTeaching(Student student) {
        if(this.kClassList.contains(student.getKClass())){
            return true;
        }
        return false;
    }


    @Override
    public void inform(String str) {
        System.out.print(String.format(notifyInformationTemplate,this.name,str));
    }

    public void myAddObserver() {
        for (KClass kClass: kClassList) {
            kClass.addObserver(this);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        inform((String)arg);
    }
}

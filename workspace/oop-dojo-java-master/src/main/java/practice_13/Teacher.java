package practice_13;

import java.util.List;

/**
 * Created by rsma on 24/07/2017.
 */
public class Teacher extends Person implements X{

    private List<KClass> kClassList = null;

    public Teacher(String id, String name, int age, List<KClass> kclass) {
        super(id,name, age);
        this.kClassList = kclass;
    }

    public Teacher(String id, String name, int age) {
        super(id,name,age);
    }

    public Teacher() {
        super();
    }

    @Override
    public String introduce() {
        if(this.kClassList != null){
            String kClassNumStr = "";
            for (int i = 0; i < kClassList.size();i++) {
                kClassNumStr += kClassList.get(i).getClassNum() + ", ";
            }
            return super.introduce() + " I am a Teacher. I teach Class " + kClassNumStr.substring(0,kClassNumStr.length() - 2) + ".";
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public boolean isTeaching(Student student) {
        if(this.kClassList.contains(student.getKClass())){
            return true;
        }
        return false;
    }

    @Override
    public void informAssignLeader(Student student, KClass kClass) {
        System.out.println("I am "+ this.name + ". I know "+ student.getName() +" has joined Class "+ kClass.getClassNum() +".");
    }

    @Override
    public void informAppendMember(Student student, KClass kClass) {
        System.out.println("I am "+ this.name + ". I know "+ student.getName() +" has become Leader of  Class "+ kClass.getClassNum() +".");
    }
}

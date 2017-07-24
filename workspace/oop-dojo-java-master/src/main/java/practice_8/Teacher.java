package practice_8;

/**
 * Created by rsma on 24/07/2017.
 */
public class Teacher extends Person{

    private KClass kclass = null;

    public Teacher(String name, int age, KClass kclass) {
        super(name, age);
        this.kclass = kclass;
    }

    public Teacher(String name, int age) {
        super(name,age);
    }

    @Override
    public String introduce() {
        if(this.kclass != null){
            return super.introduce() + " I am a Teacher. I teach Class " + this.kclass.getClassNum() + ".";
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }
}

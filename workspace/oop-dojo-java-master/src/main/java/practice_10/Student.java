package practice_10;

/**
 * Created by rsma on 24/07/2017.
 */
public class Student extends Person {
    private KClass kclass;

    public Student(String name, int age, KClass kclass) {
        super(name,age);
        this.kclass = kclass;
    }

    public Student(String name, int age) {
        super(name,age);
    }

    @Override
    public String introduce() {
        if(this.kclass.getLeader() == this){

            return super.introduce() + " I am a Student. I am Leader of Class " + this.kclass.getClassNum() + ".";
        }
        return super.introduce() + " I am a Student. I am at Class " + this.kclass.getClassNum() + ".";
    }

    public KClass getKClass() {
        return this.kclass;
    }

    public String getName() {
        return this.name;
    }

    public void setKClass(KClass KClass) {
        this.kclass = KClass;
    }
}

package practice_8;

/**
 * Created by rsma on 24/07/2017.
 */
public class Student extends Person {
    private KClass kclass;

    public Student(String name, int age, KClass kclass) {
        super(name,age);
        this.kclass = kclass;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Student. I am at Class " + this.kclass.getClassNum() + ".";
    }

    public KClass getKClass() {
        return this.kclass;
    }

    public String getName() {
        return this.name;
    }
}

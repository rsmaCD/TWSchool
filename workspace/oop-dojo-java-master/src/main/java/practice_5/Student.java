package practice_5;

/**
 * Created by rsma on 24/07/2017.
 */
public class Student extends Person{

    private int kclass;
    private String name;
    private int age;

    public Student(String name, int age, int kclass) {
        super(name,age);
        this.kclass = kclass;
    }

    @Override
    public String introduce() {
        return super.basicIntroduce() + " I am a Student. I am at Class " + this.kclass + ".";
    }
}

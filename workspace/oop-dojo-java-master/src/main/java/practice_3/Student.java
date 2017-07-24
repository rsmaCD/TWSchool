package practice_3;

import practice_2.Person;

/**
 * Created by rsma on 24/07/2017.
 */
public class Student extends Person {
    private int kclass;
    private String name;
    private int age;

    public Student(String name, int age, int kclass) {
        super(name,age);
        this.kclass = kclass;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Student. I am at Class " + this.kclass + ".";
    }
}

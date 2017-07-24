package practice_3;

/**
 * Created by rsma on 24/07/2017.
 */
public class Student extends Person{
    private int kclass;

    public Student(String name, int age, int kclass) {
        super(name,age);
        this.kclass = kclass;
    }

    @Override
    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age +" years old. I am a Student. I am at Class " + this.kclass + ".";
    }
}

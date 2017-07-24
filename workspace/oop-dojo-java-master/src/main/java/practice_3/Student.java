package practice_3;

import practice_2.Person;

/**
 * Created by rsma on 24/07/2017.
 */
public class Student{
    private int kclass;
    private String name;
    private int age;

    public Student(String name, int age, int kclass) {
        this.name = name;
        this.age = age;
        this.kclass = kclass;
    }

    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age +" years old. I am a Student. I am at Class " + this.kclass + ".";
    }
}

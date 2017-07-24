package practice_9;

/**
 * Created by rsma on 24/07/2017.
 */
public class Person {
    protected String id;
    protected int age;
    protected String name;

    public Person(String id,String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return "My name is " + this.name + ". I am " + this.age + " years old.";
    }
}

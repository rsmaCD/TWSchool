package practice_13;

/**
 * Created by rsma on 24/07/2017.
 */
public class Person {

    protected String id;
    protected int age;
    protected String name;
    private final String personIntroduceTemple = "My name is %s. I am %d years old.";

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format(personIntroduceTemple,this.name,this.age);
    }
}

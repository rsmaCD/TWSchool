package practice_5;

/**
 * Created by rsma on 24/07/2017.
 */
public class Worker extends Person{
    private String name;
    private int age;

    public Worker(String name, int age) {
        super(name,age);
    }

    @Override
    public String introduce() {
        return super.basicIntroduce() + " I am a Worker. I have a job.";
    }
}

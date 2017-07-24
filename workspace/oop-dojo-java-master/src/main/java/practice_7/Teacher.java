package practice_7;

/**
 * Created by rsma on 24/07/2017.
 */
public class Teacher extends Person{


    private int kclass = -1;

    public Teacher(String name, int age, int kclass) {
        super(name,age);
        this.kclass = kclass;
    }

    public Teacher(String name, int age) {
        super(name,age);
    }

    @Override
    public String introduce() {
        if(this.kclass != -1){

            return super.introduce() + " I am a Teacher. I teach Class " + this.kclass + ".";
        }

        return super.introduce() + " I am a Teacher. I teach No Class.";
    }
}

package practice_9;

/**
 * Created by rsma on 24/07/2017.
 */
public class KClass {

    private int number;
    private Student leader;

    public KClass(int num) {
        this.number = num;
    }

    public int getClassNum() {
        return this.number;
    }


    public void assignLeader(Student student) {
        this.leader = student;
    }

    public Student getLeader() {
        return this.leader;
    }
}

package practice_11;

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
        if(student.getKClass() != this){
            System.out.print("It is not one of us.");
        }else{

            this.leader = student;
        }
    }

    public Student getLeader() {
        return this.leader;
    }

    public void appendMember(Student student){
        student.setKClass(this);
    }
}

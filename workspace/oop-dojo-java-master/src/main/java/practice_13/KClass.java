package practice_13;

import java.util.Observable;

/**
 * Created by rsma on 24/07/2017.
 */
public class KClass extends Observable {

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
            String str = student.getName() + " become Leader of Class " + this.getClassNum() + ".";
            this.setChanged();
            this.notifyObservers(str);
        }
    }

    public Student getLeader() {
        return this.leader;
    }

    public void appendMember(Student student){
        student.setKClass(this);
        String str = student.getName() + " has joined Class " + this.getClassNum() + ".";
        this.setChanged();
        this.notifyObservers(str);
    }

    public boolean isIn(Student student){
        if(student.getKClass() == this){
            return true;
        }
        return false;
    }
}

package practice_13;

import java.util.Observable;

/**
 * Created by rsma on 24/07/2017.
 */
public class KClass extends Observable {

    private int number;
    private Student leader;
    private final String assignLeaderFailTemplate = "It is not one of us.";
    private final String notifyAssignLeaderSuccessTemplate = " become Leader of Class %d.";
    private final String notifyAppendMemberSuccessTemplate = " has joined Class %d.";


    public KClass(int num) {
        this.number = num;
    }

    public int getClassNum() {
        return this.number;
    }


    public void assignLeader(Student student) {
        if(student.getKClass() != this){
            System.out.print(assignLeaderFailTemplate);
        }else{
            this.leader = student;
            String event = student.getName() + String.format(notifyAssignLeaderSuccessTemplate,this.number);
            myNotifyObservers(event);
        }
    }

    public Student getLeader() {
        return this.leader;
    }

    public void appendMember(Student student){
        student.setKClass(this);
        String event = student.getName() + String.format(notifyAppendMemberSuccessTemplate,this.number);
        myNotifyObservers(event);
    }

    public void myNotifyObservers(String event) {
        this.setChanged();
        this.notifyObservers(event);
    }

    public boolean isIn(Student student){
        if(student.getKClass() == this){
            return true;
        }
        return false;
    }
}

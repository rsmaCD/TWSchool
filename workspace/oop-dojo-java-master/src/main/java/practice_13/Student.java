package practice_13;

/**
 * Created by rsma on 24/07/2017.
 */
public class Student extends Person {

    private final String notLeaderStudentIntroduceTemplate = " I am a Student. I am at Class %d.";
    private final String leaderStudentIntroduceTemplate = " I am a Student. I am Leader of Class %d.";
    private KClass kclass;

    public Student(String id, String name, int age, KClass kclass) {
        super(id,name,age);
        this.kclass = kclass;
    }

    public Student(String id, String name, int age) {
        super(id,name,age);
    }

    @Override
    public String introduce() {
        if(this.kclass.getLeader() == this){
            return super.introduce() + String.format(leaderStudentIntroduceTemplate,this.kclass.getClassNum());
        }
        return super.introduce() + String.format(notLeaderStudentIntroduceTemplate,this.kclass.getClassNum());
    }

    public KClass getKClass() {
        return this.kclass;
    }

    public String getName() {
        return this.name;
    }

    public void setKClass(KClass KClass) {
        this.kclass = KClass;
    }
}

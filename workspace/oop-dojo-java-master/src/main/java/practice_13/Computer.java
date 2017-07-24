package practice_13;

/**
 * Created by rsma on 24/07/2017.
 */
public class Computer implements X{

    private String name;

    @Override
    public void informAssignLeader(Student student, KClass kClass) {
        System.out.println("I am "+ this.name + ". I know "+ student.getName() +" has joined Class "+ kClass.getClassNum() +".");
    }

    @Override
    public void informAppendMember(Student student, KClass kClass) {
        System.out.println("I am "+ this.name + ". I know "+ student.getName() +" has become Leader of  Class "+ kClass.getClassNum() +".");
    }
}

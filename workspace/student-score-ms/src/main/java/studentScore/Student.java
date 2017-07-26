package studentScore;

/**
 * Created by rsma on 26/07/2017.
 */
public class Student {

    private String id;
    private Score score;
    private String name;

    public Student(String id,String name,Score score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public Score getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}

package studentScore;

/**
 * Created by rsma on 29/07/2017.
 */
public class Course {

    private String courseName;
    private int courseScore;

    public String getCourseName() {
        return courseName;
    }

    public int getCourseScore() {
        return courseScore;
    }

    public Course(String courseName, int courseScore){
        this.courseName = courseName;
        this.courseScore = courseScore;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == this.getClass()){
            if(((Course)obj).getCourseName().equals(this.courseName)){
                if (((Course)obj).getCourseScore() == this.courseScore){
                    return true;
                }
            }
        }
        return false;
    }
}

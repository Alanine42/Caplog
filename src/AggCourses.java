import java.util.LinkedList;

/**
Aggregate Courses object:
prerequisite: (A or B or C)
If any prerequisite is satisfied, this Aggregate Courses object is accessible. 
 */
public class AggCourses {


    private LinkedList<Course> prerequisites;


    public AggCourses() {
        prerequisites = new LinkedList<>();
    }

    public AggCourses(LinkedList<Course> prereq) {
        this.prerequisites = prereq;    //shallow copy
    }

    /**
    might NOT be used
     */
    public void add(Course c) {
        this.prerequisites.add(c);
    }
    
}

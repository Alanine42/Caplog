import java.util.ArrayList;

/**
Aggregate Courses object:
prerequisite: (A or B or C)
If any prerequisite is satisfied, this Aggregate Courses object is accessible. 
 */
public class AggCourses{


    private ArrayList<String> ORs;


    public AggCourses() {
        ORs = new ArrayList<>();
    }

    public AggCourses(ArrayList<String> prereq) {
        this.ORs = prereq;    //shallow copy
    }

    /**
    might NOT be used
     */
    public void add(String c) {
        this.ORs.add(c);
    }
    
}

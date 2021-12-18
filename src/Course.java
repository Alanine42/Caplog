/**
Each Course is a vertex in CatalogGraph.

Description
Prerequisites[]
Unlock/ContributeTowards[]

Utility = outdegree (length of ContributeTowards)
Utility2 = sum of ContributeToward's Course's Utility
 */

import java.util.LinkedList;
import java.util.List;

public class Course {
    private String name;
    private String description;

    private List<Course> in;
    private List<Course> out;

    public boolean taken; // have the user taken this class yet?

    /**
    Reads in Course's name and description
     */
    public Course(String name, String description) {
        this.name = name;
        this.description = description;
        this.in = new LinkedList<>();
        this.out = new LinkedList<>();
    }

    
}

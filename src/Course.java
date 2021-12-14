/**
Each Course is a vertex in CatalogGraph.

Course ID           e.g. id="math103a"
Description
Prerequisites[]
Unlock/ContributeTowards[]

Utility = outdegree (length of ContributeTowards)
Utility2 = sum of ContributeToward's Course's Utility
 */

import java.util.LinkedList;

public class Course {
    private String name;
    private String description;


    public boolean taken; // have the user taken this class yet?

    /**
    Reads in Course's name and description
     */
    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
}

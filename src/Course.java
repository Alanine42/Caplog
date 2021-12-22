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
    public String id;  // eg. "CSE 21"
    private String name;
    private String description;
    private String prereq;   // raw prerequisite string

    private List<Course> in;
    private List<Course> out;

    public boolean taken; // have the user taken this class yet?

    /**
    Reads in Course's name and description
     */
    public Course(String name, String description) {
        this.id = name.substring(0, name.indexOf('.'));
        this.name = name;
        this.description = description;
        this.prereq = "";
        this.in = new LinkedList<>();
        this.out = new LinkedList<>();
        parsePrerequisites();

    }

    /**
    Parse the course prerequisites from the description String.
    Set them to be the in-going edges of the Course vertex. 
     */
    private void parsePrerequisites() {
        // this.prereq = "";
        int idx = description.indexOf("Prerequisites: ");

        // no prerequisites
        if (idx == -1) return;

        // has prerequisite(s), extract them and parse into individual courses
        // 掐头
        prereq = description.substring(idx + "Prerequisites: ".length());
        // 去尾: there is always a period in the end
        // but it's possible to end early at a semicolon.
        int end = (prereq.indexOf(';') == -1) ? 
                    prereq.indexOf('.') : prereq.indexOf(';');
        String[] prereqSubstrings = prereq.substring(0, end).split(" and ");

        for (String s : prereqSubstrings) System.out.println(s + "\n"); //TESTING

        
    }

    @Override
    public String toString() {
        return "ID: " + id + 
        "\nName: " + name + 
        "\nDescription: " + description + 
        "\nPrerequisites: " + prereq + "\n";
    }
    
}

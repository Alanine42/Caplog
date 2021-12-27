/**
Each Course is a vertex in CatalogGraph.

Description
Prerequisites[]
Unlock/ContributeTowards[]

Utility = outdegree (length of ContributeTowards)
Utility2 = sum of ContributeToward's Course's Utility
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Course {
    public String ID;  // eg. "CSE 21"
    private String name;
    private String description;
    public String prereq;   // raw prerequisite string

    private List<Vertex> in;    //in-going edges
    private List<Vertex> out;   //out-going edges

    public boolean taken; // have the user taken this class yet?

    /**
     * Records the information processed by the WebScraper
     * @param name The course's full name
     * @param des The course's description
     * @param in List of all the course's prerequisites
     */
    public Course(String ID, String name, String des, ArrayList<Vertex> in) {
        this.ID = ID;
        this.name = name;
        
    }

    /**
    Reads in Course's name and description
     */
    public Course(String name, String description) {
        this.ID = name.substring(0, name.indexOf('.'));
        this.name = name;
        this.description = description;
        this.prereq = "";
        this.in = new LinkedList<>();
        this.out = new LinkedList<>();
        parsePrerequisites();

    }

    /**
    Extract the course prerequisites from the description String.
    Parse the prerequisites into individual courses.
    E.g.
    Prerequisites: "(A or B) and (C or D) and E"
    Parse it into {(A or B), (C or D), E }
    Set them to be the in-going edges of the Course vertex. 
     */
    private void parsePrerequisites() {
        int idx = description.indexOf("Prerequisites: ");
    
        if (idx == -1) return;   // no prerequisites

        // 掐头: discard "Prerequisites"
        prereq = description.substring(idx + "Prerequisites: ".length());
        // 去尾: useful information may end with an early semicolon or a period. 
        int end = (prereq.indexOf(';') == -1) ? 
                    prereq.indexOf('.') : prereq.indexOf(';');
        prereq = prereq.substring(0, end);

        // 分段: split the prerequisite courses by "and"
        String[] prereqSubstrings = prereq.split(" and ");
        for (String str : prereqSubstrings) {
            // isolate each course and record them
            
        }
        
   
    }

    

    @Override
    public String toString() {
        return "ID: " + ID + 
        "\nName: " + name + 
        "\nDescription: " + description + 
        "\nPrerequisites: " + prereq + "\n";
    }
    
}

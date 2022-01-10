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
    // public String prereq;   // raw prerequisite string

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
        this.description = des;
        this.in = in;

    }


    

    @Override
    public String toString() {
        return "ID: " + ID + 
        "\nName: " + name + 
        "\nDescription: " + description + "\n";
        // "\nPrerequisites: " + prereq + "\n";
    }
    
}

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

public class Course extends Vertex{
    // Data Fields
    // public String ID;  // already have this field in parent class Vertex
    private String name;
    private String description;

    public LinkedList<Vertex> prereqs; // List of prerequisites (immutable)
    public LinkedList<Vertex> in;    //List of prerequisites (mutable)
    public LinkedList<Vertex> out;   //out-going edges

    // User Flag (Dynamic Decision)
    public boolean taken; // have the user taken this class yet?
    public int utility;

    /**
     * Records the information processed by the WebScraper
     * @param name The course's full name
     * @param des The course's description
     * @param in List of all the course's prerequisites
     */
    public Course(String ID, String name, String des, LinkedList<Vertex> in) {
        super(ID);
        // this.ID = ID;
        this.name = name;
        this.description = des;
        this.in = in;

    }

// ------------------------------For testing in TOpological.java---------------
    public Course(String ID, LinkedList<Vertex> prereqsIn) {
        super(ID);
        this.prereqs = prereqsIn;
        this.in = (LinkedList<Vertex>) prereqsIn.clone();
    }


    public void setOuts(LinkedList<Vertex> outs) {
        this.out = outs;
    }

   

    


//------------------------------Testing methods end--------------------------
    @Override
    public String toString() {
        return ID;
        // return "ID: " + ID + 
        // "\nName: " + name + 
        // "\nDescription: " + description + "\n";
    }
    
}

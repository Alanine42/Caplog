import java.util.ArrayList;

/**
Superclass for Course and AggCourse

Designed Vertex class to be a String container (multiple ORs)
 */
public class Vertex {
    // Simple Vertex (single), or Composite Vertex (A or B or...) ?
    public boolean single; 

    // IF is single,
    // then this Vertex object shall be equivalent to a Course object
    public String ID;
    /**
     * Simple Vertex (single Course) CTOR
     * @param ID course ID of the Course
     */
    public Vertex(String ID) {
        single = true;
        this.ID = ID;
    }

    // ----------------------------------------------------------------

    // IF NOT single, 
    // then redirect to each String in 'ORs' ---database---> each Course:
    ArrayList<String> ORs_ID; // list of (possible) interchangeable prereqs

    /**
     * Multiple interchangeable 
     * @param ORs_ID
     */
    public Vertex(ArrayList<String> ORs_ID) {
        // no prereqs ? Potential parsing error in WebScraper.java
        if (ORs_ID.size() == 0) {
            System.out.println("\n\nEMPTY VERTEX!!!\n\n");
        }
        
        // single prereq
        else if (ORs_ID.size() == 1) {
            single = true;
            ID = ORs_ID.get(0);
        }

        // multiple, interchangeable prereqs
        else {
            single = false;
            this.ORs_ID = ORs_ID;
        }
    }


    public String toString() {
        if (ORs_ID.size() == 0) return "None";
        if (single) return ID;

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i=0; i < ORs_ID.size() - 1; i++) {
            sb.append(ORs_ID.get(i));
            sb.append(" || ");
        }
        sb.append(ORs_ID.get(i));
        return sb.toString();
    }


}

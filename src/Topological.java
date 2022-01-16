import java.util.Stack;
import java.util.LinkedList;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;

/**
Testing the topological sort algorithm (Khan's algorithm) on simple Course
objects.
 */
public class Topological {

    /**
     * Display the grpah in format:
     * Vertex i:
     *      Prereqs i: 
     *      Ins i:
     *      Outs i:  
     * @param graph
     */
    public static void displayGraph(HashMap<String, Course> graph) {
        StringBuilder sb = new StringBuilder();

        for (Course v : graph.values()) {
            sb.append(v.ID + ": \n");
            sb.append("\t Prereqs: " + v.prereqs + "\n");
            sb.append("\t In: " + v.in + "\n");
            sb.append("\t Out: " + v.out + "\n");
            
            // for (Vertex p : v.prereqs) {
            //     sb.append(p + ",  ");
            // }
            // sb.append("\n\t In: ");
            // for (Vertex i : v.in) {
            //     sb.append(i + ",  ");
            // }
            // sb.append("\n\t Out: ");
            // // for (Vertex o : v.out)
        }

        System.out.println(sb.toString());


    }

    public static void main(String[] args) {
        // A graph/database of Vertex objects (which Course extends)
        HashMap<String, Course> graph = new HashMap<>();
        
        // Record lower-div CSE courses and their prereqs
        LinkedList<Vertex> p8a = new LinkedList<>();
        Course cse8A = new Course("CSE 8A", p8a);      
        
        LinkedList<Vertex> p8b = new LinkedList<>();
        p8b.add(cse8A);
        Course cse8B = new Course("CSE 8B", p8b);

        LinkedList<Vertex> p12 = new LinkedList<>();
        p12.add(cse8B);
        Course cse12 = new Course("CSE 12", p12);

        LinkedList<Vertex> p15l = new LinkedList<>();
        p15l.add(cse8B);
        Course cse15L = new Course("CSE 15L", p15l);

        LinkedList<Vertex> p30 = new LinkedList<>();
        p30.add(cse12);
        p30.add(cse15L);
        Course cse30 = new Course("CSE 30", p30);

        LinkedList<Vertex> p20 = new LinkedList<>();
        p20.add(cse8B);
        Course cse20 = new Course("CSE 20", p20);

        LinkedList<Vertex> p21 = new LinkedList<>();
        p21.add(cse20);
        Course cse21 = new Course("CSE 21", p21);
        
        graph.put("CSE 8A", cse8A);
        graph.put("CSE 8B", cse8B);
        graph.put("CSE 12", cse12);
        graph.put("CSE 15L", cse15L);
        graph.put("CSE 30", cse30);
        graph.put("CSE 20", cse20);
        graph.put("CSE 21", cse21);

        displayGraph(graph);

        // Initializes the 'out' field for each vertex

        
    }   

    public static void setOuts(HashMap<String, Course> graph) {
        // Initialize "visited[]" 
        HashMap<Course, Boolean> visited = new HashMap<>(graph.size());
        for (Course c : graph.values()) {
            visited.put(c, false);
        }

        for (HashMap.Entry<Course, Boolean> c : visited.entrySet()) {
            if (c.getValue().equals(false)) {  //haven't visited
                visited.replace(c.getKey(), true); // set it to be visited
                setOuts(graph, visited, c.getKey()); //run graph search


            }
        }
    }

    public static void setOuts(HashMap<String, Course> graph, 
    HashMap<Course, Boolean> visited, Course s) {
        Stack<Course> S = new Stack<>();
        S.push(s);
        while ( ! S.isEmpty()) {
            Course curr = S.pop();
            for (Vertex n :curr.in) {
            
            }
        }

    }
}

/**
Directed Graph G = {V, E}
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;


public class Graph {
    // private int V;
    // private int E;

    /**
    V: The set of al Vertices (in-order traversable).
     */
    private TreeMap<Vertex, Vertex> V;

    /**
    Stores the indegree of all Vertices.
    Need to find 
     */
    private HashMap<Vertex, Integer> indegree;

    /**
    Instantiate a Graph with V vertices {0,1,..,V-1} and no edges yet.
     */
    public Graph(int V) {


        

    }

    public void addEdge (Vertex from, Vertex to) {  
        
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        // TODO: show the TreeMap

        return sb.toString();
    }


}

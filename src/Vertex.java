/**
Superclass
 */
public class Vertex implements Comparable{
    private static int vertexCount = 0;
    private int val;

    private int indegree = 0;
    private int outdegree = 0;

    /**
    Array is fine for in & out vertices since indegree & outdegree are low
    (There aren't many prerequisites.  inear traversal is fine)
     */
    private Vertex[] in; 
    private Vertex[] out;

    /**
    Generic
     */
    public Vertex() {
        val = vertexCount++;
    }

    public int val() {
        return val;
    }

    public boolean equals(Vertex o) {
        if (this == o) return true;
        return this.val == o.val();
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        Vertex ov = (Vertex) o;
        return this.val - ov.val();
    }
}

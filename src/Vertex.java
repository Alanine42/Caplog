import java.util.ArrayList;

/**
Superclass for Course and AggCourse
 */
public class Vertex {
    public boolean isComposite;
    ArrayList<String> ORs;

    public Vertex(ArrayList<String> ORs) {
        this.ORs = ORs;
        if (ORs.size() == 0)    return;
        if (ORs.size() == 1)    isComposite = false;
        else                    isComposite = true;
    }


    public String toString() {
        if (ORs.size() == 0) return "None";
        if (! isComposite) return ORs.get(0);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i=0; i < ORs.size() - 1; i++) {
            sb.append(ORs.get(i));
            sb.append(" || ");
        }
        sb.append(ORs.get(i));
        return sb.toString();
    }

}

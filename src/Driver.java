import java.util.HashSet;

public class Driver {

    /**
    Database
     */
    private HashSet<Course> database;

    public static void main(String[] args) {
        HashSet<Course> database = new HashSet<Course>();

        WebScraper captain = new WebScraper();
        captain.scrape(database);
        
    }
}

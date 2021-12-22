import java.util.HashSet;
import java.util.HashMap;

public class Driver {

    /**
    Database {"course_name" : CourseObject, ...}
     */
    private static HashMap<String, Course> database;

    public static void main(String[] args) {
        database = new HashMap<String, Course>();

        WebScraper captain = new WebScraper();
        captain.scrape(database);

        

    }
}

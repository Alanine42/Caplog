/**
Scrape the catalogs, store into <course_id, CourseObject>

 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebScraper {

    private static final String PRE = "Prerequisites: ";

    private static final String 
    MATH = "https://catalog.ucsd.edu/courses/MATH.html",
    CSE = "https://catalog.ucsd.edu/courses/CSE.html",
    BIO = "https://catalog.ucsd.edu/courses/BIOL.html";


    private static final String driverDirectory = 
    "/Users/sunyupeng/Documents/ChromeDriverFolder/chromedriver";

    WebDriver driver;

    public WebScraper() {
        System.setProperty("webdriver.chrome.driver", driverDirectory);
        driver = new ChromeDriver();
    }

    /**
     * Delegate to other scrape()'s to scrape all subjects' catalog
     * 
     * @param database  output parameter to store the scraped data
     */
    public void scrape(HashMap<String, Course> database) {
        // scrape(MATH, database);
        scrape(CSE, database);
        // scrape(BIO, database);
        // ...
    }

    /**
     * Scrape the specific course's catalog
     *
     * @param url url of the specific course catalog 
     * @param database  output parameter to store the scraped data
                eg. {"CSE 21" : CSE21_COURSE_OBJECT, ...}
     */
    public void scrape(String url, HashMap<String, Course> database) {
        driver.get(url);
        // Courses names
        List<WebElement> names = driver.findElements(By.className("course-name"));
        // Courses descriptions for all courses in Math Department
        List<WebElement> descriptions = driver.findElements(By.className("course-descriptions"));
        
        Pattern pattern = Pattern.compile("[A-Z]+ [0-9]+[A-Z]*");
        Matcher matcher;

        try {
        for (int i=0; i < names.size(); i++) {
            // Process each course  
            String name = names.get(i).getText();
            String ID = name.substring(0, name.indexOf('.'));
            String des = descriptions.get(i).getText();
            int startIdx = des.indexOf(PRE);

            // the course has prerequisites
            if (startIdx != -1) {
                // 掐头去尾: leave only the prerequisites in the string
                String prereq = des.substring(startIdx + PRE.length());
                int endIdx = (prereq.indexOf(';') == -1) ? 
                                prereq.indexOf('.') : prereq.indexOf(';');
                prereq = prereq.substring(0, endIdx);

                // TODO: Discern The Badly Formatted Prerequisites !
                // Process them as usual, BUT also Report Them to tricky.txt

                // 分段: split the prerequisite courses by "and" //TODO: split by , in PHYS
                LinkedList<Vertex> in = new LinkedList<Vertex>();
                String[] prereqSubs = prereq.split(" and ");
                for (int k=0; k < prereqSubs.length; k++) {
                    // TODO: ignore possible "...and concurrent enrollment..."
                    
                    // isolate each course and record them in "ORs"
                    matcher = pattern.matcher(prereqSubs[k]);
                    ArrayList<String> ORs = new ArrayList<String>();
                    while (matcher.find()) {
                        ORs.add(matcher.group());
                    }

                    in.add(new Vertex(ORs));
                }

                // check "in"
                System.out.println("-------Testing " + ID + "--------");
                System.out.println("in-edges: ");
                for (int k=0; k<in.size(); k++) {
                    System.out.println(k+1 + ". " + in.get(k));

                }
                System.out.println();

                //Record into a Course object, store in database (FOR NOW)
                Course course = new Course(ID, name, des, in);
                database.put(ID, course);

            }

        
        }

            System.out.println();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("WebScraper.java: Names and descriptions 's sizes don't match!!!");
            e.printStackTrace();
        }

        
    }

    public static void main(String[] args) {
        HashMap<String, Course> database = new HashMap<String, Course>();

        // Scrape catalogs and store all data into `database`
        WebScraper captain = new WebScraper();
        captain.scrape(database);

        


    }

}

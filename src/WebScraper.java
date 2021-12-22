/**
Scrape the catalogs, store into <course_id, CourseObject>

 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;


public class WebScraper {

    private static final String PRE = "Prerequisites: ";

    private static final String 
    MATH = "https://catalog.ucsd.edu/courses/MATH.html",
    CSE = "https://catalog.ucsd.edu/courses/CSE.html";


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
        scrape(MATH, database);
        // scrape(CSE, database);
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
        
        try {
            for (int i=0; i < names.size() / 2; i++) {  /// no /2
                String name = names.get(i).getText();
                String des = descriptions.get(i).getText();

                //store into a Course Object
                Course course = new Course(name, des);
                
                System.out.println(course);

                database.put(course.id, course);
            
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("WebScraper.java: Names and descriptions 's sizes don't match!!!");
            e.printStackTrace();
        }

        
    }

}

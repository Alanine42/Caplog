/**
Scrape the catalogs

 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;


public class WebScraper {

    private static final String PRE = "Prerequisites: ";

    private static final String 
    MATH = "https://catalog.ucsd.edu/courses/MATH.html",
    CSE = "fuck my https://life.com ";


    private static final String driverDirectory = 
    "/Users/sunyupeng/Documents/ChromeDriverFolder/chromedriver";

    WebDriver driver;

    public WebScraper() {
        System.setProperty("webdriver.chrome.driver", driverDirectory);
        driver = new ChromeDriver();
    }

    /**
    Delegate to other scrape()'s to scrape all subjects' catalog 
     */
    public void scrape(HashSet<Course> database) {
        scrape(MATH, database);
        // scrape(CSE, database);
        // ...
    }

    public void scrape(String url, HashSet<Course> database) {
        driver.get(url);
        // Courses names
        List<WebElement> names = driver.findElements(By.className("course-name"));
        // Courses descriptions for all courses in Math Department
        List<WebElement> descriptions = driver.findElements(By.className("course-descriptions"));
        
        try {
            for (int i=0; i < names.size(); i++) { 
                String name = names.get(i).getText();
                String des = descriptions.get(i).getText(); 

                //store into a Course Object


                System.out.println("Name: " + name);
                System.out.println("Description: " + des);
            
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("names and descriptions 's sizes don't match!");
            e.printStackTrace();
        }

        
    }

    /**
     * "Split" the course description into 2 parts: 
     * 1) course overview and 2) course prerequisites

     * @param course course description
     * @return array of 2 strings (course overview, course prerequisites)
     */
    public static String[] parseCourseDescription(String course) {
        StringBuilder sb = new StringBuilder();
        String[] retVal = new String[2]; 

        int i,j = 0; 
        char ch;
        for (i=0, j=0; i < course.length() && j < PRE.length(); i++) {
            // try to match for "Prerequisites: "
            if ((ch = course.charAt(i)) == PRE.charAt(j)) j++;
            // matching fails, restart matching
            else j = 0;

            sb.append(ch);
        }
        // now, i is the starting index of course prerequisites
        
        retVal[0] = sb.toString();  // record the course overview
        sb.setLength(0);  // restart string builder
        
        while (i<course.length()) {
            // record the course prerequisites
            sb.append(course.charAt(i++));
        }
        retVal[1] = sb.toString();

        return retVal;
    }

    /**
     * 不重造轮子
     * @param course
     * @return
     */
    public static String[] parseCourseDescriptionHHH(String course) {
        int idx = course.indexOf("Prerequisites: ");
        // System.out.println(idx + "----" + course.substring(idx));
        if (idx != -1) {
            
        } 
        return null;
    }

}

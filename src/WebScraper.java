/**
Scrape the catalogs

store into a BST
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public class WebScraper {

    private static final String PRE = "Prerequisites: ";

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
        int idx;
        if ((idx = course.indexOf("Prerequisites: ")) != -1) {
            // TODO
        } 
        return null;
    }


    public static void main(String[] args) {
        // locate webdriver
        System.setProperty("webdriver.chrome.driver", "/Users/sunyupeng/Documents/ChromeDriverFolder/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://catalog.ucsd.edu/courses/MATH.html");
        // Course descriptions for all courses in Math Department
        List<WebElement> courseList = driver.findElements(By.className("course-descriptions"));

        for (WebElement course : courseList) {
            System.out.println(course.getText());
            

            try {
                System.out.println();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    

        
    }

}

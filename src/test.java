public class test {

    public static final String CS = "First course [Prereq] in a two-quarter introduction to abstract algebra with some applications. Emphasis on group theory. Topics include definitions and basic properties of groups, properties of isomorphisms, subgroups. (Students may not receive credit for both MATH 100A and MATH 103A.) Prerequisites: MATH 31CH or MATH 109 or consent of instructor.";
    public static void main(String[] args) {


        String[] parsed = WebScraper.parseCourseDescription(CS);

        System.out.println(parsed[0]);
        System.out.println(parsed[1]);

    }
}

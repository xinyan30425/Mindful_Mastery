/**
 * Module class contains a list of courses
 * This is an implementation of using the "map", "filter",and "fold" higher-order function
 * Manipulate and aggregate data across a list of exercise
 * 
 * @Author Xinyan Liu
 * 
 */

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Module {
    private String name;
    private String description;
    private List<Course> courses;

    /*
     * Constructor constructs a module with the specified name, description and courses
     * 
     * @param name the name of the module
     * @param description the description of the module
     * @param courses the list of courses in the module
     */
    public Module(String name, String description, List<Course> courses) {
        this.name = name;
        this.description = description;
        this.courses = courses;
    }


    /*
     * Set the name of the module
     * 
     * @param name the name of the module
     */
    public String getName() {
        return name;
    }

    /*
     * Sets the name of the module
     * 
     * @param name the name of the module
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Sets the description of the module 
     * 
     * @param description the description of the module
     */
    public String getDescription() {
        return description;
    }

    /*
     * Sets the description of the module
     * 
     * @param description the description of the module
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * Sets the list of courses in the module
     * 
     * @param courses the list of courses in the module
     */
    public List<Course> getCourses() {
        return courses;
    }

    /*
     * Sets the list of courses in the module
     * 
     * @param courses the list of courses in the module
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /*
     * Returns the total number of credits for all courses in the module
     * getTotalCredits method uses the "fold" function (reduce) to 
     * transform the list of courses into a list of their credit values
     * and then calculate the sum of all credit values
     * 
     * @return the total number of credits for all courses in the module
     */
    public int getTotalCredits() {
        return courses.stream()
                .mapToInt(Course::getCredits)
                .sum();
    }

    /*
     * getCourseNames method uses the "map" function to transform the list of courses into a list of their names
     */
    public List<String> getCourseNames() {
        return courses.stream()
                .map(Course::getName)
                .collect(Collectors.toList());
    }

    /*
     * getRequiredCourses method uses the "filter" function to filter the list of courses into a list of required courses based on a certain criterion
     */
    public List<Course> getRequiredCourses(Predicate<Course> predicate) {
        return courses.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
    
    /*
     * Prints the module hierarchy structure starting from the specified module recursively
     * @param module the starting module 
     */
    public static void printModule(Module module) {
        System.out.println("Module: " + module.getName());
        for (Course course : module.getCourses()) {
            System.out.println("\tCourse: " + course.getName());
            for (Session session : course.getSessions()) {
                System.out.println("\t\tSession: " + session.getName());
            }
        }
    }

}


/**
 * Instructor class represents an instructor for a course or exercise
 * 
 * @Author Xinyan Liu
 */

public class Instructor {
    private String name;
    private String bio;

    /*
     * Constructs a new Instructor object with the given name and bio.
     * 
     * @param name the name of the instructor
     * @param bio the bio of the instructor
     */
    public Instructor(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

        /*
         * Returns the name of the instructor
         * 
         * @return the name of the instructor
         */

        public String getName() {
            return name;
        }
    
        /*
         * set the name for the instructor
         */
        public void setName(String name) {
            this.name = name;
        }
    
        /*
         * Returns the bio of the instructor
         * 
         * @return the bio of the instructor
         */
        public String getBio() {
            return bio;
        }
    
        /*
         * set the bio for the instructor
         */
        public void setBio(String bio) {
            this.bio = bio;
        }
    

}

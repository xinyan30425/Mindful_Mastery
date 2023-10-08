/**
 * The UserController class acts as the controller in the Model-View-Controller (MVC) design pattern.
 * It handles user input and updates the user interface accordingly.
 * 
 * @Author Xinyan Liu
 */

public class UserController {
    private User model;
    private UserView view;
    
    /*
     * Constructor for the UserController class.
     * @param model the User model that this controller interacts with.
     * @param view the UserView that displays the User model to the user.
     */
    public UserController(User model, UserView view) {
        this.model = model;
        this.view = view;
    }

    /*
     * Sets the name of the User model.
     * @param name the new name of the User model.
     */
    public void setUserName(String name) {
        model.setName(name);
    }

    /*
     * Returns the name of the User model.
     * @return the name of the User model.
     */
    public String getUserName() {
        return model.getName();
    }

    /*
     * Sets the email of the User model.
     * @param email the new email of the User model.
     */
    public void setUserEmail(String email) {
        model.setEmail(email);
    }

    /*
     * Gets the email of the User model.
     * @return the email of the User model.
     */
    public String getUserEmail() {
        return model.getEmail();
    }

    /*
     * Sets the password of the User model.
     * @param password the new password of the User model.
     */
    public void setUserPassword(String password) {
        model.setPassword(password);
    }

    /*
     * Gets the password of the User model.
     * @return the password of the User model.
     */
    public String getUserPassword() {
        return model.getPassword();
    }

    /*
     * Updates the UserView to reflect changes made to the User model.
     */
    public void updateView() {
        view.display();
    }

    /*
     * Sets the UserView that displays the User model to the user.
     * @param view the new UserView that displays the User model to the user.
     */
    public void setView(UserView view) {
        this.view = view;
    }
    
}

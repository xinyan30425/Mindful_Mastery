/**
 * A view class acts as a graphical user interface(GUI) class that displays the information of a user. 
 * It extends JPanel and includes text fields for user’s information
 * 
 * @Author Xinyan Liu
 */

import javax.swing.*;
import java.awt.*;

public class UserView extends JPanel{
    private User user;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField passwordField;
    private JLabel meditationHistoryLabel;
    private JList<MeditationRecord> meditationHistoryList;
    private JLabel sessionHistoryLabel;
    private JList<SessionRecord> sessionHistoryList;
	private UserController controller;


    /*
     *Display the user's information on the console.
     */
    public void display() {
        System.out.println("User Information");
        System.out.println("-----------------");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
    }

    
    /*
     * Constructor for the UserView class.
     * @param model the User object to be displayed
     */
    public UserView(User model) {
        this.user = model;
        setLayout(new BorderLayout());

        // Create and add name field
        JPanel namePanel = new JPanel(new GridLayout(1, 2));
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(model.getName());
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        add(namePanel, BorderLayout.NORTH);

        // Create and add email field
        JPanel emailPanel = new JPanel(new GridLayout(1, 2));
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(model.getEmail());
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        add(emailPanel, BorderLayout.CENTER);

        // Create and add password field
        JPanel passwordPanel = new JPanel(new GridLayout(1, 2));
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JTextField(model.getPassword());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        add(passwordPanel, BorderLayout.SOUTH);

        // Create and add meditation history list
        JPanel meditationHistoryPanel = new JPanel(new BorderLayout());
        meditationHistoryLabel = new JLabel("Meditation History:");
        meditationHistoryList = new JList<>(model.getMeditationHistory().toArray(new MeditationRecord[0]));
        meditationHistoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane meditationHistoryScrollPane = new JScrollPane(meditationHistoryList);
        meditationHistoryPanel.add(meditationHistoryLabel, BorderLayout.NORTH);
        meditationHistoryPanel.add(meditationHistoryScrollPane, BorderLayout.CENTER);
        add(meditationHistoryPanel, BorderLayout.WEST);

        // Create and add session history list
        JPanel sessionHistoryPanel = new JPanel(new BorderLayout());
        sessionHistoryLabel = new JLabel("Session History:");
        sessionHistoryList = new JList<>(model.getSessionHistory().toArray(new SessionRecord[0]));
        sessionHistoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane sessionHistoryScrollPane = new JScrollPane(sessionHistoryList);
        sessionHistoryPanel.add(sessionHistoryLabel, BorderLayout.NORTH);
        sessionHistoryPanel.add(sessionHistoryScrollPane, BorderLayout.CENTER);
        add(sessionHistoryPanel, BorderLayout.EAST);
    }
    
    /*
     * Returns the name entered by the user in the name field.
     * @return the name entered by the user
     */
    public String getName() {
        return nameField.getText();
    }


    /*
     * Returns the email entered by the user in the email field.
     * @return the email entered by the user
     */
    public String getEmail() {
        return emailField.getText();
    }
    
    /*
     * Returns the password entered by the user in the password field.
     * @return the password entered by the user
     */
    public String getPassword() {
        return passwordField.getText();
    }
    
    /*
     * Sets the User object to be displayed.
     * @param model the User object to be displayed
     */
    public void setModel(User model) {
        this.user = model;
        nameField.setText(model.getName());
        emailField.setText(model.getEmail());
        passwordField.setText(model.getPassword());
        meditationHistoryList.setListData(model.getMeditationHistory().toArray(new MeditationRecord[0]));
        sessionHistoryList.setListData(model.getSessionHistory().toArray(new SessionRecord[0]));
    }
    
    /*
     * Sets the controller for the UserView object.
     * @param controller the UserController object that controls this view
     */
    public void setController(UserController controller) {
        this.controller = controller;
    } 
    
}

/**
 * This Driver class is the main class that runs the meditation application
 * It creates and manages various objects such as instructors, meditation exercises, 
 * sessions, courses, modules, users, and payment and subscription information.
 * It also interacts with users by displaying information and prompting for input via the console.
 * 
 * @Author Xinyan Liu
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;


public class Driver {
    public static void main(String[] args) {
        // Create instructors
        Instructor instructor1 = new Instructor("John", "John is an experienced meditation instructor.");
        Instructor instructor2 = new Instructor("Jane", "Jane is a theropist.");
  
        // Create meditation exercises
        Meditation meditation1 = new Meditation ("Breathing Meditation", "Focus on your breath.", 10, instructor1);
        Meditation meditation2 = new Meditation ("Body Wakeup", "Wake your body up for tension.", 15, instructor1);
        Meditation meditation3 = new Meditation ("Loving Kindness", "Send love and kindness to yourself.", 20, instructor2);

        // Create sessions
        List<Exercise> sessionExercises1 = new ArrayList<>();
        sessionExercises1.add(meditation1);
        sessionExercises1.add(meditation2);
        Session session1 = new Session("Session 1", "Introduction to meditation techniques", 25, sessionExercises1);
        
        List<Exercise> sessionExercises2 = new ArrayList<>();
        sessionExercises2.add(meditation3);
        Session session2 = new Session("Session 2", "Advanced meditation techniques", 20, sessionExercises2);
        
        // Create courses
        List<Session> courseSessions1 = new ArrayList<>();
        courseSessions1.add(session1);
        Course course1 = new Course("Introduction to Meditation", "Learn the basics of meditation.", courseSessions1, instructor1,3, true);
          
        List<Session> courseSessions2 = new ArrayList<>();
        courseSessions2.add(session2);
        Course course2 = new Course("Advanced Meditation", "Deepen your meditation practice.", courseSessions2, instructor2,5,false);
          
        // Create modules
        List<Course> moduleCourses1 = new ArrayList<>();
        moduleCourses1.add(course1);
        Module module1 = new Module("Meditation 101", "Beginner's Guide to Meditation", moduleCourses1);
        
        List<Course> moduleCourses2 = new ArrayList<>();
        moduleCourses2.add(course2);
        Module module2 = new Module("Meditation 201", "Advanced Meditation Techniques", moduleCourses2);
        
        // Display module information
        module1.printModule(module1);
        module2.printModule(module2);

        // User selects a module
        List<Module> modules = new ArrayList<>();
        modules.add(module1);
        modules.add(module2);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the module you want to select: ");
        int selectedModuleIndex = scanner.nextInt() - 1;
        
        Module selectedModule = modules.get(selectedModuleIndex);
        System.out.println("You selected: " + selectedModule.getName());
        System.out.println("Description: " + selectedModule.getDescription());
        
        // Create users
        User user1 = new User("Alice", "alice@example.com", "password");
        User user2 = new User("Bob", "bob@example.com", "password");
        
        // Display course information
        for (Course course : selectedModule.getCourses()) {
            System.out.println("\nCourse: " + course.getName());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Instructor: " + course.getInstructor().getName());
            System.out.println("Bio: " + course.getInstructor().getBio());
            System.out.println("Credits: " + course.getCredits());
            
            // Get required courses for the module based on a certain criterion
            List<Course> requiredCourses = module1.getRequiredCourses(c -> c.isRequired());

            // Display required courses
            System.out.println("\nRequired courses:");
            for (Course reqCourse : requiredCourses) {
            System.out.println(reqCourse.getName());
            } 
        
            // Display session information
            for (Session session : course.getSessions()) {
                System.out.println("\nSession: " + session.getName());
                System.out.println("Description: " + session.getDescription());
                System.out.println("Total Duration: " + session.getDuration() + " minutes");

            // Display exercise information
                System.out.println("\nExercises:");
                for (Exercise exercise : session.getExercises()) {
                System.out.println("Name: " + exercise.getName());
                System.out.println("Description: " + exercise.getDescription());
                System.out.println("Duration: " + exercise.getDuration() + " minutes");
                System.out.println("Instructor: " + ((Meditation)exercise).getInstructor().getName());
                    }
                }
            }
       

        // Prompt the user to enter their emotional state after the session
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Please enter your emotional state (positive/negative/neutral): ");
        String emotionalState = scanner2.nextLine();

        // Validate the user input
        while (!emotionalState.equalsIgnoreCase("positive") && !emotionalState.equalsIgnoreCase("negative") && !emotionalState.equalsIgnoreCase("neutral")) {
        System.out.print("Invalid emotional state. Please enter a valid emotional state (positive/negative/neutral): ");
        emotionalState = scanner2.nextLine();
        }

        // Update user's meditation history
        LocalDateTime startTime = LocalDateTime.now();
        int duration = 10;
        user1.updateMeditationHistory(meditation1, startTime, duration,emotionalState);
    
        // Update user's session history
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(30);
        user1.updateSessionHistory(session1, startTime, endTime);
    
        // Display user's meditation and session history
        System.out.println("User's meditation history:");
        for (MeditationRecord record : user1.getMeditationHistory()) {
            System.out.println(record.getMeditation().getName() + " " + record.getStartTime() + " " + record.getDuration()+ " Emotion status:" + record.getEmotionalState());
        }
        System.out.println("\nUser's session history:");
        for (SessionRecord record : user1.getSessionHistory()) {
            System.out.println(record.getSession().getName() + " " + record.getStartTime() + " " + record.getEndTime());
        }
        
        // Create a payment
        Payment payment = new Payment(99.99, new Date(), "Credit card");
        
        // Create a subscription
        Subscription subscription = new Subscription(new Date(), new Date(System.currentTimeMillis() + 30L * 24L * 60L * 60L * 1000L), "Premium");
        
        // Print payment and subscription information
        System.out.println("Payment amount: " + payment.getAmount());
        System.out.println("Payment date: " + payment.getDate());
        System.out.println("Payment method: " + payment.getPaymentMethod());
        
        System.out.println("Subscription start date: " + subscription.getStartDate());
        System.out.println("Subscription end date: " + subscription.getEndDate());
        System.out.println("Subscription level: " + subscription.getSubscriptionLevel());

        // Test MeditationRecord, SessionRecord, and ExerciseRecordList classes:
        
        // Create a new meditation record
        MeditationRecord meditationRecord1 = new MeditationRecord(startTime, duration, meditation1);
        MeditationRecord meditationRecord2 = new MeditationRecord(startTime, duration, meditation2);
        MeditationRecord meditationRecord3 = new MeditationRecord(startTime, duration, meditation3);

        // Create a new meditation record list and add the records
        MeditationRecordList meditationRecordList = new MeditationRecordList();
        meditationRecordList.add(meditationRecord1);
        meditationRecordList.add(meditationRecord2);
        meditationRecordList.add(meditationRecord3);

        // Print the details of the meditation record
        System.out.println("Meditation Record list:");
        for (MeditationRecord record : meditationRecordList) {
            System.out.println("Meditation" + record.getName() + record.getStartTime() + " - " + record.getDuration() + " minutes");
        }
        
        // Sort the list by ascending order of duration
        System.out.println("\nMeditation Record list by ascending order of duration:");
        meditationRecordList.sort();
        for (MeditationRecord record : meditationRecordList) {
            System.out.println(record.getStartTime() + " - " + record.getDuration() + " minutes");
        }

        // Create a new session record
        LocalDateTime sessionStartTime = LocalDateTime.now();
        LocalDateTime sessionEndTime = sessionStartTime.plusMinutes(30);
        SessionRecord sessionRecord = new SessionRecord(sessionStartTime, sessionEndTime, session1);

        // Print the details of the session record
        System.out.println("Session Record:");
        System.out.println("Start Time: " + sessionRecord.getStartTime());
        System.out.println("End Time: " + sessionRecord.getEndTime());
        System.out.println("Duration: " + sessionRecord.getDuration() + " seconds");
        System.out.println("Session: " + sessionRecord.getSession().getName());
        

        // Create a notification system
        System.out.println("\nSend notification");
        System.out.println("------------------------------------\n");
        NotificationSystem notificationSystem = new NotificationSystem();

        // Register users as observers
        //user1.register(notificationSystem);
        //user2.register(notificationSystem);

        notificationSystem.addObserver(user1);
        notificationSystem.addObserver(user2);

        // Create a notification
        //Course course2 = new Course("Advanced Meditation", "Deepen your meditation practice.", courseSessions2, instructor2,5,false);
        Course course3 = new Course("Meditation for Stress Reduction", "Learn meditation techniques to reduce stress.", new ArrayList<Session>(), new Instructor("Jane Smith", "Jane is a renowned meditation expert."), 5, false);
        
        // Add another course to the notification system
        notificationSystem.addCourse(course3);

        // Unregister one of the users as an observer of the notification system
        notificationSystem.removeObserver(user1);

        // Update one of the courses
        course1.setName("Programming Fundamentals");

        // Notify all the registered observers of the notification system
        notificationSystem.notifyObservers(course1);
        
        // Create a user view and controller
        UserView userView = new UserView(user1);
        // Set controller for the user and view
        UserController userController = new UserController(user1, userView);

        // Set controller for the view
        userView.setController(userController);
        
        //Create a new JFrame and add the UserView object to its content panel
        JFrame frame = new JFrame("User Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(userView);
        frame.pack();
        frame.setVisible(true);
           
        //display the user information
        userController.updateView();

        // Update the user data
        userController.setUserEmail("newemail@example.com");
        userController.setUserName("new name");
        
        // Display the updated user information
        userController.updateView();

    }
}



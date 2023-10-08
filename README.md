# Mindful_Mastery
A basic application for meditation. Used Model-View-Controller (MVC) design pattern 
This project designed a system for a meditation app that includes classes for users, courses, instructors, and exercises.
Here are the brief descriptions for each class and interface we need for this project:

Course.java:
Represents a course that can be taken by a user. It contains information such as the course name, description, instructor, and sessions. 
Also has a method for retrieving required courses based on a certain criterion.

Exercise.java:
An abstract class that represents an exercise in a meditation program.
It contains basic information about the exercise, such as its name, description, and duration, and a list of records associated with the exercise.

ExerciseInterface.java:
An interface that provides a method to control the execution of an exercise, and it includes methods for starting, pausing, resuming and stopping the exercise.

ExerciseRecord.java:
An abstract class that represents a record of an exercise. It stores information about when the exercise was performed.

ExerciseRecordList.java:
An abstract class that represents a list of exercise records. It provides methods for adding records, filtering records based on a condition, and sorting records.

Instructor.java:
Represents an instructor who can teach a course or lead a meditation exercise. Contains
information such as the instructor's name and bio.

Meditation.java:
Represents a meditation exercise that can be included in a session. Contains information such as the meditation name, description, duration, and instructor.

MeditationRecord.java:
A class that extends ExerciseRecord, specifically for meditation exercises. Represents a record of a meditation exercise performed by a user. 
Contains information such as the start time, duration, associated meditation exercise, and emotional state of the user after the exercise.

MeditationRecordList.java:
A class that extends ExerciseRecordList for meditation records. It provides methods for filtering and sorting meditation records.

Session.java:
Represents a meditation session that can be included in a course, which contains a name, description, duration, and a list of exercises.

SessionRecord.java:
A class that extends ExerciseRecord for session records. It stores the start and end times of a session.

SessionRecordList.java:
A class that extends ExerciseRecordList for session records. It provides methods for filtering and sorting session records.

Module.java:
Module class represents a module within the meditation app, which has a name, description, and a list of courses. Each course can have a list of sessions, and each session can have a list of exercises. 
This can be useful for organizing and representing large amounts of data in a structured and hierarchical manner.

NotificationSystem.java:
Represents a notification system that can send notifications to registered users about new courses or updates to existing courses. 
It provides methods including addCourse, removeObserver, and notifyObservers to manage the list of observers.

Observer.java:
Represents an interface that defines the contract for objects that need to be notified when the state of another object changes. 
The user is notified when the subject it is registered with undergoes a change.

Subject.java:
An interface contains methods to register, remove, and notify observers. It is being observed by one or more observers, and it maintains a list of observers that are interested in being notified of changes. 
The “Exercise” class, “Session” class, and “Course” class implement the “Subject” interface to allow observers to subscribe and receive notifications.

Payment.java:
Represents a payment made by a user for a course or subscription. Contains information such as the payment amount, date, and payment method.

Subscription.java:
Represents a subscription to a course or module. Contains information such as the subscription start date, end date, and subscription level.

User.java:
Represents a user of the meditation app. Contains information such as the user's name, email, password, and meditation or session history. Also represents a model in the MVC design pattern.

UserController.java:
A controller acts as the controller in the MVC design pattern for handling user data and updates.

UserView.java:
A view class acts as a graphical user interface (GUI) class that displays the information of a user. 
It extends JPanel and includes text fields for the user’s name, email, and password, as well as JLists for the user’s meditation and session history.

Driver.java:
The Driver class is the main class that runs the meditation application. It creates and manages various objects such as instructors, meditation exercises, sessions, courses, modules, users, and payment and subscription information. It also interacts with users by displaying information and prompting for input via the console and GUI view window. Additionally, it demonstrates the functionality of various classes in the application such as MeditationRecord, SessionRecord, and ExerciseRecordList by creating instances and printing their details. 
Finally, it also showcases the notification system by registering and unregistering users as observers and notifying them of updates to courses.

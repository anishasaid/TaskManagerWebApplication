# TaskManagerWebApplication
Prerequisites:
Java Development Kit (JDK) installed on your system.
Maven installed on your system.
MySQL database installed and running.

Steps to Setup:
1. Clone the repository from GitHub. => git clone https://github.com/anishasaid/TaskManagerWebApplication.git

2. Navigate to the project directory. => cd TaskManagerWebApplication

3. Open the project in your preferred IDE (Integrated Development Environment).

4. Set up MySQL database:
      Create a database named feb3.
      Update the application.properties file in src/main/resources with your database configuration.

5. Build the project using Maven. => mvn clean install

6. Run the application. => mvn spring-boot:run

7. API Endpoints:
Add Task:

URL: POST /add/{id}
Description: Adds a new task for the user with the specified ID.
Request Body: String representing task details.
Response: Details of the added task.
Delete Task:

URL: DELETE /delete/{id}
Description: Deletes the task with the specified ID.
Response: Boolean indicating if the deletion was successful.
Read All Tasks:

URL: GET /readAllTasks/{id}
Description: Retrieves all tasks associated with the user with the specified ID.
Response: List of tasks associated with the user.
Login:

URL: POST /login
Description: Validates user credentials and returns user ID if successful.
Request Body: Array of strings containing username and password.
Response: User ID if login successful, otherwise 0.

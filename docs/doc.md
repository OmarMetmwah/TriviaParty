# ⚠️⚠️Not Finished

# **Multiplayer Trivia Game with Leaderboard**

## **Overview**

**Brief Description:**  
The Multiplayer Trivia Game with Leaderboard is an interactive web-based application designed to provide a real-time trivia experience. It allows players to join or create game rooms, compete by answering dynamically fetched trivia questions, and track their performance on a live leaderboard. The project demonstrates expertise in API integration, real-time WebSocket communication, scalable system architecture, and responsive frontend development. Additionally, it includes cloud deployment to ensure accessibility and performance.

**Objectives:**
-   Integrate a third-party trivia API to fetch dynamic questions and answers.
-   Implement real-time communication using WebSockets for seamless gameplay updates.
-   Design and develop a scalable backend to manage game logic and leaderboard updates.
-   Create a responsive and user-friendly frontend interface for player interaction.
-   Design a robust database schema to store player data, game sessions, and scores.
-   Deploy the complete solution on a cloud platform for accessibility and reliability.
-   Provide comprehensive documentation, including setup instructions, API details, and game rules.

### **Cases and Scenarios for the Multiplayer Trivia Game**

----------

### **Case 1: Player Registration and Login**

**Scenario:**

1.  A new player accesses the game for the first time.
2.  The player registers using a username and password.
3.  An existing player logs in with valid credentials.
4.  If login fails, an error message is displayed, and the player can try again.
5.  The player only logs in fist time and stayed loggedin until he chooses to logout.

----------

### **Case 2: Creating or Joining a Game Room**

**Scenario:**

1.  A logged-in player chooses to create a new game room.
2.  The player selects game settings such as the number of questions or categories.
3.  Other players can browse a list of available rooms and join an open game room.

----------

### **Case 3: Starting a Game Session**

**Scenario:**

1.  The host of the game room starts the game once all players are ready.
2.  The game fetches trivia questions dynamically from the API.
3.  All players receive the same question at the same time.

----------

### **Case 4: Answering Trivia Questions**

**Scenario:**

1.  Players select their answers within a limited time frame.
2.  The system records the answers and calculates scores based on correctness.
3.  Players who fail to answer within the time limit receive no points for the question.

----------

### **Case 5: Live Leaderboard Updates**

**Scenario:**

1.  After each question, the leaderboard updates in real-time.
2.  Players can view their position and score relative to others in the game.

----------

### **Case 6: Game End and Winner Announcement**

**Scenario:**

1.  The game ends after all questions are answered.
2.  The final leaderboard is displayed, highlighting the winner.
3.  Players can choose to start a new game or exit.

----------

### **Case 7: Handling Disconnections**

**Scenario:**

1.  A player disconnects during the game.
2.  The game continues without the disconnected player.
3.  If the disconnected player reconnects, they rejoin the game in their last state.


----------

### **Requirements and Features**

#### **Requirements:**

1.  **Authentication and Authorization:** Players must register and log in to access the game.
2.  **Game Room Management:** Players can create, browse, join, or leave game rooms.
3.  **Trivia API Integration:** Fetch questions dynamically from a third-party API.
4.  **Real-Time Communication:** Use WebSockets for game updates and leaderboard interactions.
5.  **Scoring System:** Calculate scores based on answer correctness.
6.  **Live Leaderboard:** Display scores in real-time to all players during the game.
7.  **Robust Error Handling:** Handle API failures, disconnections, and client-side errors gracefully.
8.  **Cloud Deployment:** Host the application on a cloud platform for easy access.

#### **Features:**

1.  **Player Profiles:** Save player scores and statistics for future reference.
2.  **Custom Game Settings:** Allow hosts to customize game categories and difficulty levels.
3.  **Time Limits:** Set timers for answering questions.
4.  **Reconnect Functionality:** Let disconnected players rejoin ongoing games.
5.  **Multiplayer Support:** Enable multiple players to participate simultaneously.
6.  **Responsive Design:** Provide a user-friendly experience on various devices.
7.  **Winner Highlighting:** Showcase the top player after the game ends.
8.  **Game History:** Option to view past game results.

**Low-Fidelity Prototypes for Multiplayer Trivia Game:**  
The low-fidelity prototypes for the Multiplayer Trivia Game aim to outline the fundamental user interfaces and workflows of the game. These include basic sketches or wireframes for key components such as:

-   **Login and Registration Screen:** A simple form for users to register or log in with minimal design elements.
-   **Game Room Interface:** An overview of available game rooms, an option to create a new room, and a list of players in each room.
-   **Question Display Screen:** A basic layout showing the trivia question, answer options, and a countdown timer.
-   **Leaderboard:** A simple, structured list displaying player scores and rankings updated in real-time.

These prototypes focus on functionality and usability rather than aesthetics, enabling efficient feedback collection and iterative improvements to the game's user experience.
![image](https://lh3.googleusercontent.com/d/1kGKcLanzlN0ZAOtsscP2PLgSV970Tfdb=w200?authuser=1/view)
 ![image](https://lh3.googleusercontent.com/d/18j9YiqE0D_Y779k-AYPd9OxHk73Wm0kB=w200?authuser=1/view)
 ![image](https://lh3.googleusercontent.com/d/1Kt0XMcqY8ZHLnwRR11zGYTArKlIIH3eN=w250?authuser=1/view)![image](https://lh3.googleusercontent.com/d/1b9zp-OytDHDYMGEblxjbm7azTKRUZvI5=w250?authuser=1/view)![image](https://lh3.googleusercontent.com/d/1GmYb_MvZtGvA3AbYdCtkrsGxLiINxf96=w250?authuser=1/view)![image](https://lh3.googleusercontent.com/d/1n9tizzWwGNwXEoIiEqMOmIXp1gzn6hxY=w250?authuser=1/view)![image](https://lh3.googleusercontent.com/d/1JwWJBc_T89YCDVPaNn-C5caBU-Gynn_P=w250?authuser=1/view)
**High-Fidelity Prototypes for Multiplayer Trivia Game:** 


![image](https://lh3.googleusercontent.com/d/1KX2EQfLXdwb7i1qBfDHoUE8qUaevAhN5=w250?authuser=1/view)
![image](https://lh3.googleusercontent.com/d/15B_eOgoc99Lhe41T6rtcYown_AoXPv5A=w250?authuser=1/view)


![image](https://lh3.googleusercontent.com/d/1sH8x-qPGEiexxruBiCk6trWr497JAHK9=w250?authuser=1/view)

![image](https://lh3.googleusercontent.com/d/1Vn8063mApv1czzp6BL23YZeY-0yN5wLt=w250?authuser=1/view)


**Architecture and Technologies:**  
The architecture of the Multiplayer Trivia Game is designed for real-time performance, scalability, and simplicity:

1.  **Backend:**
    
    -   **Framework:** Spring Boot handles the business logic, API integrations, and WebSocket-based real-time communication.
    -   **In-Memory Game State:** Concurrent data structures in memory maintain game state for smooth real-time updates, ensuring fast and seamless gameplay.
    -   **Database Integration:** Hibernate ORM is used to map objects to the MySQL database, simplifying interactions and ensuring efficient data handling.
    -   **Database:** A MySQL database is used to store:
        -   Player information (usernames, credentials).
        -   Game history (completed sessions, settings).
        -   Player scores (for leaderboards and historical tracking).
2.  **Frontend:**
    
    -   **Technologies:** HTML, CSS, and JavaScript (without frameworks) provide a lightweight and responsive interface.
    -   **Features:**
        -   User authentication and game room management.
        -   Real-time trivia questions and leaderboard display.
3.  **Communication:**
    
    -   WebSockets ensure efficient and real-time communication between the server and connected players.

This architecture leverages Hibernate for database operations, balancing real-time responsiveness with reliable long-term data storage, ensuring both smooth gameplay and robust historical tracking.

**Database Design:**  
The database for the Multiplayer Trivia Game consists of three key tables:

1.  **Player Table:** Stores player information such as username, encrypted password, and other profile details.
2.  **Game Table:** Records game sessions, including game settings and metadata (e.g., start time, end time).
3.  **Score Table:** Serves as a junction table connecting the `player` and `game` tables, storing player scores and their performance data for each game.


![image](https://lh3.googleusercontent.com/d/1szQ7PUKdGT9DeWtGh9zW5v7C9AK42q_q=w1000?authuser=1/view)

**Authentication and Security:**

-   The application employs the OAuth protocol with JWT tokens to secure user authentication and session management.
-   Passwords are stored encrypted in the database, ensuring data protection and compliance with security best practices.

This structure ensures a robust, secure, and scalable system for managing players, game sessions, and scores.

**Deployment:**  
The backend of the Multiplayer Trivia Game is hosted online using the Railway cloud provider, ensuring accessibility and scalability. The frontend is still under development and will be integrated once completed.
![image](https://lh3.googleusercontent.com/d/1WQoSjS5KWoa84nl4Q5fla9ikRHTDrX0P=w250?authuser=1/view)
[triviaparty-production.up.railway.app](triviaparty-production.up.railway.app)



**Future Feature Points:**

1.  **Friend System:**
    
    -   Players will be able to add friends, invite them to games, and receive notifications when their friends create a game.
    -   Game creation will include restrictions allowing only friends to join, enhancing social interaction and exclusivity.
2.  **Chat Room:**
    
    -   A real-time chat room will be introduced within each game room, enabling players to communicate during the game for a more engaging experience.
3.  **Progressive Web App (PWA):**
    
    -   The frontend will be transformed into a PWA, allowing users to download and install the game as a mobile app for offline access and better user experience on mobile devices.
4.  **User-Generated Content:**
    
    -   Users will have the ability to create custom trivia categories and questions, allowing for a more personalized and diverse game experience.
5.  **Redis Integration:**
    
    -   Redis will be used as an in-memory database to improve performance, particularly for real-time game state management, with caching implemented to speed up data retrieval and enhance the overall responsiveness of the game.

# Live Chat Server

This is a real-time, multi-user chat application built in Java. It follows a client-server architecture, allowing multiple users to connect to a central server and communicate with each other in different chat rooms.



## Technology Stack

*   **Language:** Java
*   **Database:** MySQL
*   **User Interface:** Java Swing (for GUI mode) & a standard Console Interface
*   **Database Driver:** MySQL Connector/J (JDBC)

---

## Key Features

*   **Real-time Chat:** Instantly send and receive messages in public chat rooms.
*   **Multi-User Support:** The server is designed to handle multiple client connections simultaneously.
*   **Dual Mode:** Users can choose between a rich Graphical User Interface (GUI) or a lightweight console-based client.
*   **Secure Login:** User passwords are encrypted before being stored in the database.
*   **Private Messaging:** Send private messages to specific users within a chat room.
*   **Secret Rooms:** Create hidden chat rooms that don't appear in the public list.
*   **Error Logging:** The server maintains a log file to track and debug errors.

---

## How to Run

### Prerequisites

1.  **Java Development Kit (JDK):** Make sure Java is installed and configured on your system.
2.  **MySQL Server:** You need a running instance of a MySQL database.

### 1. Run the Server

Open your terminal and use the following command. You need to provide the port number for the server to listen on, and your database credentials.

```sh
java -jar server.jar <port_no> <database_host> <your_db_username> <your_db_password>
```
**Example:**
```sh
java -jar server.jar 8080 localhost root mypassword
```

### 2. Run the Client

Once the server is running, you can start one or more clients to connect to it.

**To run in GUI Mode:**
```sh
java -jar client.jar <server_host> <server_port_no>
```
**Example:**
```sh
java -jar client.jar localhost 8080
```

**To run in Console Mode:**
```sh
java -jar client.jar <server_host> <server_port_no> --console
```
**Example:**
1

```sh
java -jar client.jar localhost 8080 --console
```

---

## In-Chat Commands

You can type these commands directly into the chat message box.

*   `@username <message>` - Sends a private message (PM) to the specified user.
*   `sv_showusers` - Shows a list of all users currently online in the room.
*   `sv_exit` - To exit the current chat room.
*   `sv_logout` - To log out from the application.

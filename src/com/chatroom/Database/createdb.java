package com.chatroom.Database;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.chatroom.configuration.Config;
import com.chatroom.others.LogFileWriter;


public class createdb {
	public createdb() {
		Connection connection = null;
		java.sql.Statement statement= null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			//creating database	
			connection = DriverManager.getConnection(Config.DATABASE_URL+Config.DATABASE_HOST+Config.DATABASE_PORT,Config.USER_NAME,Config.USER_PWD);
			String Query = "CREATE DATABASE IF NOT EXISTS "+ Config.DATABASE_NAME;
			statement = connection.createStatement();
			statement.executeUpdate(Query);
			//for execute multiple queries separate queries by semicolon
			connection = DriverManager.getConnection(Config.DATABASE_URL+Config.DATABASE_HOST+Config.DATABASE_PORT+'/'+Config.DATABASE_NAME+"?allowMultiQueries=true",Config.USER_NAME,Config.USER_PWD);
			String Queries = "CREATE TABLE IF NOT EXISTS " + Config.TABLE_NAME + "(" + Config.CLIENT_ID + " int auto_increment," + Config.CLIENT_NAME + " VARCHAR(50) not null, "+ Config.CLIENT_PWD + " VARCHAR(150), " +"primary key(" +Config.CLIENT_ID+ "))";
			
			statement = connection.createStatement();
			statement.executeUpdate(Queries);

			// Creating rooms table
			String createRoomsTable = "CREATE TABLE IF NOT EXISTS rooms (" +
					"room_id INT AUTO_INCREMENT PRIMARY KEY, " +
					"room_name VARCHAR(100) NOT NULL UNIQUE)";
			statement.executeUpdate(createRoomsTable);

			// Creating messages table for history
			String createMessagesTable = "CREATE TABLE IF NOT EXISTS messages (" +
					"msg_id INT AUTO_INCREMENT PRIMARY KEY, " +
					"room_id INT, " +
					"client_id INT, " +
					"message TEXT, " +
					"timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
					"FOREIGN KEY (room_id) REFERENCES rooms(room_id), " +
					"FOREIGN KEY (client_id) REFERENCES users(client_id))";
			statement.executeUpdate(createMessagesTable);
			
		} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | java.lang.reflect.InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace(new PrintWriter(Config.errors));
			LogFileWriter.Log(Config.errors.toString());
		}
		finally {
			try {
				connection.close(); //close the database connection
			} catch (SQLException e) {
				e.printStackTrace(new PrintWriter(Config.errors));
				LogFileWriter.Log(Config.errors.toString());
			}
		}
	}
}

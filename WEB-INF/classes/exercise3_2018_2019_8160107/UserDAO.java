	package exercise3_2018_2019_8160107;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDAO provides all the necessary methods related to user's.
 * Use JDBC API in order to connect the the database and store/retrieve users etc.
 *
 * @author --your fullname here--
 *
 */
public class UserDAO {

	/**
	 * This method returns a List with all Users
	 *
	 * @return List<User>
	 */
	public List<User> getUsers() throws Exception {

		/* see exercise 1 A. */
		
		Connection con = null;
		
		DB Connect = new DB();
		
			// Define the SQL statement (to be executed)
			String sql = "SELECT * FROM users_2018_ex3_8160107";
			
				
			// create list
			List<User> userlist = new ArrayList<User>();
			
		try {
			
			//open connection and get Connection object	
			con = Connect.getConnection();	
			
			PreparedStatement stmt = con.prepareStatement(sql);			
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				userlist.add( new User(rs.getString("username"), rs.getString("name"), rs.getString("surname"), rs.getString("email"), rs.getString("password")) );
			
			} //End of while
			
			rs.close(); //closing ResultSet
			stmt.close(); //closing PreparedStatement
			Connect.close(); //closing connection
			
			return userlist;
			
		
		} catch (Exception e) {
			
			throw new Exception("MySQL Driver error: " + e.getMessage());
			
		} finally {
			
			try {
				Connect.close();
			} catch (Exception e) {
				
			}
		} // End of Try
		
	} //End of getUsers

	/**
	 * Search user by username
	 *
	 * @param username, String
	 * @return User, the User object
	 * @throws Exception, if user not found
	 */
	public User findUser(String username) throws Exception {

		/* see exercise 1 B. */
		Connection con = null;
				
		DB Connect = new DB();
		
		// Define the SQL statement (to be executed)
		String sql1 = "SELECT * FROM users_2018_ex3_8160107 WHERE username=?;";
		
		try { 
			//open connection and get Connection object	
			con = Connect.getConnection();	
						
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setString(1, username);
			ResultSet rs = stmt1.executeQuery();
			
			
			if (rs.next()) {
			
			User user = new User(rs.getString("username"), rs.getString("name"), rs.getString("surname"), rs.getString("email"), rs.getString("password"));
			return user;	
			} else {
			rs.close();
			stmt1.close();
			Connect.close();
			return null;
		}
		} catch (Exception e) {
					
					throw new Exception("MySQL Driver error: " + e.getMessage());
					
		} finally {
			
			try {
				Connect.close();
			} catch (Exception e) {
				
			}
		} // End of Try
			
	} //End of findUser

	/**
	 * Checks if the credentials are valid.
	 *
	 * @param username, String
	 * @param password, String
	 * @throws Exception, if the credentials are not valid
	 */
	public void authenticate(String username, String password) throws Exception {

		/* see exercise 1 C. */

		Connection con = null;

		DB Connect = new DB();

		// Define the SQL statement (to be executed)
		String sql2 = "SELECT * FROM users_2018_ex3_8160107 WHERE username =? AND password=?;";
		
		try {
			//open connection and get Connection object	
			con = Connect.getConnection();	

			PreparedStatement stmt2 = con.prepareStatement(sql2);
			
			stmt2.setString(1, username);
			stmt2.setString(2, password);
			
			ResultSet rs = stmt2.executeQuery();
			
			
			rs.close();
			stmt2.close();
			Connect.close();
			
			if (rs != null) {
				return; //the credentials are valid so do nothing
		 	}
		 	
		throw new Exception("Wrong username or password");
			
		} catch (Exception e) {
					
					throw new Exception("MySQL Driver error: " + e.getMessage());
					
				} finally {
					
					try {
						Connect.close();
					} catch (Exception e) {
						
					}
		} // End of Try
		


	} //End of authenticate

	/**
	 * Register/create a User to the database.
	 *
	 * @param user, User
	 * @throws Exception, if encounter any error.
	 */
	public void registerUser(User user) throws Exception {

		/* see exercise 1 D. */
		Connection con = null;
						
		DB Connect = new DB();
		
		// Define the SQL statement (to be executed)
		String sql3 = "INSERT INTO users_2018_ex3_8160107(username, name, surname, email, password) " + " VALUES (?, ?, ?, ?, ?);";
		

		try { 
			
			//open connection and get Connection object			
			con = Connect.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql3);

			//set values to all parameters
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getSurname());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPassword());

			//execute the SQL statement (INSERT)	
			stmt.executeUpdate();
			
			//close everything to release resources	
			stmt.close();
			Connect.close();		
			
		} catch (Exception e) {
					
					throw new Exception("MySQL Driver error: " + e.getMessage());
					
				} finally {
					
					try {
						Connect.close();
					} catch (Exception e) {
						
					}
		} // End of Try


	} //End of registerUser

} //End of class

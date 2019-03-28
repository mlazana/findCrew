package exercise3_2018_2019_8160057;

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

     //Define the SQL statement (to be executed)
     String sql = "SELECT * FROM users_2018_ex3_8160057 ";

     DB db = new DB();

     List<User> users = new ArrayList<User>();




     try {
			//open connection and get Connection object
			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement( sql );






			// execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				users.add( new User(rs.getString("username"), rs.getString("name"),
										   rs.getString("surname"),rs.getString("email"),
										   rs.getString("password")) );
			}

			rs.close(); // closing ResultSet

			//close everything to release resources
			stmt.close();
			db.close();



	}catch (Exception e) {

	   		  // throw Exception if any error occurs
			  throw new Exception("Could not establish connection with the Database Server: "
			  + e.getMessage());

	}finally{

			try {
				db.close();
			}catch (Exception e){
				// throw Exception if any error occurs
				throw new Exception("Could not establish connection with the Database Server: "
				+ e.getMessage());
			 }

    }


   return users;


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

    //Define the SQL statement (to be executed)
    String sql = "SELECT * FROM users_2018_ex3_8160057 WHERE username = ?; ";
    DB db = new DB();

  User usr = null;

    try {
		   	//open connection and get Connection object
	   		con = db.getConnection();
	   	    PreparedStatement stmt = con.prepareStatement( sql );

             // set values to parameter
			 stmt.setString(1, username);


		   // execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
	   		ResultSet rs = stmt.executeQuery();



		 if (rs.next()){

		usr =  new User(rs.getString("username"), rs.getString("name"),rs.getString("surname"),rs.getString("email"),rs.getString("password"));
             }

           rs.close(); // closing ResultSet
	   		stmt.close(); // closing PreparedStatement
			db.close(); // closing connection

     return usr;




    } catch (Exception e) {

		   			// throw Exception if any error occurs
								throw new Exception("Could not establish connection with the Database Server: "
					+ e.getMessage());

  } finally {

		try {
			db.close();
		}catch (Exception e){
			// throw Exception if any error occurs
			throw new Exception("Could not establish connection with the Database Server: "
			+ e.getMessage());

			}

	      }



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

		    DB db = new DB();
		    Connection con = null;

		     //Define the SQL statement (to be executed)
				   String sql = "SELECT * FROM users_2018_ex3_8160057 WHERE username = ? AND password = ? ";



		    try {
				   		//open connection and get Connection object
	   			   con = db.getConnection();
	   			   PreparedStatement stmt = con.prepareStatement( sql );

	   			   stmt.setString(1, username);
	   			    stmt.setString(2, password);

	   			   // execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
				   	   			ResultSet rs = stmt.executeQuery();

				                  rs.close(); // closing ResultSet


	   			stmt.close();

	   			if (rs != null) {
					db.close();
					return;
			}


       } catch (Exception e) {
	  db.close();
	  		   			// throw Exception if any error occurs
	  					throw new Exception("Wrong username or password"
					+ e.getMessage());
         }


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

	 //Define the SQL statement (to be executed)
	 String sql = "INSERT INTO users_2018_ex3_8160057(username, name, surname, email, password) "
						+ " VALUES (?, ?, ?, ?, ?);";

      DB db = new DB();
    try {
			//open connection and get Connection object
		    con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement( sql );



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
			db.close();

   } catch (Exception e){

		 // throw Exception if any error occurs
		throw new Exception("Could not establish connection with the Database Server: "
		+ e.getMessage());

  } finally {

		try {
			db.close();
		}catch (Exception e){
			// throw Exception if any error occurs
			throw new Exception("Could not establish connection with the Database Server: "
			+ e.getMessage());
          }

	      }



	} //End of registerUser
} //End of class

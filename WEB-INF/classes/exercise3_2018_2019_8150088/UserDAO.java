package exercise3_2018_2019_8150088;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDAO provides all the necessary methods related to user's.
 * Use JDBC API in order to connect the the database and store/retrieve users etc.
 *
 * @author Maria Bartza
 *
 */
public class UserDAO {

	/**
	 * This method returns a List with all Users
	 *
	 * @return List<User>
	 */
	public List<User> getUsers() throws Exception {
		Connection con = null;
		DB db = new DB();
		String sql = "SELECT * FROM users_2018_ex3_8150088;";
		List<User> users = new ArrayList<User>();
		try {
			con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){
				User usr = new User(rs.getString("name"), rs.getString("surname"), rs.getString("email"), rs.getString("username"), rs.getString("password"));
				users.add(usr);
			}

			rs.close();
			stmt.close();
		} catch(Exception e) {

			System.out.println("Error while executing class List<User> getUsers");

		} finally {
			db.close();
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

		Connection con = null;
		DB db = new DB();
		String sql1 = "SELECT * FROM users_2018_ex3_8150088 WHERE username=?;";
		User usr = null;
		try {
			con = db.getConnection();
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setString(1, username);

			ResultSet rs = stmt1.executeQuery();

			if (rs.next()){
				usr = new User(rs.getString("name"), rs.getString("surname"), rs.getString("email"), rs.getString("username"), rs.getString("password"));
			}

			rs.close();
			stmt1.close();
		} catch (Exception e) {
			System.out.println("Error while executing class User findUser");
		} finally {
			db.close();
		}

		return usr;

	} //End of findUser

	/**
	 * Checks if the credentials are valid.
	 *
	 * @param username, String
	 * @param password, String
	 * @throws Exception, if the credentials are not valid
	 */
	public void authenticate(String username, String password) throws Exception {

		Connection con = null;
		DB db = new DB();
		String sql1 = "SELECT * FROM users_2018_ex3_8150088 WHERE username=? AND password=?;";

		try {
			con = db.getConnection();
			PreparedStatement stmt2 = con.prepareStatement(sql1);
			stmt2.setString(1, username);
			stmt2.setString(2, password);

			ResultSet rs = stmt2.executeQuery();

			if (!rs.next()){
				throw new Exception("Wrong username or password");
			}

			rs.close();
			stmt2.close();

		} catch (Exception e) {
			throw new Exception("MySQL error: " + e.getMessage());
		} finally {
			db.close();
		}



	} //End of authenticate

	/**
	 * Register/create a User to the database.
	 *
	 * @param user, User
	 * @throws Exception, if encounter any error.
	 */
	public void registerUser(User user) throws Exception {

		Connection con = null;
		DB db = new DB();
		String sql = "INSERT INTO users_2018_ex3_8150088 (username, name, surname, email, password) "
                            + " VALUES (?, ?, ?, ?, ?);";

		try {
			con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getSurname());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPassword());

			stmt.executeUpdate();

			stmt.close();

		} catch (Exception e) {
			System.out.println("Wrong username or password");
		} finally {
			db.close();
		}


	} //End of registerUser

} //End of class

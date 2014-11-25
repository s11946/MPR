package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;
import domain.User;

public class UserRepository implements IRepository<User> {
	
	private Connection connection;
	
	private String insertSql =
			"INSERT INTO users(login, password)"
			+ "VALUES(?,?)";
	private String selectByIDSql = 
			"SELECT * FROM users WHERE id=?";
	private String updateSql = 
			"UPDATE users SET (login, password)=(?,?) WHERE id=?";
	private String deleteSql =
			"DELETE FROM users WHERE id=?";
	private String selectAllSql = 
			"SELECT * FROM users";
	
	PreparedStatement selectByID;
	PreparedStatement insert;
	PreparedStatement update;
	PreparedStatement delete;
	PreparedStatement selectAll;
	
	public UserRepository(Connection connection){
		this.connection = connection;
		try {
			insert = connection.prepareStatement(insertSql);
			selectByID=connection.prepareStatement(selectByIDSql);
			update=connection.prepareStatement(updateSql);
			delete=connection.prepareStatement(deleteSql);
			selectAll=connection.prepareStatement(selectAllSql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void save(User entity) {
		
		try {
			insert.setString(1, entity.getLogin());
			insert.setString(2, entity.getPassword());
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(User entity) {
		try {
			update.setString(1, entity.getLogin());
			update.setString(2, entity.getPassword());
			update.setInt(3, entity.getId());
			update.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(User entity) {
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

	@Override
	public User get(int id) {
User result = null;
		
		try {
			selectByID.setInt(1, id);
			ResultSet rs = selectByID.executeQuery();
			while(rs.next())
			{
				result = new User();
				result.setId(rs.getInt("id"));
				result.setLogin(rs.getString("login"));
				result.setPassword(rs.getString("password"));
				return result;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public List<User> getAll() {
List<User> result = new ArrayList<User>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				result.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}

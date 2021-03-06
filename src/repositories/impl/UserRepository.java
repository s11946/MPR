package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;
import domain.User;

public class UserRepository extends Repository<User> {
	
	private Connection connection;
	
	protected String insertSql =
			"INSERT INTO users(login, password)"
			+ "VALUES(?,?)";
	
	protected String updateSql = 
			"UPDATE users SET (login, password)=(?,?) WHERE id=?";
	
	public UserRepository(Connection connection, IEntityBuilder<User> builder) {
		super(connection,builder);
	}

	@Override
	protected void setUpUpdateQuery(User entity) throws SQLException {
		update.setString(1, entity.getLogin());
		update.setString(2, entity.getPassword());
		update.setInt(3, entity.getId());
		
	}

	@Override
	protected void setUpInsertQuery(User entity) throws SQLException {
		insert.setString(1, entity.getLogin());
		insert.setString(2, entity.getPassword());
		
	}

	@Override
	protected String getTableName() {
		return "users";
	}

	@Override
	protected String getUpdateQuery() {
		return updateSql;
	}

	@Override
	protected String getInsertQuery() {
		return insertSql;
	}
	
}

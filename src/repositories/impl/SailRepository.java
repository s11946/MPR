package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;
import domain.*;

public class SailRepository extends Repository<Sail> {
	
	protected SailRepository(Connection connection, IEntityBuilder<Sail> builder){
		super(connection, builder);
	}

	@Override
	protected void setUpUpdateQuery(Sail entity) throws SQLException {
		update.setString(1, entity.getName());
		update.setString(2, entity.getType());
		update.setString(3, entity.getMaterial());
		update.setString(4, entity.getInfo());
		update.setDouble(5, entity.getSize());
		update.setInt(6, entity.getId());
		
	}

	@Override
	protected void setUpInsertQuery(Sail entity) throws SQLException {
		insert.setString(1, entity.getName());
		insert.setString(2, entity.getType());
		insert.setString(3, entity.getMaterial());
		insert.setString(4, entity.getInfo());
		insert.setDouble(5, entity.getSize());
		
	}

	@Override
	protected String getTableName() {
		return "sail";
	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE sails SET (name, type, material, info, size)=(?,?,?,?,?) WHERE id=?";
	}

	@Override
	protected String getInsertQuery() {
		return "INSERT INTO sails(name, type, material, info, size)"
				+ "VALUES(?,?,?,?,?)";
	}
	


}

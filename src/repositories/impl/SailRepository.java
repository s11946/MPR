package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;
import domain.*;

public class SailRepository implements IRepository<Sail> {
	
	private Connection connection;
	
	private String insertSql =
			"INSERT INTO sails(name, type, material, info, size)"
			+ "VALUES(?,?,?,?,?)";
	private String selectByIDSql =
			"SELECT * FROM sails WHERE id=?";
	private String updateSql =
			"UPDATE sails SET (name, type, material, info, size)=(?,?,?,?,?) WHERE id=?";
	private String deleteSql = 
			"DELETE FROM sails WHERE id=?";
	private String selectAllSql = 
			"SELECT * FROM sails";
	
	PreparedStatement selectByID;
	PreparedStatement insert;
	PreparedStatement update;
	PreparedStatement delete;
	PreparedStatement selectAll;
	
	public SailRepository(Connection connection){
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
	public void save(Sail entity) {

		try {
			insert.setString(1, entity.getName());
			insert.setString(2, entity.getType());
			insert.setString(3, entity.getMaterial());
			insert.setString(4, entity.getInfo());
			insert.setDouble(5, entity.getSize());
			insert.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Sail entity) {
		try {
			update.setString(1, entity.getName());
			update.setString(2, entity.getType());
			update.setString(3, entity.getMaterial());
			update.setString(4, entity.getInfo());
			update.setDouble(5, entity.getSize());
			update.setInt(6, entity.getId());
			update.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Sail entity) {
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

	@Override
	public Sail get(int id) {
		Sail result = null;
		try {
			selectByID.setInt(1, id);
			ResultSet rs = selectByID.executeQuery();
			while(rs.next()){
				result = new Sail();
				result.setId(rs.getInt("id"));
				result.setName(rs.getString("name"));
				result.setType(rs.getString("type"));
				result.setMaterial(rs.getString("material"));
				result.setInfo(rs.getString("info"));
				result.setSize(rs.getDouble("size"));
				return result;
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Sail> getAll() {
		List<Sail> result = new ArrayList<Sail>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				Sail sail = new Sail();
				sail.setId(rs.getInt("id"));
				sail.setName(rs.getString("name"));
				sail.setType(rs.getString("type"));
				sail.setMaterial(rs.getString("material"));
				sail.setInfo(rs.getString("info"));
				sail.setSize(rs.getDouble("size"));
				result.add(sail);
			}
			} 
		catch (SQLException e){
				e.printStackTrace();
			}
		
		return result;
	}

}

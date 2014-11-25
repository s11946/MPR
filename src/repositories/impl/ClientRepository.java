package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Client;
import repositories.IRepository;

public class ClientRepository implements IRepository<Client>{
	
	private Connection connection;
	
	private String insertSql =
			"INSERT INTO clients(name, surname, company, phonenumber, address, city, postalcode, country)"
			+ "Values (?,?,?,?,?,?,?,?)";
	private String selectByIDSql =
			"SELECT * FROM clients WHERE id=?";
	private String updateSql = 
			"UPDATE clients SET(name, surname, company, phonenumber, address, city, postalcode, country)=(?,?,?,?,?,?,?,?) WHERE id=?";
	private String deleteSql = 
			"DELETE FROM clients WHERE id=?";
	private String selectAllSql = 
			"SELECT * FROM clients";
	
	PreparedStatement selectByID;
	PreparedStatement insert;
	PreparedStatement update;
	PreparedStatement delete;
	PreparedStatement selectAll;
	
	public ClientRepository(Connection connection) {
		this.connection = connection;
		try {
			insert = connection.prepareStatement(insertSql);
			selectByID = connection.prepareStatement(selectByIDSql);
			update = connection.prepareStatement(updateSql);
			delete = connection.prepareStatement(deleteSql);
			selectAll = connection.prepareStatement(selectAllSql);
		}	catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void save(Client entity) {
		try {
			insert.setString(1, entity.getName());
			insert.setString(2, entity.getSurname());
			insert.setString(3, entity.getCompany());
			insert.setString(4, entity.getPhonenumber());
			insert.setString(5, entity.getAddress());
			insert.setString(6, entity.getCity());
			insert.setString(7, entity.getPostalcode());
			insert.setString(8, entity.getCountry());
			insert.executeUpdate();
			} catch (SQLException e){
				e.printStackTrace();
			}
		
	}

	@Override
	public void update(Client entity) {
		try {
			update.setString(1, entity.getName());
			update.setString(2, entity.getSurname());
			update.setString(3, entity.getCompany());
			update.setString(4, entity.getPhonenumber());
			update.setString(5, entity.getAddress());
			update.setString(6, entity.getCity());
			update.setString(7, entity.getPostalcode());
			update.setString(8, entity.getCountry());
			update.executeUpdate();	
		} catch(SQLException e) {
			e.printStackTrace();	
		}
		
	}

	@Override
	public void delete(Client entity) {
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Client get(int id) {
		Client result = null;
		
		try {
			selectByID.setInt(1, id);
			ResultSet rs = selectByID.executeQuery();
			while(rs.next()){
				result = new Client();
				result.setId(rs.getInt("id"));
				result.setName("name");
				result.setSurname("surname");
				result.setCompany("company");
				result.setPhonenumber("phonenumber");
				result.setAddress("address");
				result.setCity("city");
				result.setPostalcode("postalcode");
				result.setCountry("country");
				return result;
			}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
	}

	@Override
	public List<Client> getAll() {
		List<Client> result = new ArrayList<Client>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				Client client = new Client();
				client.setName(rs.getString("name"));
				client.setSurname(rs.getString("surname"));
				client.setCompany(rs.getString("company"));
				client.setPhonenumber(rs.getString("phonenumber"));
				client.setAddress(rs.getString("address"));
				client.setCity(rs.getString("city"));
				client.setPostalcode(rs.getString("postalcode"));
				client.setCountry(rs.getString("country"));
				
				result.add(client);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}

}

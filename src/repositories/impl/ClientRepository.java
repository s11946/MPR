package repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Client;
import repositories.IRepository;

public class ClientRepository extends Repository<Client>{
	
	protected ClientRepository(Connection connection, IEntityBuilder<Client> builder){
		super(connection, builder);
	}

	@Override
	protected void setUpUpdateQuery(Client entity) throws SQLException {
		update.setString(1, entity.getName());
		update.setString(2, entity.getSurname());
		update.setString(3, entity.getCompany());
		update.setString(4, entity.getPhonenumber());
		update.setString(5, entity.getAddress());
		update.setString(6, entity.getCity());
		update.setString(7, entity.getPostalcode());
		update.setString(8, entity.getCountry());
		update.setInt(9, entity.getId());
		
	}

	@Override
	protected void setUpInsertQuery(Client entity) throws SQLException {
		insert.setString(1, entity.getName());
		insert.setString(2, entity.getSurname());
		insert.setString(3, entity.getCompany());
		insert.setString(4, entity.getPhonenumber());
		insert.setString(5, entity.getAddress());
		insert.setString(6, entity.getCity());
		insert.setString(7, entity.getPostalcode());
		insert.setString(8, entity.getCountry());
		
	}

	@Override
	protected String getTableName() {
		return "client";
	}

	@Override
	protected String getUpdateQuery() {
	
		return "UPDATE clients SET(name, surname, company, phonenumber, address, city, postalcode, country)=(?,?,?,?,?,?,?,?)"
				+" WHERE id=?";
	}

	@Override
	protected String getInsertQuery() {
		
		return "INSERT INTO clients(name, surname, company, phonenumber, address, city, postalcode, country)"
				+ "Values (?,?,?,?,?,?,?,?)";
	}
	
	

}

package repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Client;

public class ClientBuldier implements IEntityBuilder<Client> {

	@Override
	public Client build(ResultSet rs) throws SQLException {
		Client client = new Client();
		client.setName(rs.getString("name"));
		client.setSurname(rs.getString("surname"));
		client.setCompany(rs.getString("company"));
		client.setPhonenumber(rs.getString("phonenumber"));
		client.setAddress(rs.getString("address"));
		client.setCity(rs.getString("city"));
		client.setPostalcode(rs.getString("postalcode"));
		client.setCountry(rs.getString("country"));
		return client;
	}

}

package repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Sail;

public class SailBuilder implements IEntityBuilder<Sail> {

	@Override
	public Sail build(ResultSet rs) throws SQLException {
		Sail sail = new Sail();
		sail.setId(rs.getInt("id"));
		sail.setName(rs.getString("name"));
		sail.setType(rs.getString("type"));
		sail.setMaterial(rs.getString("material"));
		sail.setInfo(rs.getString("info"));
		sail.setSize(rs.getDouble("size"));
		return sail;
	}

}

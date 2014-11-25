package repositories.impl;

import java.util.*;

import domain.Role;
import repositories.IRepository;

public class DummyRoleRepository implements IRepository<Role> {
	
	DummyDb db;
	
	public DummyRoleRepository(DummyDb db){
		this.db=db;
	}

	@Override
	public void save(Role entity) {
		db.roles.add(entity);
		
	}

	@Override
	public void update(Role entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Role entity) {
		db.roles.remove(entity);
		
	}

	@Override
	public Role get(int id) {
		for ( Role r : db.roles)
			if(r.getId()==id)
				return r;
		return null;
	}

	@Override
	public List<Role> getAll() {
		return db.roles;
	}

}

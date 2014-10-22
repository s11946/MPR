package repositories.impl;

import java.util.*;

import domain.Client;
import repositories.IRepository;

public class DummyClientRepository implements IRepository<Client> {

	private DummyDb db;
	
	public DummyClientRepository(DummyDb db){
		super();
		this.db = db;
	}

	@Override
	public void save(Client entity) {
		
		db.clients.add(entity);
		
	}

	@Override
	public void update(Client entity) {
		
	}

	@Override
	public void delete(Client entity) {
		db.clients.remove(entity);
		
	}

	@Override
	public Client get(int id) {
		for(Client c: db.clients)
			if(c.getId()==id)
				return c;
		return null;
	}

	@Override
	public List<Client> getAll() {
		return db.clients;
	}

}

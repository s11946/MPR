package repositories.impl;

import java.util.List;

import domain.Sail;
import repositories.IRepository;



public class DummySailRepository implements IRepository<Sail> {
	
	DummyDb db;
	
	public DummySailRepository(DummyDb db){
		this.db=db;
	}

	@Override
	public void save(Sail entity) {
		db.sails.add(entity);
		
	}

	@Override
	public void update(Sail entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Sail entity) {
		db.sails.remove(entity);
		
	}

	@Override
	public Sail get(int id) {
		for (Sail s : db.sails)
			if(s.getId()==id)
				return s;
		return null;
	}

	@Override
	public List<Sail> getAll() {
		return db.sails;
	}

}

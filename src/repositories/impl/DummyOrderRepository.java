package repositories.impl;

import java.util.*;

import domain.Order;
import repositories.IRepository;

public class DummyOrderRepository implements IRepository<Order> {
	
	DummyDb db;
	
	public DummyOrderRepository(DummyDb db){
		this.db=db;
	}

	@Override
	public void save(Order entity) {
		db.orders.add(entity);
		
	}

	@Override
	public void update(Order entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Order entity) {
		db.orders.remove(entity);
		
	}

	@Override
	public Order get(int id) {
		for ( Order o : db.orders)
			if(o.getId()==id)
				return o;
		return null;
	}

	@Override
	public List<Order> getAll() {
		
		return db.orders;
	}


}

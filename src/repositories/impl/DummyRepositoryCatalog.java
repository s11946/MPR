package repositories.impl;

import domain.Client;
import repositories.*;

public class DummyRepositoryCatalog implements IRepositoryCatalog {

	private DummyDb db = new DummyDb();
	
	@Override
	public IUserRepository getUsers() {
		return new DummyUserRepostiory(db);
	}

	@Override
	public IRepository<Client> getClient() {
		return new DummyClientRepository(db);
	}

}

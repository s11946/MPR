package repositories.impl;

import domain.Client;
import domain.Role;
import repositories.*;

public class DummyRepositoryCatalog implements IRepositoryCatalog {

	 DummyDb db = new DummyDb();
	
	@Override
	public IUserRepository getUsers() {
		return new DummyUserRepostiory(db);
	}

	@Override
	public IRepository<Client> getClient() {
		return new DummyClientRepository(db);
	}

	@Override
	public IRepository<Role> getRoles() {
		return new DummyRoleRepository(db);
	}

}

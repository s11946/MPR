package repositories;

import domain.Client;

public interface IRepositoryCatalog {
	
	public IUserRepository getUsers();
	public IRepository<Client> getClient();

}

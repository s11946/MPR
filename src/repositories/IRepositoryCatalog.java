package repositories;

import domain.*;

public interface IRepositoryCatalog {
	
	public IUserRepository getUsers();
	public IRepository<Client> getClient();
	public IRepository<Role> getRoles();

}

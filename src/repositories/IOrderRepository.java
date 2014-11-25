package repositories;

import java.util.List;
import domain.*;

public interface IOrderRepository extends IRepository<Order> {
	
	public List<Order> withClient(Client client);
	public List<Order> withClientName(String ClientName);
	public List<Order> withClientId(int ClientId);
}

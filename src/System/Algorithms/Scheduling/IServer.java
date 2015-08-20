package System.Algorithms.Scheduling;

public interface IServer {
	
	public void SupplyPull(Object aValue);
	public Object SupplyPush();
}

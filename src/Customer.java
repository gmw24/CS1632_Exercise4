public class Customer {
	private int customerId;
	private String customerName;
	
	public Customer(int id, String n){
		customerId = id;
		customerName = n;
	}
	
	public int getId(){
		return customerId;
	}
	
	public String toString(){
		return "Customer #" + customerId + " : " + customerName;
	}
}
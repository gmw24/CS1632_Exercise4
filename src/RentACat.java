import java.util.*;

public class RentACat {
	
	private ArrayList<Cat> cats = new ArrayList<Cat>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public void addCat(Cat c){
		cats.add(c);
	}
	
	public void addCustomer(Customer c){
		customers.add(c);
	}

	
	public ArrayList<Cat> getCats(){
		return cats;
	}
	
	public ArrayList<Customer> getCustomers(){
		return customers;
	}
	
	public boolean isValidCustomer(int custId){
		boolean valid = false;
		for(int i = 0; i < customers.size(); i++){
			if(customers.get(i).getId() == custId)
				valid = true;
		}
		return valid;
	}
	
	public boolean isValidCat(int catId){
		boolean valid = false;
		for(int i = 0; i < cats.size(); i++){
			if(cats.get(i).getCatId() == catId)
				valid = true;
		}
		return valid;
	}
	
	
	public void init(){
		Cat cat1 = new Cat(1, "Sniffles", 250);
		Cat cat2 = new Cat(2, "Paul", 100);
		Cat cat3 = new Cat(3, "Laundry Basket", 500);
		
		cats.add(cat1);
		cats.add(cat2);
		cats.add(cat3);
		
		Customer cust1 = new Customer(100, "Gabe");
		Customer cust2 = new Customer(101, "Molly");
		
		customers.add(cust1);
		customers.add(cust2);
	}
	
	public String listCats() {
		String s = "";
		
		for(int i = 0; i < cats.size(); i++){
			if(cats.get(i).isAvailable()){
				s += cats.get(i).toString();
				s += "\n";
			}
		}
		
		return s;
	}
	
	public void rentCat(int catId, int custId){
		for(int i = 0; i < cats.size(); i++){
			if(cats.get(i).getCatId() == catId){
				cats.get(i).rentCat(custId);
			}
		}
	}
	
	public void returnCat(int catId){
		for(int i = 0; i < cats.size(); i++){
			if(cats.get(i).getCatId() == catId){
				cats.get(i).returnCat();
			}
		}
	}
}
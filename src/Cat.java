public class Cat {
	private int catId;
	private boolean availableToRent;
	private int rate;
	private String name;
	private int renterId;
	
	public Cat(int cId, String n, int r){
		catId = cId;
		availableToRent = true;
		rate = r;
		name = n;
		renterId = -1;
	}
	
	public void rentCat(int rId){
		renterId = rId;
		availableToRent = false;
	}
	
	public void returnCat() {
		if(renterId == -1) {
			return;
		}
		renterId = -1;
		availableToRent = true;
	}
	
	public boolean isAvailable(){
		return availableToRent;
	}
	
	public int getRenterId(){
		return renterId;
	}
	
	public int getCatId(){
		return catId;
	}
	
	public String toString(){
		return "Cat #" + catId + " : " + name + ", $" + rate + "/day.";
	}
}

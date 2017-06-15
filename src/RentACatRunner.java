import java.util.*;

public class RentACatRunner{
	public static void main (String args[]){
		RentACat renter = new RentACat();
		renter.init();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an option [1, 2, 3, 4]: ");
		int choice = in.nextInt();
		int catId;
		
		while(choice != 4 && choice < 4){
			switch(choice){
				case 1:
					System.out.println(renter.listCats());
				break;
				case 2:
					System.out.println("Enter your user id: ");
					int id = in.nextInt();
					while(!renter.isValidCustomer(id)){
						System.out.println("User does not exist! Enter id: ");
					    id = in.nextInt();
					}
					
					System.out.println("Which cat?: ");
					catId = in.nextInt();
					
					while(!renter.isValidCat(catId)){
						System.out.println("Sorry, that cat is not available. Which cat?: ");
						catId = in.nextInt();
					}
					
					renter.rentCat(catId, id);
				break;
				case 3:
					System.out.println("Which cat?: ");
					catId = in.nextInt();
					
					while(!renter.isValidCat(catId)){
						System.out.println("Sorry, that cat does not exist. Which cat?: ");
						catId = in.nextInt();
					}
					
					renter.returnCat(catId);
				break;
				default:
				break;
			}
			System.out.print("Enter an option [1, 2, 3, 4]: ");
		    choice = in.nextInt();
		}
	}
}
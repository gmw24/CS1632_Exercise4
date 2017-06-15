import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.*;


public class RentACatTest {

    private RentACat rentACat;
	
	@Before
	public void setup(){
		rentACat = new RentACat();
	}
	
	//Test RentACat is initialized with empty cat arrayList
	@Test
	public void testInitCatList(){
		assertEquals(rentACat.getCats().size(), 0);
	}
	
	//Test RentACat is initialized with empty customer arrayList
	@Test
	public void testInitCustomerList(){
		assertEquals(rentACat.getCustomers().size(), 0);
	}
	
	//Test init method creates Cat ArrayList with 3 cats
    @Test
	public void testSetupCatList(){
		rentACat.init();
		assertEquals(rentACat.getCats().size(), 3);
	}
	
 	//Test init method creates Customer ArrayList with 2 customers
	@Test
	public void testSetupCustomerList(){
		rentACat.init();
		assertEquals(rentACat.getCustomers().size(), 2);
	}
	
	//Test RentACat returns empty string if not initialized
	@Test
	public void testEmptyCatList(){
		assertEquals(rentACat.listCats(), "");
	}
	
	//Test that the listCats method returns the toString method of the cats in listCats
	//This test uses stubs and doubles!
	@Test
	public void testListCats(){
		String testString = "I'm just a poor cat!";
		Cat mockCat = mock(Cat.class);
		when(mockCat.isAvailable()).thenReturn(true);
		when(mockCat.toString()).thenReturn(testString);
		rentACat.addCat(mockCat);
		assertEquals(rentACat.listCats(), testString + "\n");
	}
	
	//Tests method checking to see whether an invalid customer does not exist
	@Test
	public void testisInvalidCustomer(){
		rentACat.init();
		assertEquals(rentACat.isValidCustomer(0), false);
	}
	
	//Tests method checking to see whether a valid customer
	@Test
	public void testisValidCustomer(){
		rentACat.init();
		assertEquals(rentACat.isValidCustomer(100), true);
	}
	
	//Tests renting a valid cat to a valid customer
	//This test uses stubs and doubles
	@Test
	public void testRentCat() {
		Cat mockCat = mock(Cat.class);
		Customer mockCustomer = mock(Customer.class);
		when(mockCustomer.getId()).thenReturn(1);
		when(mockCat.getCatId()).thenReturn(1);
		rentACat.addCat(mockCat);
		rentACat.addCustomer(mockCustomer);
		rentACat.rentCat(1, 1);
		verify(mockCat).rentCat(1);
	}
	
	//Tests renting an invalid cat to a customer
	@Test
	public void testBadRentCat() {
		Cat mockCat = mock(Cat.class);
		Customer mockCustomer = mock(Customer.class);
		when(mockCustomer.getId()).thenReturn(1);
		when(mockCat.getCatId()).thenReturn(1);
		rentACat.addCat(mockCat);
		rentACat.addCustomer(mockCustomer);
		rentACat.rentCat(2, 1);
		verify(mockCat, never()).rentCat(1);
	}
	
	//Tests returning a valid cat from a valid customer
	@Test
	public void testReturnCat() {
		Cat mockCat = mock(Cat.class);
		Customer mockCustomer = mock(Customer.class);
		when(mockCustomer.getId()).thenReturn(1);
		when(mockCat.getCatId()).thenReturn(1);
		rentACat.addCat(mockCat);
		rentACat.addCustomer(mockCustomer);
		rentACat.returnCat(1);
		verify(mockCat).returnCat();
	}

	//Tests returning an invalid cat from a customer
	@Test
	public void testReturnBadCat() {
		Cat mockCat = mock(Cat.class);
		Customer mockCustomer = mock(Customer.class);
		when(mockCustomer.getId()).thenReturn(1);
		when(mockCat.getCatId()).thenReturn(1);
		rentACat.addCat(mockCat);
		rentACat.addCustomer(mockCustomer);
		rentACat.returnCat(2);
		verify(mockCat, never()).returnCat();
	}
}
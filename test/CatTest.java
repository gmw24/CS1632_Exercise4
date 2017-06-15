import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.*;

public class CatTest {
	
	Cat cat;
	
	@Before
	public void setup() {
		cat = new Cat(1, "Kitty", 100);
	}
	
	//Test all values are initialized correctly through the toString method
	@Test
	public void testInit() {
		assertEquals(cat.toString(), "Cat #1 : Kitty, $100/day.");
	}

	//Test that when a cat is rented, it's renterId and associated availability is changed
	@Test
	public void testRentCat() {
		cat.rentCat(100);
		assertEquals(cat.getRenterId(), 100);
		assertEquals(cat.isAvailable(), false);
	}
	
	//Test that returning a cat resets it's renters id and makes it available again
	@Test
	public void testReturnCat() {
		cat.returnCat();
		assertEquals(cat.getRenterId(), -1);
		assertEquals(cat.isAvailable(), true);
	}
}



import static org.junit.Assert.*;

import org.junit.Test;

public class TestATM {

	@Test
	public void testDB() {
		Database db = new Database(1234,1234);
		double balance = db.getBalance();
		System.out.println(balance);
		assertEquals(164.0,balance,0.01);
	}

}

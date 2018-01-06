

import static org.junit.Assert.*;

import org.junit.Test;

public class TestATM {

	@Test
	public void testDB() {
		Database db = new Database(1234,1234);
		assertEquals(164.0,db.getBalance());
	}

}

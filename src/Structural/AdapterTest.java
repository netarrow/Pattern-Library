package Structural;

import org.junit.*;

import static org.junit.Assert.*;

/*
 * Structural Pattern
 * Adapt the interface of an object to another interface
 */

interface Target { // interface I want use
	int request();
}

class Adaptee { // interface i want adapt to target
	public int requestToAdapt() {
		return 0;
	}
}

class Adapter extends Adaptee implements Target { // adapter who support both target and adaptee

	@Override
	public int request() {
		return requestToAdapt() + 1; // wrap the request to adapt in the target interface (eventyally change behavior)
	}
	
}

public class AdapterTest {
	
	@Test
	public void testAdapter() {
		Target target = new Adapter();
		assertEquals(target.request(), 1);
		assertEquals( ( (Adaptee) target ).requestToAdapt(), 0 );
	}
	
}





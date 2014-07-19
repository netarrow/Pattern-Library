package Behavioral;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Behavioral Pattern
 * The Chain of Responsibility pattern works with a list of Handler objects that have limitations on the nature
 * of the requests they can deal with. If an object cannot handle a request, it passes it on to the next object in the chain.
 * At the end of the chain, there can be either default or exceptional behavior. 
 *
 */

class ChainException extends Exception {

	private static final long serialVersionUID = -7230182678831928857L;

}

interface Handler { // rapresent an handler: the interface of an object which can manage a specific request
	Handler getNextHandler();
	String handle(int request) throws ChainException;
}

class RealHandler implements Handler { // implements the handler and manage a request, has a reference to an eventyally alternative handler (the chain)

	private int myLimit = 0;
	private Handler next = null;
	
	RealHandler(Handler next, int myLimit) {
		this.next = next;
		this.myLimit = myLimit;
	}
	
	@Override
	public Handler getNextHandler() {
		return next;
	}

	@Override
	public String handle(int request) throws ChainException {
		if(request > myLimit)
			if(next != null)
				return next.handle(request);
			else
				throw new ChainException();
		else
			return "done in limit " + myLimit;
	}
	
}

public class ChainOfResponsabilityTest {
	
	@Test
	public void testChainOfResponsability() throws ChainException {
		RealHandler h2 = new RealHandler(null, 15);
		RealHandler h1 = new RealHandler(h2, 10);
		
		assertEquals(h1.handle(5), "done in limit 10");
		assertEquals(h1.handle(12), "done in limit 15");
		
		boolean errorThrown = false;
		
		try {
			assertEquals(h1.handle(20), "done in limit 15");
		} catch (ChainException e) {

			errorThrown = true;
		}
		
		assertTrue(errorThrown);
	}
	
}

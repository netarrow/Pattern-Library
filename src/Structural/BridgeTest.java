package Structural;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Structural Pattern
 * Separate the interface of an object from its implementation
 */

interface Bridge {
	String operation(); // abstract operation
}

class ImplementationA implements Bridge { // concrete operation

	@Override
	public String operation() {
		return "ImplementationA";
	}
	
}

class ImplementationB implements Bridge { // concrete operation

	@Override
	public String operation() {
		return "ImplementationB";
	}
	
}

class Abstraction implements Bridge { // wrap the implementation in a class 

	private Bridge bridge;

	Abstraction(Bridge bridge) {
		this.bridge = bridge;
	}
	
	@Override
	public String operation() {
		return bridge.operation();
	}
}

public class BridgeTest {
	@Test
	public void testBridge() {
		Abstraction abstraction1 = new Abstraction(new ImplementationA());
		Abstraction abstraction2 = new Abstraction(new ImplementationB());
		
		assertEquals(abstraction1.operation(), "ImplementationA");
		assertEquals(abstraction2.operation(), "ImplementationB");
		
	}
}
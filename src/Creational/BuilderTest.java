package Creational;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

/*
 * Creational Pattern
 * Separate the specification of a complex object from its own actual creation
 */

interface Builder { // interface to build an object and get the result
	void buildPartA();
	void buildPartB();
	Product getResult();
}

class Builder1 implements Builder { // a builder which describe how to build object part and assembly them
	Product p = new Product();
	
	@Override
	public void buildPartA() {
		p.parts.add("fondamenta");
	}

	@Override
	public void buildPartB() {
		p.parts.add("tetto");
	}

	@Override
	public Product getResult() {
		return p;
	}
	
}

class Product { // the object to build using the builder
	public Vector<String> parts = new Vector<String>();
}

public class BuilderTest {
	@Test
	public void testBuilder() {
		Builder builder = new Builder1();
		builder.buildPartA();
		builder.buildPartB();
		
		assertEquals(builder.getResult().parts.elementAt(0), "fondamenta");
		assertEquals(builder.getResult().parts.elementAt(1), "tetto");
	}
}

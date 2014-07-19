package Structural;

import org.junit.Test;


/*
 * Structural Pattern
 * 
 * The role of the Decorator pattern is to provide a way of attaching new state and behavior to an object dynamically. 
 * The object does not know it is being �deco- rated,� which makes this a useful pattern for evolving systems. 
 * A key implementation point in the Decorator pattern is that decorators both inherit the original class and contain an instantiation of it.
 */

interface ComponentToDecorate { // the interface to decorate
	void operation();
}

class RealComponent implements ComponentToDecorate { // the real object to decorate

	@Override
	public void operation() {
		System.out.println("normal behavior");
	}
}

class Decorator implements ComponentToDecorate { // a decorator has the same decorated interface
	private ComponentToDecorate component;
	
	Decorator(ComponentToDecorate toDec) { // has a reference to the object to decorate
		component = toDec;
	}
	
	@Override
	public void operation() { // can add behavior to specific method
		component.operation(); // call the base behavior
		System.out.println("decored! do some other things!"); // add new
	}
	
	public void newBehavior() { // or add new one
		System.out.println("new behavior!");
	}
	
}

public class DecoratorTest {
	@Test
	public void testDecorator() {
		ComponentToDecorate baseComponent = new RealComponent();
		baseComponent.operation();
		Decorator dec = new Decorator(baseComponent);
		dec.operation();
		dec.newBehavior();
	}
}

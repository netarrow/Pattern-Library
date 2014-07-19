package Structural;

import java.util.Vector;

import org.junit.Test;

/*
 * Structural Pattern
 * 
 * The Composite pattern arranges structured hierarchies so that single 
 * components and groups of components can be treated in the same way. 
 * Typical operations on the components include add, remove, display, find, and group.
 */

interface Component { // common interface between leaf and group
	String getName();
	void show();
}

class Leaf implements Component { //the leaf
	
	private String name;

	Leaf(String name) {	
		this.name = name;
	}
	
	@Override
	public void show() {
		System.out.println(name);
	}

	@Override
	public String getName() {
		return name;
	}
	
}

class Group implements Component { // the group
	private Vector<Component> list; // the group has reference to a list of generic Command (leaf or other groups)
	private String name;

	Group(String name) {
		this.name = name;
		list = new Vector<Component>();
	}
	
	@Override
	public void show() {
		System.out.println(name);
		for(Component c : list)
			c.show();
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void add(Component component) {
		list.add(component);
	}
}

public class CompositeTest {
	@Test
	public void testComposite() {
		Leaf leaf = new Leaf("Child");
		Leaf leaf2 = new Leaf("Child2");
		Group parent = new Group("Parent");
		Group parent2 = new Group("Parent2");
		parent.add(leaf);
		parent.add(leaf2);
		parent.add(parent2);
		parent2.add(leaf);
		parent.show();
	}
}

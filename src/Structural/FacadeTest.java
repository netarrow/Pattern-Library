package Structural;

import org.junit.Test;

class SubsystemA { 
	String a1() {
        return "Subsystem A, Method A1\n";
     }

	String a2() {
		return "Subsystem A, Method A2\n";
	} 
}

class SubsystemB { 
	String b1() {
        return "Subsystem B, Method B1\n";
    }
}

class SubsystemC { 
	String c1() {
        return "Subsystem C, Method C1\n";
	}
} 

class Facade {
	static SubsystemA a = new SubsystemA(); 
	static SubsystemB b = new SubsystemB(); 
	static SubsystemC c = new SubsystemC();
	
	public static void operation1() { 
		System.out.println("Operation 1\n" + a.a1() + a.a1() + b.b1( ));
	}
		
	public static void operation2() { 
		System.out.println("Operation 2\n" + b.b1() + c.c1( )); 
	}

}

public class FacadeTest {
	
	@Test
	public void testFacade() {
		Facade.operation1();
		Facade.operation1();
		
	}
}

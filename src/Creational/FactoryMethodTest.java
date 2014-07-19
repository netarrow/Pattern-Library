package Creational;

import org.junit.Test;

/**
 * The Factory Method pattern is a way of creating objects, but letting subclasses decide exactly which class to instantiate.
 * Various subclasses might implement the interface; the Factory Method instantiates the appropriate subclass based on information supplied by the client or extracted from the current state.
 *
 */

interface GenericProduct {
    String info();
}

class RealProductA implements GenericProduct {

    @Override
    public String info() {
        return "RealA";
    }
}

class RealProductB implements GenericProduct {

    @Override
    public String info() {
        return "RealB";
    }
}

class Creator {
    public GenericProduct factoryMethod(int disc) {
        if(disc % 2 == 0)
            return new RealProductA();
        else return new RealProductB();
    }
}

public class FactoryMethodTest {
    @Test
    public void testFactoryMethod() {
        Creator creator = new Creator();
        System.out.println(creator.factoryMethod(0).info());
        System.out.println(creator.factoryMethod(1).info());
        System.out.println(creator.factoryMethod(2).info());
    }
}

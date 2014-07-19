package Creational;

import org.junit.Test;

/**
 * This pattern supports the creation of products that exist in families and are designed to be produced together.
 * The abstract factory can be refined to concrete factories, each of which can create different products of different types and in different combinations.
 * The pattern isolates the product definitions and their class names from the client so that the only way to get one of them is through a factory. For this reason, product
 * families can easily be interchanged or updated without upsetting the structure of the client
 */

interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}


interface AbstractProductA {
    void productInfoA();
}

interface AbstractProductB {
    void productInfoB();
}

class ProductA implements AbstractProductA {
    String a = "A";

    ProductA(String a) {
        this.a = a;
    }

    @Override
    public void productInfoA() {
        System.out.println(a);
    }
}


class ProductB implements AbstractProductB {
    String b = "B";

    ProductB(String b) {
        this.b = b;
    }

    @Override
    public void productInfoB() {

        System.out.println(b);
    }
}

class FactoryA implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA("AA");
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB("AB");
    }
}

class FactoryB implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA("BA");
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB("BB");
    }
}

public class AbstractFactoryTest {

    @Test
    public void testAbstractFactory() {
        FactoryA fa = new FactoryA();
        fa.createProductA().productInfoA();
        fa.createProductB().productInfoB();

        FactoryB fb = new FactoryB();
        fb.createProductA().productInfoA();
        fb.createProductB().productInfoB();


    }
}

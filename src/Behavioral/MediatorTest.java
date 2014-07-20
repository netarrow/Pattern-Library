package Behavioral;

import org.junit.Test;

import java.util.Vector;

/**
 *  Defines simplified communication between classes. Define an object that encapsulates how a set of objects interact.
 *  Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently.
 */

interface Subscriber {
    void notify(String message, String from);
}


class Mediator {
    public Vector<Subscriber> subscribers;

    Mediator() {
        subscribers = new Vector<Subscriber>();
    }

    public void send(String message, String from) {
        for(Subscriber sub : subscribers) {
            sub.notify(message, from);
        }
    }

}

class User implements  Subscriber {

    private final Mediator m;
    private String name;

    public User(Mediator m, String name) {
        this.m = m;
        this.m.subscribers.add(this);
        this.name = name;
    }

    @Override
    public void notify(String message, String from) {
        if(!from.equals(this.name))
            System.out.println(String.format("Messaggio da %s: %s", from, message));
    }

    public void send(String message) {
        m.send(message, this.name);
    }
}

class Unpleasan implements Subscriber {

    private final Mediator m;
    private final String name;

    public Unpleasan(Mediator m, String name) {
        this.m = m;
        this.m.subscribers.add(this);
        this.name = name;
    }

    @Override
    public void notify(String message, String from) {
        if(!from.equals(this.name))
            System.out.println(String.format("%s sto cazzo %s", message, from));
    }
}

public class MediatorTest {
    @Test
    public void testMediator() {
        Mediator m = new Mediator();
        User pinco = new User(m, "pinco");
        User pallino = new User(m, "pallino");
        Unpleasan a = new Unpleasan(m, "jerk");
        pinco.send("buongiorno");
        pallino.send("heilà");
    }
}

package Behavioral;

import org.junit.Test;

/**
 * The UML class diagram for the Strategy pattern is the same as the diagram for the Bridge pattern. However, these two design patterns aren't the same in their intent.
 * While the Strategy pattern is meant for behavior, the Bridge pattern is meant for structure.
 The coupling between the context and the strategies is tighter than the coupling between the abstraction and the implementation in the Bridge pattern.

 */

interface Strategy {
    int doSomething(int a);
}

class Behavior1 implements Strategy {

    @Override
    public int doSomething(int a) {
        return a + a;
    }


}

class Behavior2 implements Strategy {

    @Override
    public int doSomething(int a) {
        return a*a;
    }
}

class StrategyContext  {

    Strategy strategy;

    StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    void changeBehavior(Strategy strategy) {
        this.strategy = strategy;
    }

    int applyStrategy(int a) {
       return this.strategy.doSomething(a);
    }

}

public class StrategyPatternTest {
    Strategy strategy;
    @Test
    public void testStrategy() {
        StrategyContext ctx = new StrategyContext(new Behavior1());
        for(int i = 0; i< 100; i++) {
            if(i % 2 == 0)
                ctx.changeBehavior(new Behavior2());
            else ctx.changeBehavior(new Behavior1());

            int result = ctx.applyStrategy(i);

            System.out.println(result);
        }
    }
}

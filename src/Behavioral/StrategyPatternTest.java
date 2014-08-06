package Behavioral;

import org.junit.Test;

import java.util.Collection;
import java.util.List;

/**
 * The UML class diagram for the Strategy pattern is the same as the diagram for the Bridge pattern. However, these two design patterns aren't the same in their intent.
 * While the Strategy pattern is meant for behavior, the Bridge pattern is meant for structure.
 The coupling between the context and the strategies is tighter than the coupling between the abstraction and the implementation in the Bridge pattern.

 */

interface Strategy {
    Collection Sort(Collection collection);
}

class QuickSort implements Strategy {

    @Override
    public Collection Sort(Collection collection) {
        return null;
    }


}

class MergeSort implements Strategy {

    @Override
    public Collection Sort(Collection collection) {
        return null;
    }
}


public class StrategyPatternTest {
    Strategy strategy;
    @Test
    public void testStrategy() {

    }
}

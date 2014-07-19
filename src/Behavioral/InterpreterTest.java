package Behavioral;

import org.junit.Test;

/**
 *  The Interpreter pattern supports the interpretation of instructions written in a language or notation defined for a specific purpose.
 *  The notation is precise and can be defined in terms of a grammar.
 */

class Context
{
    public String Name;

    public Context(String name)
    {
        Name = name;
    }
}

interface ExpressionBase // Interpreter is based on a composite to desing the expression tree
{
    public int Interpret(Context context);
}


class NumberExpression implements ExpressionBase {

    private final String n;

    NumberExpression(String n) {
        this.n = n;
    }

    public int Interpret(Context context)  {
        return Integer.parseInt(n);
    }
}


class SumExpression implements ExpressionBase {

    public ExpressionBase Expression1;
    public ExpressionBase Expression2;

    public int Interpret(Context context) {
        return Expression1.Interpret(context) + Expression2.Interpret(context);
     }
}


public class InterpreterTest
{
    @Test
    public void testInterpreter()
    {
        Context context = new Context("the context");


        // expression tree can be build by a parser, parsing not involved by interpreter pattern
        SumExpression root = new SumExpression();

        SumExpression childSum = new SumExpression();
        childSum.Expression1 = new NumberExpression("1");
        childSum.Expression2 = new NumberExpression("1");

        root.Expression1 = new NumberExpression("5");
        root.Expression2 = childSum;

        int result = root.Interpret(context);
        System.out.println(result);

    }
}
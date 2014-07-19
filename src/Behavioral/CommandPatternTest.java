package Behavioral;

import org.junit.Test;

/*  
    Behavioral Pattern
    
	Allows us to achieve complete decoupling between the sender and the receiver. 
	A sender is an object that invokes an operation, and a receiver is an object that receives the request to execute a certain operation. 
	With decoupling, the sender has no knowledge of the Receiver's interface.
    
    This pattern is particularly versatile. It can support:
	� Sending requests to different receivers
	� Queuing, logging, and rejecting requests
	� Composing higher-level transactions from primitive operations
	� Redo and Undo functionality
	
 */

interface Command {
	void execute(); // a generic command interface
}

class Invoker { // an invoker, wrap the command invocation
	private Command commandA;
	
	Invoker(Command a) {
		commandA = a;
	}
	
	void invokeCommand() {
		commandA.execute();
	}
}

class ReceiverA { // the class which actually execute the required action
	void action() {
		System.out.println("A");
	}
}

class ConcreteCommand implements Command { // a concrete command which execute a specified instance of a Receiver

	private ReceiverA receiver;
	
	ConcreteCommand(ReceiverA receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.action();
	}
	
}

public class CommandPatternTest {
	@Test
	public void commandPatternTest() {
		ConcreteCommand cmd = new ConcreteCommand(new ReceiverA());
		
		Invoker inv = new Invoker(cmd);
		inv.invokeCommand();
	}
}
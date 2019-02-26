package org.txstate.auto_scheduler;

public class OperationContextParser {
	
	public OperationContext getOperationContext(String[] args) 
	{
		if(args.length == 2) {
			if(args[0] == "--schedule" && !args[1].isEmpty()) {
				return new OperationContext(OperationContext.OperationCode.Schedule, args[1]);
			}
			if(args[0] == "--peek" && !args[1].isEmpty()) {
				return new OperationContext(OperationContext.OperationCode.Peek, args[1]);
			}
		}
		else if(args.length == 3) {
			if(args[0] == "--cancel" && !args[1].isEmpty() && !args[2].isEmpty()) {
				return new OperationContext(OperationContext.OperationCode.Cancel, args[1], args[2]);
			}
			if(args[0] == "--select" && !args[1].isEmpty() && !args[2].isEmpty()) {
				return new OperationContext(OperationContext.OperationCode.Select, args[1], args[2]);
			}
		}
		return null;
	}
}

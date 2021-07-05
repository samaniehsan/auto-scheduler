package org.txstate.auto_scheduler;

/**
 * OperationContextParser.java : Will determine the length of args and will determine which path to take
 * @param String[] args
 * @return null
 * @version 1.0
 * @since   5-2-2019
 */
public class OperationContextParser {
	
	public OperationContext getOperationContext(String[] args) 
	{
		if(args.length == 2) {			
			if("--schedule".equalsIgnoreCase(args[0])) {	
				if(!args[1].isEmpty()) {
					return new OperationContext(OperationContext.OperationCode.Schedule, args[1]);
				}
			}
			if("--dry-run".equalsIgnoreCase(args[0])) {
				if(!args[1].isEmpty()) {
					return new OperationContext(OperationContext.OperationCode.DryRun, args[1]);
				}
			}
			if("--show".equalsIgnoreCase(args[0]) && !args[1].isEmpty()) {
				return new OperationContext(OperationContext.OperationCode.Show, args[1]);
			}
			if("--cancel".equalsIgnoreCase(args[0]) && !args[1].isEmpty()) {
				return new OperationContext(OperationContext.OperationCode.Cancel, args[1]);
			}
		}
		return null;
	}
}

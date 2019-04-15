package org.txstate.auto_scheduler;

public class Main {

	public Main () {
	}
	
	public static void main(String[] args) {
		OperationContextParser parser = new OperationContextParser();
		OperationContext opContext = parser.getOperationContext(args);
		
		try {
			if(opContext == null)
				printUsage();
			else {
				OperationServiceFactory factory = new OperationServiceFactory();
				factory.get(opContext).execute(opContext);
			}
		} catch( Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	private static void printUsage() {
		System.out.println("java org.txstate.auto_scheduler usage");
		System.out.println("java org.txstate.auto_scheduler --schedule AXYZID");
		System.out.println("java org.txstate.auto_scheduler --peek AXYZID");
		System.out.println("java org.txstate.auto_scheduler --select AXYZID Set1");
		System.out.println("java org.txstate.auto_scheduler --cancel AXYZID Set1");
	}
}

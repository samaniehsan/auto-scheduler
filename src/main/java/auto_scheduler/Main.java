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
		} catch (StudentNotFoundException e) {
			e.printStackTrace(System.err);
			System.err.println("----");
			System.err.println(
				String.format(
					"Could not Find Student:%s",
					e.getStudentId())
				);
		} catch (InvalidMajorException e) {
			e.printStackTrace(System.err);
			System.err.println("----");
			System.err.println(
				String.format(
					"Could not Find Major:%s",
					e.getMajor())
				);
		}
		catch( Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	private static void printUsage() {
		System.out.println("java auto_scheduler-1.0.jar usage");
		System.out.println("java auto_scheduler-1.0.jar --schedule AXYZID");
		System.out.println("java auto_scheduler-1.0.jar --dry-run AXYZID");
		System.out.println("java auto_scheduler-1.0.jar --show AXYZID");
		System.out.println("java auto_scheduler-1.0.jar --cancel AXYZID");
	}
}

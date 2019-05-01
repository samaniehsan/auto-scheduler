package org.txstate.auto_scheduler;

import org.txstate.auto_scheduler.ScheduleSet;

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
				ScheduleSet scheduleResult = factory.get(opContext).execute(opContext);
				if(scheduleResult != null) {
					String resultString = scheduleResult.toString();
					System.out.print(resultString);
				}
			}
		} catch (NoScheduleFoundException e) {
			e.printStackTrace(System.err);
			System.err.println("----");
			System.err.println(
				String.format(
					"Scheduling Error for StudentId:%s",
					e.getStudentId())
				);
			System.exit(1);
		} catch (StudentNotFoundException e) {
			e.printStackTrace(System.err);
			System.err.println("----");
			System.err.println(
				String.format(
					"Could not Find Student:%s",
					e.getStudentId())
				);
			System.exit(2);
		} catch (InvalidMajorException e) {
			e.printStackTrace(System.err);
			System.err.println("----");
			System.err.println(
				String.format(
					"Could not Find Major:%s",
					e.getMajor())
				);
			System.exit(3);
		}
		catch( Exception e) {
			e.printStackTrace(System.err);
			System.exit(4);
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

import java.util.Scanner;

public class Employee extends MeetingRoom {
public int age; 
public String Designation;
public int salary;
public String Department;
public String reportsTo;



 public void showDetails(){
	System.out.println("Designation:"+this.getClass()+" "+"age:"+age+" "+"Salary:"+salary+" "+"Department:"+Department+" "+"reportsTo:"+reportsTo);
    }
 public void getDetails(){
	 Scanner scan = new Scanner(System.in);
	 System.out.println("Enter Age:");
	 age=scan.nextInt();
	}
}

/**
 *  Office Database
 * Employee - Clerk, Manager, Sr Manager
 *  Name, Age, Designation, salary,department, reportsTo  
 *  
 * Each class to have these methods
 * work();
 * 
 * Clerk' work - bring tea, clean office
 * Manager work - approveRequests, report to senior
 * 
 * Sr Manager work - approve requests, report to senior.
 */
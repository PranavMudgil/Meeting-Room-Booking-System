import java.util.Scanner;

public class MeetingRoom_BookingSystem {
  public static void main(String[] args){
	  boolean booked;     			
	  int startTime,endTime,seats;
	  int userChoice1;
	  Employee activeUser = new Employee();
	  Scanner scan = new Scanner(System.in);
	  int userChoice2=0;
	  while(userChoice2==0){
	  System.out.println("1)choose a specific Meeting Room and Select an available Time Slot 2)Get Room According to your time Slot ");
	  userChoice1=scan.nextInt();
	  if(userChoice1==2)
	  {
	  System.out.println("Enter Starting Time and End Time(2400 format) ");
	  startTime=scan.nextInt();
	  endTime=scan.nextInt();
	  activeUser.availableRooms(startTime,endTime);
	  System.out.println("Enter roomId to book(1-50):");
	  int roomNo = scan.nextInt();
	  System.out.println("No. of Seats:");
	  seats = scan.nextInt();
	  booked= activeUser.bookRoom(startTime, endTime, roomNo,seats);
	  /*availableRooms in this time slot*/
	  if(booked==true){
		  System.out.println("Congrats!");
		  
	  }
	  if(booked==false){
		  System.out.println("Error!try again");
		  continue ;
	  }
	  System.out.println("Wish to Book Another Room?(yes=1/no=0):");
	  int userChoice3=scan.nextInt();
	  if(userChoice3==1){
		  continue ;
	  }else{
		  break;
	  }
	
	 }else if (userChoice1==1){
		  System.out.println("Enter Room you want to see timings of:");
		  int specificRoom=scan.nextInt();
		  activeUser.getTimings(specificRoom);
		  System.out.println("Enter Starting Time and End Time from the timings(2400 format)");
		  startTime=scan.nextInt();
		  endTime=scan.nextInt();
		  System.out.println("No. of Seats:");
		  seats = scan.nextInt();
		  booked=activeUser.bookSpecificRoom(startTime,endTime,specificRoom,seats);
		  if(booked==true){
			  System.out.println("Booking Successfull Congrats!");
			  
			  
		  }else 
		   {
		    System.out.println("Error Occured \nTry again");
		   continue ;
		    
		   }
		  System.out.println("Wish to Book Another Room?(yes=1/no=0):");
		  int userChoice3=scan.nextInt();
		  if(userChoice3==1){
			  continue ;
		  }else{
			  break;
		   }
	   }
	 }
  }
}
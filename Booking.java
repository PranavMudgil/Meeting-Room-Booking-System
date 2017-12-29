import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Booking{
	ArrayList<MeetingRoom> list=new ArrayList<MeetingRoom>(); 
	int[] filledRoom=new int[50];

	
	public void availableRooms(int startTime,int endTime){
		int[] availRooms= new int[20];				//Array to store 
		int size= getLength(filledRoom);
		if(size==0)
		{
			System.out.println("All the rooms are available for you(1-20)");
			return;
		}
	   
		System.out.println("Available Rooms According to your time:");
		for(MeetingRoom r:list){
			
			if((r.startTime<=startTime&&startTime<=r.endTime)||r.startTime<=endTime&&endTime<=r.endTime||(r.startTime<=startTime&&startTime<r.endTime)&&(r.startTime<endTime&&endTime<=r.endTime)){
				availRooms[r.roomId]=1;
				 continue;
			}else{
				availRooms[r.roomId]=0;
			}
	    }
		for(int i=0;i<availRooms.length;i++){
			if(availRooms[i]!=1){
			System.out.print(i+" ");
			}
		}
		System.out.println("\n");
		
	}
	public void displayList(){
		Collections.sort(list, new Comparator<MeetingRoom>() {
		    public int compare(MeetingRoom m1, MeetingRoom m2) {
		        return m1.roomId-m2.roomId;
		    }
		});
		for(@SuppressWarnings("unused") MeetingRoom trav:list){
			System.out.println(list);
		}
		}
	
	public void getTimings(int id){
		System.out.println("Timings Availsble:");
		ArrayList<Integer> timeKeeping=new ArrayList<Integer>();         					    //for Storing Starting and Ending time
		
		int i=0;
		if(list.isEmpty()==true){				//if first room is being booked
			System.out.println("You can book any time you want.");
			return;
		}
	  for(MeetingRoom t:list){
		  if(t.roomId==id){ 					   //if Booked room is found with the same room number
			  timeKeeping.add(t.startTime);
			 // System.out.println(t.startTime+" "+t.endTime);
			  timeKeeping.add(t.endTime);
			//  System.out.println(i);
			  
		  }else{
		     continue;
	  
		  } 
	  }
	  int size=timeKeeping.size();
	  //size=size-1;
	  System.out.println(size);
	  if(size==0){     							 //if no room is booked with the same room number before
		System.out.println("You can book any time you want.");
		return;
	  }else{
	 
		  Collections.sort(timeKeeping);
	 
	  if(timeKeeping.get(0)!=0){
		  System.out.println("0-"+timeKeeping.get(0));
		 }
	
	  i=i-1;
	 
	  if(size==2){										//if the room is booked only once before
		  System.out.println(timeKeeping.get(1)+"-2400");
		  return;
	}else{												
		for(int j=1;j<=size-1;j=j+2){
			if(j==size-1){
				System.out.print(timeKeeping.get(j));
				break;
			}
			System.out.println(timeKeeping.get(j)+"-"+timeKeeping.get(j+1));
		}
		System.out.println("-2400");
	}
  }
}
 
	 public boolean bookSpecificRoom(int startTime,int endTime,int roomNo,int seats){
		   boolean status = false;
		   int[] arr= new int[20];
		   for(MeetingRoom r:list){
				
				if((r.startTime<=startTime&&startTime<=r.endTime)||r.startTime<=endTime&&endTime<=r.endTime||(r.startTime<=startTime&&startTime<r.endTime)&&(r.startTime<endTime&&endTime<=r.endTime)){
					arr[r.roomId]=1;
					 continue;
				}else{
					arr[r.roomId]=0;
				}
		    }if(arr[roomNo]==1){
		    	System.out.println("Room already booked in this time slot .Try another timings");
		    	return status;
		    }
		   MeetingRoom newRoom=new MeetingRoom();
		   newRoom.startTime=startTime ;newRoom.endTime=endTime;newRoom.roomId=roomNo;newRoom.seats=seats;
		   list.add(newRoom);
		   this.filledRoom[roomNo]++;
		   status=true;
		   return status;
		   }		  
		   
	 
     public boolean bookRoom(int startTime,int endTime,int roomNo,int seats){  //Checks and books room according to Given params
	   boolean status = false;
	   if(this.filledRoom[roomNo]==1) {
		 	return status;
	      }else{
			this.filledRoom[roomNo]=1;
		   }
        MeetingRoom newRoom=new MeetingRoom();
	    newRoom.startTime=startTime;newRoom.endTime=endTime;newRoom.roomId=roomNo;newRoom.seats=seats;
	    list.add(newRoom);
	    status=true;
	   return status;
	 }
  
    private int getLength(int[] arr){			// Returns no. of Elements in Integer array
	   int count = 0;
	   for (int i = 0; i < arr.length; i ++)
	     if (arr[i] != 0)
	      count ++; 
	  return count;
    }
}
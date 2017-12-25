import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
public class Booking{
	ArrayList<MeetingRoom> list=new ArrayList<MeetingRoom>(); 
	int[] filledRoom=new int[50];

	
	public void availableRooms(int startTime,int endTime){
		int[] arr= new int[20];
		if(filledRoom.length==0)
		{
			System.out.println("All the rooms are available for you(1-20)");
			return;
		}
	   
		System.out.println("Available Rooms According to your time:");
		for(MeetingRoom r:list){
			
			if((r.startTime>startTime&&startTime>r.endTime)||r.startTime<endTime&&endTime<r.endTime){
				
				 continue;
			}else{
				arr[r.roomId]=1;
			}
	    }
		for(int i=0;i<filledRoom.length;i++){
			if(filledRoom[i]==1){
				arr[i]=1;
			}
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=1){
			System.out.print(i+" ");
			}
		}
		
	}
	public void displayList(){
		Collections.sort(list, new Comparator<MeetingRoom>() {
		    public int compare(MeetingRoom m1, MeetingRoom m2) {
		        return m1.roomId-m2.roomId;
		    }
		});
		for(MeetingRoom trav:list){
			System.out.println(list);
		}
		}
	
	public void getTimings(int id){
		System.out.println("Timings Availsble:");
		int[] timeKeeping=new int[10];
		int i=0;
		if(list.isEmpty()==true){
			System.out.println("You can book any time you want.");
			return;
		}
	  for(MeetingRoom t:list){
		  if(t.roomId==id){
			  timeKeeping[i++]=t.startTime;
			  System.out.println(t.startTime+""+t.endTime);
			  timeKeeping[i++]=t.endTime;
		  }
	  } 
	  Arrays.sort(timeKeeping);
	  if(timeKeeping[0]!=0){
		  System.out.println("0-"+timeKeeping[0]);
	  }
	  for(int j=1;j<timeKeeping.length;j=j+2){
	 
		 System.out.println(timeKeeping[j]+"-"+timeKeeping[j+1]);
	  }
	  if(timeKeeping[i]!=2400){
		  System.out.println(timeKeeping[i]+"-2400");
	  }
	  
	}
  	  
	 public boolean bookSpecificRoom(int startTime,int endTime,int roomNo,int seats){
		   boolean status = false;
		   MeetingRoom newRoom=new MeetingRoom();
		   newRoom.startTime=startTime ;newRoom.endTime=endTime;newRoom.roomId=roomNo;newRoom.seats=seats;
		   list.add(newRoom);
		   this.filledRoom[roomNo]++;
		   status=true;
		   return status;
		   }		  
		   
	 
  public boolean bookRoom(int startTime,int endTime,int roomNo,int seats){
	   boolean status = false;
	   
		if(this.filledRoom[roomNo]==1) {
		 	return status;
		}else
		{
			this.filledRoom[roomNo]=1;
		}
       
	    MeetingRoom newRoom=new MeetingRoom();
	    newRoom.startTime=startTime;newRoom.endTime=endTime;newRoom.roomId=roomNo;newRoom.seats=seats;
	   list.add(newRoom);
	   
	   status=true;
	   return status;
	   }
  
 
}


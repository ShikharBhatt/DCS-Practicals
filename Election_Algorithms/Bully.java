import java.util.Scanner;
import java.io.InputStream;
import java.io.PrintStream;

public class Bully{

	static boolean state[] = new boolean[5];
	public static int coordinator;

	public static void up(int i){
		
		if(state[i]) System.out.println("  "+(i+1) + " is already UP!");
		
		else{
			
			state[i] = true;
			System.out.println("  "+(i+1) + " is now up!");
		
			// conducts election
			message(i);
		}			
	}
	
	public static void down(int i){
		
		if(!state[i]) System.out.println((i+1) + " is already DOWN!");
		
		else{			
			state[i] = false;
			System.out.println("  "+ (i+1) + " is now DOWN!");
			if(coordinator == i)
			System.out.println("  "+(i+1) + " was Coordinator and is now down -----> Conduct RE-ELECTION");
		}		
	}
	
	public static void message(int i){
		
			if(!state[i])  	System.out.println("  "+ (i+1) + " is DOWN!");
			
			else{
			
				for(int k=i;k<5;k++){
					if(!state[k]) continue;
				
					else coordinator = k;	
				
					//loop for sending messages from a process
					for(int j=k+1;j<5;j++){
						System.out.println(" "+ (k+1) + " sent election message to "+ (j+1));
					}
					
					//loop for receiving acknowledgement
					for(int j=4;j>k;j--){
						if(!state[j]) System.out.println("<<-- "+(j+1) + " DID NOT respond to election message of "+ (k+1));
						else 
						System.out.println("<<-- "+(j+1) + " responded to election message of "+ (k+1));
					}
				} 
				
				//each process will be set as coordinator when it holds election but only the last process which held election becomes coordinator
				System.out.println("\n"+(coordinator+1)+" became the coordinator and sent coordiantor message to all");
		}
	}

	public static void main(String args[]){
	
		int choice,p ;
		boolean done =false;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; ++i)	Bully.state[i] = true; 
		
		
		System.out.println("There are five processes P1 P2 P3 P4 P5 ");
		Bully.coordinator=4;
		
		System.out.println("Coordinator "+(Bully.coordinator+1));
		do{
			
			System.out.println("\n\n");			
			System.out.println("1> UP a process ");
			System.out.println("2> DOWN a process ");
			System.out.println("3> START ELECTION from a process ");
			System.out.println("4> EXIT ");
			
			choice = sc.nextInt();
			switch(choice){
			
			case 1:	System.out.print("UP Process No. : ");
					p = sc.nextInt();
					Bully.up(p-1);
					break;
					
			case 2: System.out.print("DOWN Process No. : ");
					p = sc.nextInt();
					Bully.down(p-1);
					break;
					
			case 3: System.out.print("Conduct Election from Process No. : ");
					p = sc.nextInt();
					Bully.message(p-1);					
					break;
					
			case 4: done =true;
					
					break; 
			}
			
		}while(!done);
		
	}
}

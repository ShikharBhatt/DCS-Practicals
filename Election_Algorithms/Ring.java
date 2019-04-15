import java.util.Scanner;

class Ring{

	static boolean state[] = new boolean[5];
	public static String Message; 
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
			
				Message = "";
				coordinator = -1;
				int j=i;
				
				do{
					if(state[j]){ 
						Message = Message +" "+ (j+1);
						//message will contain only space separated numbers of processes
						System.out.println((j+1)+" passes the message {" +Message+" } to "+"next alive process");
						
						if(coordinator < j)	coordinator = j;
					}
				
					j++;
					j=j%5;
					
				}while(j!=i);
				
				if(j==i)
				{
					System.out.println("-->"+(j+1)+" receives {" +Message+" } message");
					System.out.println("\n"+ (coordinator+1) +" is ELECTED as the coordinator");
				}
				
				
				do{
					if(state[j]){ 
		System.out.println((j+1)+" passes COORDINATOR Message {" +Message+" } "+"the ELECTED COORDINATOR "+(coordinator+1) +" to next process");
					}
				
					j++;
					j=j%5;
					
				}while(j!=i);
				
				if(j==i)	System.out.println("-->"+(j+1)+" receives {" +Message+" } message back");
					
		}
	}
	
	public static void main(String[] args){
	
		boolean done =false;
		int choice,p;
		
		for (int i = 0; i < 5; ++i)	Ring.state[i] = true; 
	
		System.out.println("There are five processes P1 P2 P3 P4 P5 ");
		Ring.coordinator=4;
		System.out.println((coordinator+1) +" is the coordinator");
	
		Scanner sc = new Scanner(System.in);
			
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
					Ring.up(p-1);
					break;
					
			case 2: System.out.print("DOWN Process No. : ");
					p = sc.nextInt();
					Ring.down(p-1);
					break;
					
			case 3: System.out.print("Conduct Election from Process No. : ");
					p = sc.nextInt();
					Ring.message(p-1);					
					break;
					
			case 4: done =true;
					
					break; 
			}
		
		}while(!done);
			
	}

}

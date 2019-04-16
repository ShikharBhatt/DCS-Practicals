import java.io.*;
import java.net.*;
import java.lang.Math; 

public class tcpServer{

	public static void main(String args[])throws Exception{
	
		String s,capS;
		
		ServerSocket serversoc = new ServerSocket(6666);
		Socket new_soc;
			BufferedReader ifc;
			DataOutputStream otc;
		
		while(true){
			
			System.out.println("listening..");    
			new_soc = serversoc.accept();
			System.out.println("listen 1 ");
			ifc = new BufferedReader(new InputStreamReader(new_soc.getInputStream()));
			System.out.println("listen 2 ");
			otc = new DataOutputStream(new_soc.getOutputStream());
			System.out.println("listen 3");
			s = ifc.readLine();
			//while(s.equals("")) {}
			
			String numbers[] = s.split(" "); 
			
			//capS = s.toUpperCase()+"\n";
			double n = Math.pow(Integer.parseInt(numbers[0]),Integer.parseInt(numbers[1]));
			capS = Double.toString(n);
			otc.writeBytes(capS);
			
			System.out.println("From Client : "+ s);    
			
			if(s.equals("bye")){
				new_soc.close();
				break;
			}
			new_soc.close();    
		}
		
		serversoc.close();	
	} 

}


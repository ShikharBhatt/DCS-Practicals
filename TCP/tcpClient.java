import java.io.*;
import java.net.*;

public class tcpClient{

	public static void main(String args[])throws Exception{
	
		String s,capS;
		
		BufferedReader ifu ;//= new BufferedReader(new InputStreamReader(System.in));
		Socket clientsoc = new Socket("127.0.0.1",6666);
		DataOutputStream ots = new DataOutputStream(clientsoc.getOutputStream());
		BufferedReader ifs = new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));
		
		//while(true){
			System.out.print("Enter Two space-separated Integers : "); 
			ifu = new BufferedReader(new InputStreamReader(System.in));
			s = ifu.readLine();
			ots.writeBytes(s+"\n");

			capS  = ifs.readLine();
			System.out.println("From server : "+ capS);    
	//	}	
		
	} 

}


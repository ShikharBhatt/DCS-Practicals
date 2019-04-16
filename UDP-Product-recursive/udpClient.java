import java.io.*;
import java.net.*;

public class udpClient{

	public static void main(String args[])throws Exception{
	
		String s="",capS="";
		BufferedReader ifu = new BufferedReader(new InputStreamReader(System.in));
		
		DatagramSocket clientSocket = new DatagramSocket();

		byte[] rec_data = new byte[1024];
		byte[] send_data = new byte[1024];
		
		//String sentence;
		
		while(true){
			
		//	s="";
			
			
			System.out.print("Enter two space separated integers : ");
			s = ifu.readLine();	
			if(s.equals("exit")){
				ifu.close();
				clientSocket.close();
				break;
			}
			send_data = s.getBytes();			
			
			InetAddress IPAddress = InetAddress.getByName("localhost");			
			DatagramPacket sendPacket = new DatagramPacket(send_data,send_data.length,IPAddress,5555);
			clientSocket.send(sendPacket);
			
			DatagramPacket rec_Packet = new DatagramPacket(rec_data,rec_data.length);
			clientSocket.receive(rec_Packet);
			
			capS = new String(rec_Packet.getData());
			System.out.println("Returned Sentence :"+capS+"\n");
			
			
						
		}

	}
}

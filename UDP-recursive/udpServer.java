import java.io.*;
import java.net.*;

public class udpServer{

	public static void main(String args[])throws Exception{
	
		String s,capS;
		
		DatagramSocket serverSocket = new DatagramSocket(5555);
		byte[] rec_data = new byte[1024];
		byte[] send_data = new byte[1024];
		
		while(true){
			
			DatagramPacket rec_Packet = new DatagramPacket(rec_data,rec_data.length);
			serverSocket.receive(rec_Packet);
			
			s = new String(rec_Packet.getData());
			System.out.println("Received :"+s);
			
			capS = s.toUpperCase()+"\n";
			send_data = capS.getBytes();
			
			InetAddress IPAddress = rec_Packet.getAddress();	
			int port = rec_Packet.getPort();
			
			DatagramPacket sendPacket = new DatagramPacket(send_data,send_data.length,IPAddress,port);
			serverSocket.send(sendPacket);
			
			System.out.println("CapitalisedSentence :"+capS);
						
		}
	}

}

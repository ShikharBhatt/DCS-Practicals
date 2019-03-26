import java.rmi.*;

public class AddClient {

public static void main(String args[]){

try	{
		String addServerURL = "rmi://" + args[0] + "/AddServer";
		AddServerIntf addServerIntf = 
		(AddServerIntf)Naming.lookup(addServerURL);
		System.out.println("The first number is :"+ args[1]);
		double d1 = Double.valueOf(args[1]).doubleValue();
		System.out.println("The second number is :"+ args[2]);
		double d2 = Double.valueOf(args[2]).doubleValue();
		System.out.println("The sum is :"+addServerIntf.add(d1,d2));
	}
catch (Exception e){
		System.out.println("Exceptin: "+ e);
		}
	}
}

/*

java AddClient 127.0.0.1  2 3

The first number is :2
The second number is :3
The sum is :5.0

java AddClient 127.0.0.1  2 300

The first number is :2
The second number is :300
The sum is :302.0

java AddClient 127.0.0.1  20.5 12.548

The first number is :20.5
The second number is :12.548
The sum is :33.048


*/

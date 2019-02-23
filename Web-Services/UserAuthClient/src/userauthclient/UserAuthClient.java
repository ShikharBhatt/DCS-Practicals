/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package userauthclient;

/**
 *
 * @author shikhar
 */
import java.util.Scanner;

public class UserAuthClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(System.in);
        
        System.out.print("Options:\n1.Register\n2.Login\n\n");

        System.out.print("Enter your choice:");
        int number = input.nextInt();
        
        String username;
        String password;
        
        if(number == 1) {
            System.out.print("Welcome to the registration process \n");
            
            System.out.print("Enter Username: ");
            username = input.next();
            
            System.out.print("Enter Password: ");
            password = input.next();
            
            String response = register(username, password);
            
            System.out.println(response);
        }
        
        else if(number == 2) {
            System.out.print("Welcome to the login process \n");
            
            System.out.print("Enter Username: ");
            username = input.next();
            
            System.out.print("Enter Password: ");
            password = input.next();
            
            String response = login(username, password);
            
            System.out.println(response);
        }
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        
    }

    private static String register(java.lang.String username, java.lang.String password) {
        org.me.userauthws.UserAuthWS_Service service = new org.me.userauthws.UserAuthWS_Service();
        org.me.userauthws.UserAuthWS port = service.getUserAuthWSPort();
        return port.register(username, password);
    }

    private static String login(java.lang.String username, java.lang.String password) {
        org.me.userauthws.UserAuthWS_Service service = new org.me.userauthws.UserAuthWS_Service();
        org.me.userauthws.UserAuthWS port = service.getUserAuthWSPort();
        return port.login(username, password);
    }
    
}

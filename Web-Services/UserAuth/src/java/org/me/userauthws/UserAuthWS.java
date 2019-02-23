
package org.me.userauthws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

@WebService(serviceName = "UserAuthWS")
@Stateless()
public class UserAuthWS {
    
    String[] Username = new String[100];
    String[] Password = new String[100];
    static int Count = 0;
    
    @WebMethod(operationName = "register")
    public String register(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        Username[Count] = username;
        Password[Count] = password;
        Count++;
        System.out.println("Yess");
        return "You have registered successfully";
    }
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        int flag = 0;
        String response = "Okay";
        for(int  i=0; i<Count; i++) {
            if(Username[i].equals(username) && Password[i].equals(password)){
                response = "You are an authentic user";
                flag = 1;
                break;
            }
        }
        
        if(flag == 0){
                response = "You are not a registered user. Please register first";
        }
      return response;  
    }
}

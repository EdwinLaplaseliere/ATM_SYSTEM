
package atm;

import static atm.ATM.UserInSesion;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MessagesToTheUsers {
   
   MenuOptions Options= new MenuOptions();
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

/*These methods are only use to give the users some messages 
# Welcomingmessages---> welcomes the user to the ATM
# Welcometotyouraccount ---> Welcomes to the account once the user is logged in
# AnyThingelse ----> Asks the user to enter Y or N Wheater they want to continue or no
# Tryagain---> mostly used to allow the user to try a task again  
# Bye---> closes the program    
*/   
public void welcomingmessage(){
System.out.println("Welcome to Edwins ATM\n");
}

public void welcometoyouraccount(){
System.out.println("Welcome to your account");
}



public void anythingelse(){
String answer="";    
System.out.println("Do you need any other thing?");
try{
   answer=br.readLine().toUpperCase();
   if(answer.startsWith("N")){
       bye();
       System.exit(0);
   }else if(answer.startsWith("Y")){
  Options.showoptions(UserInSesion);
   }else{
   Options.showoptions(UserInSesion);
   }
}catch(Exception ex){}

}


public void tryagain(){
Boolean entered=false;    
System.out.println("Do you want to try again");
do{
try{
String action = br.readLine().toUpperCase();
if(action.equals("")){
entered=false;  
System.out.println("Do you want to try again");
}
else if(action.startsWith("Y")){
entered=true;     
UsersValidation UserVali= new UsersValidation();
UserVali.validation();
}else if(action.startsWith("N")){
entered=true;     
bye();
} else{
       bye(); 
        }
}
catch(Exception e){}
}while(entered==false);
}

public void bye(){
System.out.println("Thank you for using edwins ATM");
System.exit(0);
}
   
    
    
    
    
    
    
}

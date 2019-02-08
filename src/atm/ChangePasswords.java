
package atm;


public class ChangePasswords {
    
    
UsefulMethods2 Methods2= new UsefulMethods2();
/*
THE FLOOWING METHODS TAKES A PARAMETER WHICH IS THE A USER TO CHANGE THE PASSWORD
*/
public void changepassword(String user){   
MessagesToTheUsers Messages= new MessagesToTheUsers(); 
/* CheckIfEmpty method takes a parameter which is what is required to the user to enter
It is located In usefulMethods2  --->>> Find out more about at the top of the method
*/
String NewPassword=Methods2.CheckIfEmpty("A new password");
String NewPasswordAgain=Methods2.CheckIfEmpty("Your new password again");

 if(NewPassword.equals(NewPasswordAgain)){
                        System.out.println("Password updated succesfully");
                        
                        try{
                        // This method Replace the information on the file, such as the password or new amount
                            
                        Methods2.replace(1,NewPasswordAgain , user);
                        Messages.anythingelse();
                        }catch(Exception ex){}
}else{
                        System.out.println("Passwords do not math");
                       Messages.anythingelse();
                    }
}    
   
    
    
}

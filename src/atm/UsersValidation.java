package atm;

import java.io.BufferedReader;
import java.io.FileReader;

public class UsersValidation {
    
      MessagesToTheUsers Messages= new MessagesToTheUsers();
   UsefulMethods2 Methods2= new UsefulMethods2();
    String[] line = new String[4];
    public static String user;
    
    public static String path="C:\\Users\\garce\\Documents\\JAVA PROJECTS\\ATM2\\ATM2\\src\\atm\\USERSREGISTERED\\";
           
// this is the method that allows the user to log in    
public String validation(){
// the right path sould be provided in order for the following code to work
    // in this case the path is 
    // C:\\Users\\garce\\Documents\\JAVA PROJECTS\\ATM2\\ATM2\\src\\atm\\USERSREGISTERED\\  
    // USERSREGISTERED is the name of the package in which the text files are or Bank accounts in this case
    

//C:\Users\garce\Documents\JAVA PROJECTS\ATM2\ATM2\src\atm\USERSREGISTERED\ALICIA.txt
//Variables only for this method
String Username,Password;
//The variable Username takes as value a String returned by CheckIfEmpty Method.
user=Methods2.CheckIfEmpty("your Username");
Username= path+user+".txt";
     try{
BufferedReader ValidateUser=new BufferedReader(new FileReader(Username));
String User=ValidateUser.readLine();
String Pass=ValidateUser.readLine();
Password=Methods2.CheckIfEmpty("your Password");
if(Password.equals(Pass)){
    System.out.println("You are logged in");    
}else{
    System.out.println("Sorry, Wrong Password. Please try it again");
    Messages.tryagain();
}
     }catch(Exception UserName){
//if the system can not find a Document called as the UserName entered, it is a Wrong user a the message bellow will pop up        
System.out.println("Sorry, Wrong user,Please try it again");
Messages.tryagain();
}
return Username;    
} 
    
}

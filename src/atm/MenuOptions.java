
package atm;

import static atm.ATM.UserInSesion;
import java.io.BufferedReader;

public class MenuOptions {
    
 
// this method shows the user all the options and calls  ReadInput method    
public void showoptions(String user){
System.out.println("1.	Check the current account balance");    
System.out.println("2.	Withdraw money from their account");
System.out.println("3.	Change their current password");
System.out.println("4.	Check the latest stock prices for the bank ");
System.out.println("5.	Logout of the system.");
System.out.println("6.	Bank Summary.");
System.out.println("7.	Transfer Money.");
System.out.println("8.	Load Statement.");
ReadInput(user);
                                         }       
    
// This method catches the user answer, and calls other methods to perform diferent actions
public void ReadInput(String user){
//Varibles and objects declarations 
 UsefulMethods1 Method1= new UsefulMethods1();
 UsefulMethods2 Methods2= new UsefulMethods2();
 MessagesToTheUsers Messages= new MessagesToTheUsers();  
String OptionEntred;
int Howmuch, Withdraw;
String[] line = new String[4];
 BufferedReader ca;
 ChangePasswords ChangePass = new ChangePasswords();
OptionEntred=Methods2.CheckIfEmpty("A number to select an option between 1 and 8");

//The switch statement takes an option and according to it calles other methods
switch(OptionEntred){

case "1":
String Balance =  Method1.checkbalance(UserInSesion);
Method1.showbalance(Balance);
 Messages.anythingelse();
break;       
case "2":
  Method1.withdrawoptions();
    break;
case "3":
    ChangePass.changepassword(user);
      break;
case "4":
      Method1.StockPrices();
    break;
case "5":
        Messages.bye();
    break;
case "6":
    BankSumary Banks= new BankSumary();
    
    break;
case "7":
TransferMoney Transfer= new TransferMoney();
    break;
case "8":
Method1.Statement();
    break;
                              
default:
    System.out.println("Invalid Option");
    Messages.anythingelse();
    break;


                      }



                                      }


    
}

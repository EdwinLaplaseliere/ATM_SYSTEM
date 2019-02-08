
package atm;

import static atm.ATM.UserInSesion;
import static atm.UsersValidation.path;
import static atm.UsersValidation.user;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Date;






public class TransferMoney {
    public TransferMoney(){
    Transfer();
    }
    
/*
#In this part, object get created and some variables too
#The date variable is used to register transactions 
*/    
BufferedReader CheckFile;
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Date d= new Date();
UsefulMethods2 Methods2= new UsefulMethods2();
UsefulMethods1 Methods1= new UsefulMethods1();
MessagesToTheUsers Messages= new MessagesToTheUsers();
Boolean Flag=false;  



// This method allows te user to transfer money to other accounts
public void Transfer(){ 
String Balance =  Methods1.checkbalance(UserInSesion);

Methods1.showbalance(Balance);

String usertotransfer=ChooseUser(); 

try{
  
// the right path sould be provided in order for the following code to work
    // in this case the path is 
    // C:\\Users\\garce\\Documents\\JAVA PROJECTS\\ATM2\\ATM2\\src\\atm\\USERSREGISTERED\\  
    // USERSREGISTERED is the name of the package in which the text files are or Bank accounts in this case    
    
CheckFile=new BufferedReader(new FileReader(path+usertotransfer+".txt"));
if(usertotransfer.equals(user)){
    System.out.println("Sorry, No auto transferences allowed");
    Messages.anythingelse();
}else{
String Balance2 =  Methods1.checkbalance(path+usertotransfer+".txt");

Flag=true;
int AtTranfer = AmountToTransfer();

int CurrentBalance=Integer.parseInt(Balance);

int otheruserBalance=Integer.parseInt(Balance2);

boolean yesorno = compare(CurrentBalance,AtTranfer);
if(yesorno){
int moneyleft=CurrentBalance-AtTranfer;
String MoneyLeft=Integer.toString(moneyleft);
int newpersonsbalance = otheruserBalance+AtTranfer;
String Newpersonsbalance=Integer.toString(newpersonsbalance);
try{
/* Here replace and transaction register are called twice because the need to be used in two different files
    the current user and the user to whom the money is being transfered 
    */    
Methods2.replace(2,MoneyLeft, UserInSesion);
Methods2.TransactionRegister("Transfer",AtTranfer, UserInSesion,d);
Methods2.replace(2, Newpersonsbalance, path+usertotransfer+".txt");
Methods2.TransactionRegister("Paid Order", AtTranfer,path+usertotransfer+".txt",d);
System.out.println("Your transaction has been sucessful");
Messages.anythingelse();

}catch(Exception ex){

}
}else{
System.out.println("Sorry the Amount entered is greater than Balance which is" + CurrentBalance );  
}
}
}catch(Exception NoUserFound){
System.out.println("Unknown payee"); 
Messages.anythingelse();
}

}


// this methods works choosing the user to transfer some money
public String ChooseUser(){
String User="";
User=Methods2.CheckIfEmpty("The name of a payee");
return User;
}

public int AmountToTransfer(){
int AmounttoSend = 0;    
String Amounttosend;   
Amounttosend=Methods2.CheckIfEmpty("amount to send");
AmounttoSend=AmounttoSend+Integer.parseInt(Amounttosend);
return AmounttoSend;
}

public boolean compare(int CurrentBalance,int AtTranfer){
    
boolean goodtosend;
if(CurrentBalance>AtTranfer){
goodtosend=true;
}else{
goodtosend=false;
}
return goodtosend;
}







}

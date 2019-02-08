
package atm;
import static atm.ATM.UserInSesion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Date;
public class UsefulMethods1 {
    
    
    // variables declaration
    int lines;
    String[] line = new String[4];
    MessagesToTheUsers Messages= new MessagesToTheUsers();
    UsefulMethods2 Methods2= new UsefulMethods2();
    int Howmuch, Withdraw; 
    String withdraw;
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedReader ca;
      Date d= new Date();
      boolean entered=false;
    
      
    // this simple method takes an different amount than the ones in the menu and checks if it is possible to withdraw it  
    public void withdraw(){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    try{
             
    do{
                  
              System.out.println("How much do you want to withdraw\n €");
               withdraw = br.readLine();
               
              if(withdraw.equals("")){
               sleep(1000);   
               System.out.println("Sorry, you must entered an amount");
               sleep(1000);
               entered=false;
                                     }else{
ca = new BufferedReader(new FileReader(UserInSesion));     
for(int i=0;i<=2;i++){
line[i]=ca.readLine();
             }
Withdraw = Integer.valueOf(withdraw);
Howmuch = Integer.valueOf(line[2]);
withdrawal(Howmuch,Withdraw,UserInSesion,d);
entered=true;
                                     }
    }while(entered==false);
    }catch(Exception ex){}
    }

    
    public void finalwithdrawal(){
   

    
    }
   
     
    
    // this methods checks whether the user is able to withdraw money or no and some other validations
    public void withdrawal(int Howmuch, int Withdraw,String user,Date d){
     
   if(Howmuch>=Withdraw){
      double multiple=(double) Withdraw/(double)10;
      String Multiple=Double.toString(multiple);
       if(Withdraw<=10){
        System.out.println("Sorry, the minimun withdraw amount is €20");
        Messages.anythingelse();
                       }
        else if(Withdraw>=700){
        System.out.println("Sorry, this amount is over the limit");
          Messages.anythingelse();
                              }
       
       else {
            
           if(Multiple.endsWith("0")){
       int totalleft=Howmuch-Withdraw;
        String TotalLeft= Integer.toString(totalleft); 
       System.out.print("Please wait, Your money is being counted");
        System.out.print(".");sleep(1000); System.out.print(".");sleep(1000); System.out.print(".");
       try{
        Methods2.replace(2, TotalLeft, user);
        Methods2.TransactionRegister("Withdrawal", Withdraw, user, d);
       }catch(Exception ex){
       }
       System.out.println("\n"+"\n");
       System.out.println("Please take your cash"+"\n"+"\n");
       Messages.anythingelse(); 
                                     }
           
                else{
                System.out.println("Sorry, only amount finishing in 0 are allowed\n Example 20,30,40,50,100"); 
                Messages.anythingelse();
                    }
            }
                                 }else{
     sleep(2000);  
     System.out.println("Sorry you do not have"+" " +Withdraw+ " "+ " in your account" );  
     Messages.anythingelse();
                                      }
    
    
                                                                               } 
    // this methods only loads the bank stock prices
  public void StockPrices(){
      try{
          
     // in order for this method to work the right path should be provided, this should be different in every computer
     // the path coulb be found by getting the properties of the file called BankStock in the project, in this case  the path is 
     //C:\\Users\\garce\\Documents\\JAVA PROJECTS\\ATM2\\ATM2\\src\\atm\\BankStock.txt
     
      BufferedReader ca = new BufferedReader(new FileReader("C:\\Users\\garce\\Documents\\JAVA PROJECTS\\ATM2\\ATM2\\src\\atm\\BankStock.txt"));  
      
      String LinesRead=ca.readLine();
      while(LinesRead!=null){
          System.out.println(LinesRead);
          LinesRead=ca.readLine();
      }
      }catch(Exception ex){
      }
      Messages.anythingelse();
                           }
  
  // this methods loads the users statement, with all the transactions made
    public void Statement(){
        lines=Methods2.CountFileslines();
        try{
        BufferedReader ca = new BufferedReader(new FileReader(UserInSesion));
        String line[]= new String[lines];
        String name,pass,account;
         
         name=ca.readLine();
         pass=ca.readLine();
         account=ca.readLine();
         sleep(1000);
         System.out.println("Account holder:                                         "+name);
         System.out.println("Your current balance is:"+"                               "+account);
         System.out.println("Transactions by date:\n");
         for(int i=0;i<lines-3;i++){
         line[i]=ca.readLine();    
         System.out.println(line[i]);    
         }
         sleep(1000);
         Messages.anythingelse();
        
        }catch(Exception ex){}
                            }

/*this methods is called in some ocasions as it checks the user balance in order 
    to allows some transactions, such as transferences and withdrawing*/    
public String checkbalance(String user){
   try{ 
BufferedReader ca = new BufferedReader(new FileReader(user));
 for(int i=0;i<=2;i++){
 line[i]=ca.readLine();
                      }
                   
   }catch(Exception ex){}              
return line[2];
                                       }

public void showbalance(String Balance){
sleep(1000); 
System.out.println("You current balance is" + " " +Balance);
sleep(1000);
                                       }
    
public static void sleep(int time){
try{
    Thread.sleep(time);
        }catch(Exception ex){}
                                  }
 

// this methods acts according to the amount of money choosen
public void withdrawoptions(){
String optionentered = WitdrawOptionEntered();
String Balance =checkbalance(UserInSesion);
int balance=Integer.parseInt(Balance);
try{
     
       switch(optionentered){
       case "1":
           withdrawal(balance,20,UserInSesion,d);
          
           break;
       case"2":
           withdrawal(balance,50,UserInSesion,d);
           
           break;
       case"3":
           withdrawal(balance,100,UserInSesion,d);
          
           break;
       case"4":
           withdrawal(balance,200,UserInSesion,d);
         
           break;
       case"5":
           withdrawal(balance,300,UserInSesion,d);
            
           break;
       case"6":
           withdrawal(balance,400,UserInSesion,d);
            
           break;
       case"7":
           withdrawal(balance,500,UserInSesion,d);
            
           break;
       case"8":
           withdraw();
           
           break;
       default:
        System.out.println("Sorry, wrong option");
       Messages.anythingelse();
      
           break;
                           }
   
}catch(Exception ex){
            }

                             }
// shows the user what to withdraw
public String WitdrawOptionEntered(){
String optionentred="";
System.out.println("1. €20               2. €50\n");
System.out.println("3. €100               4. €200\n");
System.out.println("5. €300               6. €400\n");
System.out.println("7. €500              8. Other\n");

optionentred=Methods2.CheckIfEmpty("a number to select an option between 1 and 8");


return optionentred;
                                    }
        
    
    
    
                                           }

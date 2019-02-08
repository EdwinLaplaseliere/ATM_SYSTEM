
package atm;

import static atm.UsefulMethods1.sleep;
import static atm.UsersValidation.path;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BankSumary {
    
    int Balance;  int Small=0,Medium=0,Large=0,ExtraLarge=0,TotalSummary=0; 
    public BankSumary(){
    BankInfomration();
    createstatement();
    }
    
    public void BankInfomration(){
    
    BufferedReader Br;
    
    // the right path sould be provided in order for the following code to work
    // in this case the path is 
    // C:\\Users\\garce\\Documents\\JAVA PROJECTS\\ATM2\\ATM2\\src\\atm\\USERSREGISTERED\\  
    // USERSREGISTERED is the name of the package in which the text files are or Bank accounts in this case
    File folder = new File(path);
File[] listOfFiles = folder.listFiles();

for (File file : listOfFiles) {
 if (file.isFile()) {
 String File=  file.getName();
        try{
      
    // the right path sould be provided in order for the following code to work
    // in this case the path is 
    // C:\\Users\\garce\\Documents\\JAVA PROJECTS\\ATM2\\ATM2\\src\\atm\\USERSREGISTERED\\  
    // USERSREGISTERED is the name of the package in which the text files are or Bank accounts in this case
            
            
            
        Br= new BufferedReader(new FileReader("C:\\Users\\garce\\Documents\\JAVA PROJECTS\\ATM2\\ATM2\\src\\atm\\USERSREGISTERED\\"+File));
        String Username=Br.readLine();
        String Pass=Br.readLine();
         Balance=Integer.parseInt(Br.readLine());
         TotalSummary=TotalSummary+Balance;
         if(Balance<100){
             Small=Small+1;
         }else if(Balance>100 && Balance<=200){
             Medium=Medium+1;
         }else if(Balance>200.0 && Balance<=300.0){
             Large=Large+1;
         }else {
         ExtraLarge=ExtraLarge+1;
         }
         //createstatement(TotalSummary,Small,Medium,Large,ExtraLarge);   
        
        }catch(Exception ex){}
    }
}
 

    }
    
    public void createstatement(/*double banksum,int small,int medium,int large,int Extralarge*/){
System.out.println("THE FOLLOWING STATEMENT CONTAINS SOME BANK PRIVATE INFORMATION, ONLY PROVIDED TO ACCOUNT'S HOLDERS\n");   
System.out.println("The total amount of money currently stored in the bank is:"+"  €"+TotalSummary+"\n");
System.out.println("Bank Accounts Categories"+ "           "+"Amount Of Accounts");
System.out.println("Small"+"                               "+Small); 
System.out.println("Medium"+"                              "+Medium); 
System.out.println("Large"+"                               "+Large); 
System.out.println("Extra Large"+"                         "+ExtraLarge+"\n"); 

sleep(1000);
MessagesToTheUsers Messages= new MessagesToTheUsers();
Messages.anythingelse();
}
    
    
    
    
    
}

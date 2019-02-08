
package atm;

import static atm.ATM.UserInSesion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

public class UsefulMethods2 {
MessagesToTheUsers Messages= new MessagesToTheUsers();
BufferedReader ca;
String Balance;
int balance;
int lines = CountFileslines();
 String line[]= new String [lines]; 
 BufferedReader BR= new BufferedReader(new InputStreamReader(System.in));
 
 
 
 
// this method works as the program bufferedreader as it takes an input and checks if it is empty or no 
public String CheckIfEmpty(String Required){

System.out.println("Please enter "+Required);
boolean Empty=false; 
String UserInput="";
do{
           try{    
    UserInput=BR.readLine().toUpperCase();
if(UserInput.equals("")){
Empty=false; 
    System.out.println(Required+"  "+"Required, Please enter a valid one");
                       }
                   else{
                   Empty=true;
                        }
              }catch(Exception input){}
           
 }while(Empty==false);

return UserInput;
                                           } 
 
// This methods counts lines in the files to craete the statatement
public int CountFileslines(){
   int l=0;
        try{
ca = new BufferedReader(new FileReader(UserInSesion));            
String lines = ca.readLine(); 
        while(lines != null) { 
            l=l+1;
                lines = ca.readLine(); 
                             }            
           }catch(Exception ex){}
return l;
                            }  

// this method loads the user information to then get replaced
public void LoadUserInfo(String user){
      try{  
ca = new BufferedReader(new FileReader(user));
 for(int i=0;i<=lines;i++){
 line[i]=ca.readLine();
                          }
System.out.println("You current balance is" + " " +line[2]);             
         }catch(Exception ex){}  
                                     }

//this method replace informtion in the files, this and load user information which is just above work together
public void replace(int linetoreplace, String newcontent,String user){ 

 LoadUserInfo(user);
   line[linetoreplace]=newcontent;    
try{
    
PrintWriter w = new PrintWriter(new FileWriter(user));
for(int i=0;i<lines;i++){
    w.println(line[i]);
                        }  
w.close();
   }catch(Exception ex){}
                              
}
/*This method registers transaction made by the user*/
public void TransactionRegister(String Transaction,int transaction,String user,Date CurrentDate){
    
                   try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(user,true));
      writer.newLine();
      writer.write(Transaction + "  " +transaction+ " "+ "on" + " "+CurrentDate);
      writer.close();
      
                      }catch(Exception ex){}

                                                                                      }



      
    
    
    
    
                            }


package atm;

/*
-------------------------------------------------------------------------------
                                TABLE OF CONTENTS
-------------------------------------------------------------------------------
--------------->Classes<------------------
*    ATM------> Contains the Main Method
****************************************************************

*    UserValidation---> Contains The Validation methods 
which allows the user to log in
****************************************************************

*   MessagesToTheUsers---> Contains Messages for the users such as:
#Welcoming to the Bank
#Welcoming to the account
#Asking if they want to continue
#Asking the if they want to try again
****************************************************************

*   MenuOptions ---> Shows the options on the menu, to see what the user 
wants to do
*****************************************************************

*   UsefulMethods1---> Contains methods such as:

#Withdraw
#Load Stock Prices
#Load UserStatement
*****************************************************************

*   UsefulMethods2---> Contains methods such as:
#Check if empty (This is to check the user inputs)
#Load user information
#Replace (This replace information on the file, like new passwords, new balance)
#Transaction Register (This is use for the Bank Statement)
****************************************************************

*   ChangePaswords---> Allows the users to change their passwords
******************************************************************

*   TransferMoney ---> Allows the user to transfer to other accounts
*********************************************************************
-------------------------------------------------------------------------------
*/


public class ATM {
    public static String UserInSesion;
   /* The followings two lines create Instances of the class Messages to users and MenuOptions
    This wil be used later in the lines below
    ******************************************************************************************/ 
   MessagesToTheUsers Messages= new MessagesToTheUsers();
   MenuOptions Options= new MenuOptions();
   
  
    public ATM(){
   
        
    UsersValidation UserVali= new UsersValidation();
    
    Messages.welcomingmessage();
  /*The UserInSesion contains the name of the User Currently using the ATM
    The User's name comes from the userValidation class
    */
   UserInSesion = UserVali.validation();
    Messages.welcometoyouraccount();
  //The flowing lines calls a method from MenuOptions class called showoptions which takes a parameter, The user in sesion
    Options.showoptions(UserInSesion);
    
    } 


    
    
    public static void main(String[] args) {
      new ATM();  
    }
    
}

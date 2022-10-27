package Email_App;

public class EmailAPP {
    public static void main (String[] args){
        Email emp1 = new Email ("Yogesh", "Rathod");


         emp1.setAlternateEmail("yogi.rathod@dev.tcs.com");
         System.out.println("Your alt mail is:"+ emp1.getAlternateEmail());
         emp1.Setchangepassword("Yogesh@123");
         System.out.println("your new pass:" + emp1.getPassword());
         System.out.println(emp1.getMailboxCapacity());





    }
}

package Email_App;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String Password;
    private String department;
   // private String defaultDepartmentName;
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "tcs.com";
    private String password;

    //comstuctor to eceie the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created:" + this.firstName + " " + this.lastName);

        // call a method asking for department - return department
        this.department = setDepartment();
        System.out.println("Your department name is:" + this.department);

        // call a method asking for changing password  returning new password
        this.Password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is:" + this.Password);


        // generate Email

        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
        System.out.println("Your Email is:" + email);


        // mailbox capacity
//        this.mailboxCapacity =  setmailBoxCapacity(mailboxCapacity);
//        System.out.println("Mail box capacity:" + this.mailboxCapacity);
    }


    // ask for department
    private String setDepartment() {
        System.out.print("Choose Your department\n1 Sales \n2 Account \n3 Developer \n4 None \nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int depchoice = in.nextInt();

        if (depchoice == 1) {
            return "sales";
        } else if (depchoice == 2) {
            return "Account";
        } else if (depchoice == 3) {
            return "Developer";
        } else {
            return " ";
        }
    }


    // generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%1234567890";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set the mailbox capacity
    public void setmailBoxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // change the password
    public void Setchangepassword(String password) {
        this.password = password;

    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword(){
         return password;

    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
}


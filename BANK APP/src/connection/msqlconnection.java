package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class msqlconnection {
	
	
	private static Connection connection = null;
	private  static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)  {
		

		msqlconnection msqlConnection = new msqlconnection();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dBURL = "jdbc:mysql://localhost:3306/jdbc_db";
			String username = "root";
			String password = "Yogesh123";
			
			connection  = DriverManager.getConnection(dBURL, username, password );
			 
			 System.out.println ("Enter choice");
			 System.out.println ("1. Insert record");
			 int choice = Integer.parseInt(scanner.nextLine());

			 switch (choice) {
			 case 1:
				 msqlConnection.insertRecord();
				 break;
				 
		     default:
		    	 break;
			 }
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong");
		}
	
	}

private void insertRecord() throws SQLException {
 System.out.println("Inside insert record()");
	
	  String sql = "insert into bankapplication(name,id) values(?,?)";
	  
	 PreparedStatement preparedStatement = connection.prepareStatement(sql);
	 System.out.println("Enter your name:");
	 preparedStatement.setString(1,scanner.nextLine());
	 System.out.println("Enter your ID:");
	 preparedStatement.setInt(2, Integer.parseInt(scanner.nextLine()));

	 int rows =  preparedStatement.executeUpdate();
	 
	 if(rows > 0) {
		 System.out.println("Record inserted successfully");
		 
		 
		 

	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter for Authentication");
	        String name = scanner.nextLine();
	        System.out.println("Enter for Date Encription");
	        String id = scanner.nextLine();


	        BankAccount obj1 = new BankAccount(name, id);
	        obj1.ShowMenu();


	    }
	}

	class BankAccount {
	    int balance;
	    int previousTransactions;
	    String CustomerName;
	    String CustomerId;

	    BankAccount(String cname, String cid) {
	        CustomerName = cname;
	        CustomerId = cid;
	    }

	    //money deposit 1
	    void deposit(int amount) {
	        if (amount != 0)
	            balance = balance + amount;
	        previousTransactions = amount;
	    }

	    // money withdraw 2
	    void withdraw(int amount) {
	        if (amount != 0)
	            balance = balance - amount;
	        previousTransactions = -amount;
	    }

	     void showBalanceInUSD() {

	         System.out.println("showBalanceInUSD");
	         if (balance != 0) {
	             System.out.println("balance is non zero");
	             double numberWhichISConvertedFromBalanceToUSD = (balance / 77);
	             System.out.println("USD Balance:" + numberWhichISConvertedFromBalanceToUSD + "$");

	         }
	         }

	    void getPreviousTransactions(){
	        if (previousTransactions > 0)
	        {
	            System.out.println("Deposited:" + previousTransactions);
	        }else if(previousTransactions < 0)
	        {
	            System.out.println("withdraw:" + previousTransactions);
	        }else
	        {
	            System.out.println("no transactions happened");
	        }
	    }
	    void ShowMenu() {
	        char option = '\0';
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Welcome " + CustomerName);
	        System.out.println("Your ID is " + CustomerId);
	        System.out.println("\n");
	        System.out.println("A. Balance");
	        System.out.println("B. Deposit");
	        System.out.println("C. Withdraw");
	        System.out.println("F. Show balance in usd");
	        System.out.println("D. previousTransactions");
	        System.out.println("E. EXIT");
	        System.out.println("\n");

	        do {
	            System.out.println("*********************************************");
	            System.out.println("Enter an option");
	            System.out.println("*********************************************");
	            option = scanner.next().charAt(0);
	            System.out.println("\n");


	            switch(option)
	            {
	                case 'A':
	                    System.out.println("*********************************************");
	                    System.out.println("balance = " + balance + "RS");
	                    System.out.println("*********************************************");
	                    System.out.println("\n");
	                    break;

	                case 'B':
	                    System.out.println("*********************************************");
	                    System.out.println("Enter an amount to deposit:");
	                    System.out.println("*********************************************");
	                    int amount = scanner.nextInt();
	                    deposit(amount);
	                    System.out.println("\n");
	                    break;

	                case 'C':
	                    if(balance == 0){
	                        System.out.println("You cannot withdraw");
	                    }else
	                    {System.out.println("*********************************************");
	                    System.out.println("Enter the amount to withdraw:");
	                    System.out.println("*********************************************");
	                    int amount2 = scanner.nextInt();
	                    withdraw(amount2);
	                    System.out.println("\n");
	                    System.out.println("Amount withdraw successfully:" + amount2);}
	                    break;

	                case 'D':
	                    System.out.println("*********************************************");
	                    getPreviousTransactions();
	                    System.out.println("*********************************************");
	                    System.out.println("\n");
	                    break;

	                case 'F':
	                    System.out.println("********************************************");
	                    System.out.println("Dislaying........");
	                    showBalanceInUSD();
	                    break;

	                case 'E':
	                    System.out.println("*********************************************");
	                    break;

	                default:
	                    System.out.println("Invalid Transaction. Please try again");
	                    break;
	            }
	        }
	            while (option != 'E') ;
	            System.out.println("Thank You for using our services");
	        }

	    }

 } 
  


package controller;

import java.security.Provider.Service;
import java.util.Scanner;

import com.mysql.cj.conf.PropertyDefinitions.SslMode;

import Service.BankService;

public class BankController {
    BankService service=new BankService();
    Scanner sc= new Scanner(System.in);

    public void menu() throws Exception{
        while(true){
        System.out.println("1.Create Account");
        System.out.println("2.Deposite");
        System.out.println("3.Withdraw");
        System.out.println("4.Transfer");
        System.out.println("5.check Balance");
        System.out.println("6.Exit");
        System.out.println("Enter your choice");
        int choice=sc.nextInt();

    
    switch(choice){

        case 1:
            System.out.println("Name:");
            String name=sc.next();

            System.out.println("Email:");
            String email=sc.next();

            System.out.println("Initial balance:");
            double bal=sc.nextDouble();

            service.createAccount(name, email, bal);
            break;
        case 2:
            System.out.println("Account Id :");
            int  accId=sc.nextInt();

        System.out.println("Amount :");
        double amt=sc.nextDouble();

        service.deposite(accId,amt);
        break;
    
        case 3:
            System.out.print("Account Id: ");
            accId=sc.nextInt();
            System.out.print("Amount: ");
            amt=sc.nextDouble();
            service.withdraw(accId,amt);
            break;

        case 4:
            System.out.println("Sender Id:");
            int s=sc.nextInt();
            System.out.println("receiver Id:");
            int r=sc.nextInt();
            System.out.println("Amount:");
            amt=sc.nextDouble();
            service.transfer(s,r,amt);
            break;

        case 5:
            System.out.println("Enter Account ID:");
            int id=sc.nextInt();
            service.checkBalance(id);
            break;

        case 6:
            return;
    }
}
    }
}

package Service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.AccountDAO;
import dao.TransactionDAO;
import model.Account;
import model.Transaction;
import util.DBConnection;

public class BankService {

    AccountDAO accountDAO=new AccountDAO();
    TransactionDAO transactionDAO=new TransactionDAO();

    public void createAccount(String name,String email,double balance) throws Exception{
        Account acc=new Account(name, email, balance);
        accountDAO.createAccount(acc);
        System.out.println("Account created succefully !");
    }


    public void checkBalance(int accountId) throws SQLException{
        Connection con=DBConnection.getConnection();
        double balance=accountDAO.getBalance(con, accountId);
        System.out.println("Courrent Balance :"+balance);
        con.close();
    }

    public void deposite(int account_id,double amount) throws SQLException{
        Connection con=DBConnection.getConnection();

        double balance=accountDAO.getBalance(con,account_id);
        balance+=amount;

       
        accountDAO.updateBalance(con,account_id, balance);
        con.close();

        System.out.println("Deposite Succefully !");
        
    }

    public void withdraw(int account_id,double amount) throws SQLException{
        Connection con=DBConnection.getConnection();
        double balance=accountDAO.getBalance(con,account_id);

        if(balance<amount){
            System.out.println("Insufficient balance !");
            return;
        }

        balance -=amount;
      
        accountDAO.updateBalance(con,account_id,balance);
        con.close();

        System.out.println("Withdrawal Succeful !");

    }


    public void transfer(int senderId,int receiver_id,double amount){
        Connection con=null;
        try{
            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            double senderBalance=accountDAO.getBalance(con,senderId);

            if(senderBalance<amount){
                System.out.println("Insufficient balance !");
                return;
            }


            double receiverBalance=accountDAO.getBalance(con,receiver_id);
            accountDAO.updateBalance( con,senderId,senderBalance-amount);
            accountDAO.updateBalance(con,receiver_id, receiverBalance+amount);

            Transaction txn = new Transaction(senderId, receiver_id, amount, "transfer", "success");
            transactionDAO.saveTransaction(con,txn);

            con.commit();
            System.out.println("transfer successfully !");

        }catch(Exception e){
            try{
                if(con !=null){
                    con.rollback();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            System.out.println("Transaction failed !");
        }finally{
            try{
                if(con!=null){
                    con.close();

                }
            }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }

    }
    


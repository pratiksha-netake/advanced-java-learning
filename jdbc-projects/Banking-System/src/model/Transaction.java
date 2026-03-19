package model;

public class Transaction {
 
    private int senderId;
    private int receiveredId;
    private double amount;
    private String type;
    private String status;
   

    public Transaction(  
    int senderId,
    int receiveredId,
    double amount,
    String type,
    String status
    ){
       
        this.senderId=senderId;
        this.receiveredId=receiveredId;
        this.amount=amount;
        this. type= type;
        this.status=status;
    }


    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiveredId() {
        return receiveredId;
    }

    public void setReceiveredId(int receiveredId) {
        this.receiveredId = receiveredId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

    
}

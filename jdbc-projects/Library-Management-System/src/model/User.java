package model;

import java.sql.Date;

public class User {
     private int userId;
    private String name;
    private String email;
    private Date membershipDate;
    private int maxBooksAllowed;

     public User(int userId, String name, String email, Date membershipDate, int maxBooksAllowed) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.membershipDate = membershipDate;
        this.maxBooksAllowed = maxBooksAllowed;
    }

     public int getUserId() {
         return userId;
     }

     public void setUserId(int userId) {
         this.userId = userId;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public Date getMembershipDate() {
         return membershipDate;
     }

     public void setMembershipDate(Date membershipDate) {
         this.membershipDate = membershipDate;
     }

     public int getMaxBooksAllowed() {
         return maxBooksAllowed;
     }

     public void setMaxBooksAllowed(int maxBooksAllowed) {
         this.maxBooksAllowed = maxBooksAllowed;
     }

    

}

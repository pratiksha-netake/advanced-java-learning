import java.util.List;
import java.util.Scanner;

import dao.StudentDAO;
import model.Student;

public class Main {
    public static void main(String[] args){
        StudentDAO dao=new StudentDAO();
        Scanner sc=new Scanner(System.in);
        int ch;

        do{
            System.out.println("======  Student Management System ======");
            System.out.println("1. Add Students");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("0. Exit");
            System.out.println("Enter Choice : ");
            ch=sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.println(" Name :");
                    String name=sc.nextLine();

                    System.out.println("Email :");
                    String email=sc.nextLine();

                    System.out.println("Age :");
                    int age=sc.nextInt();
                    sc.nextLine();

                    System.out.println("Course :");
                    String course=sc.nextLine();

                    dao.addStudent(new Student(name,email,age,course));
                    System.out.println("Student Added !"); 
                    break;

                case 2:
                        List <Student> student=dao.getAllStudents();
                        System.out.println("\nID|Name|Email|Age|Course");
                        for(Student s: student){
                            System.out.println(s.getId()+" | "+s.getName()+" | "+s.getEmail()+" | "+s.getAge()+" | "+s.getCourse());

                        }

                        break;
                
                case 3:
                    System.out.println("Enter Id to update : ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("New Name :");
                    String Name=sc.nextLine();
                    System.out.println("New Email : ");
                    String Email=sc.nextLine();
                    System.out.println("New Age : ");
                    int Age=sc.nextInt();
                    sc.nextLine();
                    System.out.println(" New Course : ");
                    String Course=sc.nextLine();
                    Student s= new Student(Name,Email,Age,Course);
                    s.setId(id);
                    dao.updateStudent(s);
                    System.out.println("Student Updated !");
                    break;

                case 4:
                    System.out.println("Enter Id to delete :");
                    int Id=sc.nextInt();
                    sc.nextLine();
                    dao.deleteStudent(Id);
                    System.out.println("Student Deleted !");

                    break;

                case 0:
                    System.out.println("Existing ...");
                    break;                       
            
                default:
                    System.out.println("Invalid choice !");
                    break;
            }
        }while(ch!=0);
        sc.close();


    }
    
}

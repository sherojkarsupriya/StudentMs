package com.StudentMs;
import java.util.*;
public class studentmain {

	
	 public static void main(String[] args) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        studentdao dao = new studentdao();
	         
	        System.out.println("\t\t************Welcome to Student Management System***********");
	        System.out.println("Press 1 for Registration \nPress 2 for Login");
	        int op = sc.nextInt();

	        switch (op) {
	            case 1-> {
	                System.out.println("Enter Student Id");
	                int sid = sc.nextInt();
	                sc.nextLine();
	                System.out.println("Enter Student Name");
	                String sname = sc.nextLine();
	                System.out.println("Enter Student Email");
	                String semail = sc.nextLine();
	                System.out.println("Enter Student Phone");
	                String sphone = sc.nextLine();
	                student s1=new student();
	                s1.sId=sid;
	                s1.sName=sname;
	                s1.sEmail=semail;
	                s1.sPhone=sphone;
	                // getting connection to db
	                dao.dbconnection();
	                // inserting user details to db
	                int res=dao.registerstudent(s1);
	                // insertion is successful if response is 1 otherwise 0
	                if (res == 1) {
	                    System.out.println("Account creation successful");
	                }
	                else {
	                    System.out.println("Something went wrong");
	                }
	            }
	            case 2-> {
	                System.out.println("Welcome to Login  Page");
	                // reading student name and id for login
	                System.out.println("Enter Username");
	                sc.nextLine();
	                String sname = sc.nextLine();
	                System.out.println("Enter id");
	                int sid = sc.nextInt();

	                // connecting to db
	                dao.dbconnection();

	                int res = dao.login(sname, sid);
	                System.out.println(res);
	                // handling the response
	                if (res == 0) {
	                    System.out.println("username/id are incorrect");
	                } 
	                else if (res == -1) 
	                {
	                    System.out.println("Unable to find the details");
	                } else {
	                    System.out.println("Login Successful");
	                    int choice;
	                 
	                    System.out.println("Press 1 to update a student name \nPress 2 for update student email \nPress 3 for update phone \nPress 4 to delete a student\nPress 5 to exit");
	                     choice = sc.nextInt();
	                                
	              switch (choice) {
	                   case 1-> {
	                       System.out.println("Enter New Name");
	                       sc.nextLine();
	                       String stname=sc.nextLine();
	                                
	                       int res1 = dao.updatestudentname(res, stname);
	                       if (res1 == 1) {
	                       System.out.println("Student name changed successfully");
	                          } 
	                       else {
	                         System.out.println("Something went wrong");
	                             }
	                          }
	                    case 2-> {
	                         System.out.println("Enter New Email");
	                         sc.nextLine();
	                         String stemail=sc.nextLine();
	                                
	                         int res1 = dao.updatestudentemail(res, stemail);
	                         if (res1 == 1) {
	                             System.out.println("Student email changed successfully");
	                                } 
	                          else {
	                              System.out.println("Something went wrong");
	                                }
	                            }
	                            
	                     case 3->{
	                          System.out.println("Enter New Phone");
	                          sc.nextLine();
	                          String stphone=sc.nextLine();
	                                
	                          int res1 = dao.updatestudentphone(res, stphone);
	                          if (res1 == 1) {
                                System.out.println("Student phone number changed successfully");
	                                } 
	                          else {
	                                    System.out.println("Something went wrong");
	                                }
	                                   	}
	                            
	                     case 4->{  
	                          System.out.println("Enter Id to Delete");
	                          sc.nextInt();
	                          int res1 = dao.deletestudent(res);
	                          if (res1 == 1) {
	                              System.out.println(" Student Id is Deleted Successfully ");
	                             } 
	                         else {
	                              	System.out.println("Something went wrong");
	                               }
	                         }
	            			 case 5->{
	            				 System.out.println("Exist");
	            			 }
	                       
	                            }
	                          }
	                        }
  }
	        
	 
	    
	        }
	 }



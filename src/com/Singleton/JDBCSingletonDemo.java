package com.Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;



public class JDBCSingletonDemo {

	static int count=1;
	static int choice;
	public static void main(String[] args) throws IOException, SQLException , NumberFormatException{
		// TODO Auto-generated method stub
		
		JDBCSingleton jdbc=JDBCSingleton.getInstance();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 do{   
		        System.out.println("DATABASE OPERATIONS");  
		        System.out.println(" --------------------- ");  
		        System.out.println(" 1. Insertion ");  
		        System.out.println(" 2. View      ");  
		        System.out.println(" 3. Delete    ");  
		        System.out.println(" 4. Update    ");  
		        System.out.println(" 5. Exit      ");  
		          
		        System.out.print("\n");  
		        System.out.print("Please enter the choice what you want to perform in the database: ");  
		          
		        choice=Integer.parseInt(br.readLine());
		        
		        switch (choice) {
				case 1:
					System.out.print("Enter the username you want to insert data into the database: ");  
                    String username=br.readLine();  
                    System.out.print("Enter the password you want to insert data into the database: ");  
                    String password=br.readLine();  
                    
                    try {
                    	int i=jdbc.insert(username, password);
                    	if(i>0) {
                    		System.out.println((count++)+"Data hase been Inserted Succesfully");
                    	}
                    	else {
                    		  System.out.println("Data has not been inserted ");      
                    	}
                    }
                    catch (Exception e) {
						// TODO: handle exception
                    	e.printStackTrace();
					}
                    System.out.println("Press Enter key to continue...");  
                    System.in.read();  
					break;
					
				case 2:
					
					System.out.println("Enter UserName");
					String name=br.readLine();
					try {
						jdbc.view(name);
						
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					
					System.out.println("Press Any Key to Continue");
					System.in.read();
					
					
				case 3:
					System.out.println("Enter USer Id To Delete");
					int id=Integer.parseInt(br.readLine());
					try {
					int i=jdbc.delete(id);
					if(i>0) {
						System.out.println("Record Deleted Succesfully");
					}
					}
					catch (Exception e) {
						// TODO: handle exception
					e.printStackTrace();
					}
					System.out.println("Press any Key to Continue..");
					System.in.read();
					
					
				case 4:
					System.out.println("Enter user Id u want to update ");
					int id2=Integer.parseInt(br.readLine());
					System.out.println("Enter New Name");
					String name1=br.readLine();
					System.out.println("Enter New Password");
					String pass=br.readLine();
					try {
					
						int check=jdbc.CheckId(id2);
						if(check>0) {
							int u=jdbc.update(id2,name1,pass);
							if(u>1) {
								System.out.println("Data Update Successfully Of user id "+id2);
							}else {
								System.out.println("Data Not Update");
							}
						}
						else {
							System.out.println("Record Not Found of Id"+id2);
						}
						
					}
					catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					default:
					break;
				}
		  	}
		 	
		 while (choice!=4);  

		}
	
}

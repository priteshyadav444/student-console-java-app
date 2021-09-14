package com.jdbcasmnt;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//While Loop
		//Menu
		//Switch
		
		System.out.println("Welcome to Menu");
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Enter 1 to Add");
			System.out.println("Enter 2 to Update");
			System.out.println("Enter 3 to Delete");
			System.out.println("Enter 4 to Show All Data");
			System.out.println("Enter 5 to Search By Roll NO");
			System.out.println("Enter 6 to Exit");
			System.out.print("Enter:");
			int c = Integer.parseInt(sc.nextLine());
			
			switch(c)
			{
			case 1:
				//add 
				try {
				String name= "";
				int rno = 0;
				System.out.print("Enter Roll No:");
				rno = Integer.parseInt(sc.nextLine());
				System.out.print("Enter Name:");
				name = sc.nextLine();
				
				boolean result=false;
				
				result = StudentMenu.insertData(name,rno);
				
				if(result==true)
				{
					System.out.println("Data Inserted Succuessfully!!\n");
				}
				else
				{
					System.out.println(" Insert Failed!!\n");
				}
				}
				catch(Exception e)
				{
					System.out.println("Enter Valid Data");
				}
				break;
			case 2:
			{
				try {
					//search result
					boolean result=false;
					String name="";
					int rno = 0;
					System.out.print("Enter Roll No:");
					rno = Integer.parseInt(sc.nextLine());
					System.out.print("Enter New Name:");
					name = sc.nextLine();
					
					 result=StudentMenu.update(rno,name);;
					
					
					if(result==true)
					{
						System.out.println("Data Updated Succuessfully!!\n");
					}
					else
					{
						System.out.println("Update Failed!!\n");
					}
					}
					catch(Exception e)
					{
						System.out.println(e);
						System.out.println("Enter Valid Data");
					}
					
				break;
			}
			case 3:
				try {
					//delete
					int rno = 0;
					System.out.print("Enter Roll No:");
					rno = Integer.parseInt(sc.nextLine());
					
					boolean result=false;
					
					result = StudentMenu.deleteData(rno);
					
					
					if(result==true)
					{
						System.out.println("Deleted Succuessfully!!\n");
					}
					else
					{
						System.out.println("Not Data Found!!\n");
					}
					}
					catch(Exception e)
					{
						System.out.println("Enter Valid RollNo");
					}
					
				break;
				
			case 4:
				//Display
				StudentMenu.showData();
				System.out.println("Data Printed Succuessfully!! \n");
				break;
			case 5:
				try {
					//search result
					int rno = 0;
					boolean result = false;
					System.out.print("Enter Roll No:");
					rno = Integer.parseInt(sc.nextLine());
					
					
					result = StudentMenu.search(rno);
					if(result==true)
					{ 
						System.out.println("Data Printed Succuessfully!!\n");
					}
					else
					{	
						System.out.println("No Data Found!!\n");
					}
					}
					catch(Exception e)
					{
						System.out.println("Enter Valid RollNo");
					}
					
				break;
				
			case 6:
				//Exit
				break;
			default:
				System.out.println("Invalid Input");
				System.out.println("Please Enter Correct Input:");
		
			}
			if(c==6)
			{
				System.out.println("Exited Succuessfully!!");
				break;
			}
			
		}
		sc.close();

	}

}

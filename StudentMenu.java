package com.jdbcasmnt;

import java.sql.*;


public class StudentMenu {
   public static boolean insertData(String name,int rno)
   {
	   int result=0;
	   try {
	   Connection con = ConnectionJDBC.createCon();
	   String sql = "insert into student_master(rollno,name) values(?,?)";
	   
	   PreparedStatement ps = con.prepareStatement(sql);
	   
	   if(rno!=0 && name!="")
	   {
	   ps.setInt(1, rno);;
	   ps.setString(2, name);
	   result = ps.executeUpdate();
	   }
	   
	   else
	   {
		   System.out.println("Enter Valid Data!!");
	   }
	   }
	   catch(SQLIntegrityConstraintViolationException e)
	   {
		   System.out.println("Duplicate Entry !!");
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   if(result==1)
	   {
		   return  true;
	   }
	   return false;
	     
   }
   public static void showData()
   {
	   try
	   {
		  Connection con = ConnectionJDBC.createCon();
		  String sql = "select * from  student_master ";
		  PreparedStatement cs = con.prepareStatement(sql);
		  ResultSet rs = cs.executeQuery(sql);
		 System.out.println("Rollno"+"  "+"Name");
		  while(rs.next())
		  {
			  System.out.println(rs.getInt(2)+"  "+rs.getString(1));
		  }  
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
   public static boolean deleteData(int rno) throws SQLException
   {
	   Connection con = ConnectionJDBC.createCon();
	   boolean result=false;
		  String sql = "delete from  student_master  where rollno="+rno;
		  Statement cs = con.createStatement();
		 result = cs.executeUpdate(sql)==1?true:false;
		 
		  return result;
   }
   public static boolean search(int rno) throws SQLException
   {
	   Connection con = ConnectionJDBC.createCon();
	      boolean result = false;
		  String sql = "select * from  student_master  where rollno="+rno;
		  PreparedStatement cs = con.prepareStatement(sql);
		 ResultSet rs = cs.executeQuery();
		 
		 System.out.println("Rollno"+"  "+"Name");
		  while(rs.next())
		  {
			  System.out.println(rs.getInt(2)+"  "+rs.getString(1));
			  result=true;
		  }  
		  return result;
   }
   public static boolean update(int rno,String newName) throws SQLException
   {
	   Connection con = ConnectionJDBC.createCon();
	   boolean result=false;
		  String sql = "update student_master set name=? where rollno=?";
		 
		  PreparedStatement ps = con.prepareStatement(sql);
		  ps.setString(1,newName);
		  ps.setInt(2,rno);
		 
		  result = ps.executeUpdate()==1?true:false;
		 
		  return result;
   }
}

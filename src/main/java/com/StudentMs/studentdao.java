package com.StudentMs;
import java.sql.*;
public class studentdao {

	Connection con=null;
	public void dbconnection() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentMs","root","123973");
		
	}
    //method to register student to db
	public int registerstudent(student s1) throws Exception {
		
	 String query="insert into StudentMS values(?,?,?,?)"; 
	 PreparedStatement pst=con.prepareStatement(query);
	 pst.setInt(1,s1.sId);
	 pst.setString(2, s1.sName);
     pst.setString(3, s1.sEmail);
     pst.setString(4, s1.sPhone); 
     int res=pst.executeUpdate();
	 return res;
	}
	
	public int login(String sname,int sid) throws Exception{
		
		String query="select * from StudentMS where sid="+sid ;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();		
			if(sname.equals(rs.getString(2))) {
				return sid;
			}
			return -1;
		
	}
	
	
	
	public int updatestudentname(int sid,String sname) throws Exception { 
	
		String query2="update StudentMS set sName='"+sname+"' where sid="+sid;
		PreparedStatement pst=con.prepareStatement(query2);
		int res =pst.executeUpdate();
		return res;
		
	}
			public int updatestudentemail(int sId,String Email) throws Exception {
         	
			String query2="update StudentMS set sEmail ='"+Email+"' where sid="+sId;
			PreparedStatement pst=con.prepareStatement(query2);
			pst.executeUpdate();
			return 1;
		}           

			public int updatestudentphone(int sId,String Phone) throws Exception {
			//update student phone number
				String query2="update StudentMS set sPhone ='"+Phone+"' where sid="+sId;
				PreparedStatement pst=con.prepareStatement(query2);
				pst.executeUpdate();	
				return 1;
			}          	
	public int deletestudent(int sId) throws Exception {
		
			//delete the student details
			String query2="delete from StudentMS where sid="+sId;
			PreparedStatement pst=con.prepareStatement(query2);
			pst.executeUpdate();
			return 1;
	
	}
}
	


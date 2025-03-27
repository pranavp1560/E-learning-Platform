package com.E_Learning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.E_Learning.model.AdmissionBean;

public class AdmissionDao {
	private ResultSet rs;
	ConnectionDao cd=new ConnectionDao();
	 PreparedStatement pst;
	 
	 public boolean admission(AdmissionBean bean) {
		 Connection con=cd.getConnection();
		 try {			
			 pst=con.prepareStatement("insert into admission values(?,?,?,?,?,?,?,?,?,?,?,?)");
			 pst.setString(1, bean.getFirstName());
			 pst.setString(2, bean.getMiddleName());
			 pst.setString(3, bean.getLastName());
			 pst.setString(4, bean.getMothersName());
			 pst.setString(5, bean.getAddress());			
			 pst.setString(6, bean.getEmail());
			 pst.setString(7, bean.getPhone());
			 pst.setString(8, bean.getEmergencyPhone());
			 pst.setString(9, bean.getDob());
			 pst.setString(10, bean.getGender());
			 pst.setString(11, bean.getBatchMode());
			 pst.setString(12, bean.getCourse());
			
			 

				int i =pst.executeUpdate();
				if(i!=0)
				{
					System.out.println("hello1");
					return true;
				}
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return false;
	 }
	 
	 public AdmissionBean update(AdmissionBean bean) {
		 Connection con=cd.getConnection();
		 try {
			 pst=con.prepareStatement("select * from admission where phone=?");
			 pst.setString(1, bean.getPhone());
			 
				rs=pst.executeQuery();
				while(rs.next())
				{
					
					    bean.setFirstName(rs.getString("firstName"));
		                bean.setMiddleName(rs.getString("middleName"));
		                bean.setLastName(rs.getString("lastName"));
		                bean.setMothersName(rs.getString("mothersName"));
		                bean.setAddress(rs.getString("address"));
		                bean.setEmail(rs.getString("email"));
		                bean.setPhone(rs.getString("phone"));
		                bean.setEmergencyPhone(rs.getString("emergencyPhone"));
		                bean.setDob(rs.getString("dob"));
		                bean.setGender(rs.getString("gender"));
		                bean.setBatchMode(rs.getString("batchMode"));
					    bean.setCourse(rs.getString("course"));

					
				}
			 
		 }catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return bean;
		 
	 }
	 
 public boolean updateAdd(AdmissionBean bean) {
	 
		 Connection con=cd.getConnection();
		 try {
			 pst=con.prepareStatement("update admission set firstName=?,middleName=?,lastName=?,mothersName=?,address=?,email=?,emergencyPhone=?,dob=?,gender=?,batchMode=?,course=? where phone="+bean.getPhone()+"");
			 pst.setString(1, bean.getFirstName());
			 pst.setString(2, bean.getMiddleName());
			 pst.setString(3, bean.getLastName());
			 pst.setString(4, bean.getMothersName());
			 pst.setString(5, bean.getAddress());
			 pst.setString(6, bean.getEmail());
			 pst.setString(7, bean.getEmergencyPhone());
			 pst.setString(8, bean.getDob());
			 pst.setString(9, bean.getGender());
			 pst.setString(10, bean.getBatchMode());
			 pst.setString(11, bean.getCourse());
			 
			int	i=pst.executeUpdate();
				if(i!=0)
				{
					System.out.println("Update successfully");
					
					
				}
			 
		 }catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	
		 
	 }
	 
 public boolean deleteStudent(AdmissionBean bean) {
	 System.out.println("In delete");
	 Connection con=cd.getConnection();
	 try {
		 pst=con.prepareStatement("delete from admission where phone="+bean.getPhone()+"");

		int	i=pst.executeUpdate();
			if(i!=0)
			{
				System.out.println("delete successfully");
				
				
			}
		 
	 }catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;

	 
 }
 
	 
	 
}

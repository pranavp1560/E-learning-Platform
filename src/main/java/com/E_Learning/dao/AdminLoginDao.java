package com.E_Learning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.E_Learning.model.AdminLoginBean;

public class AdminLoginDao {
	ConnectionDao cd=new ConnectionDao();
	 PreparedStatement pst;
	 private ResultSet rs;
	 
	 public boolean admin(AdminLoginBean bean) {
		 Connection con=cd.getConnection();
		 try {
			 pst=con.prepareStatement("select username,pass from admin_login where username=? and pass=?");
			 pst.setString(1, bean.getUsername());
			 pst.setString(2, bean.getPassword());
				
				rs=pst.executeQuery();
			
				while(rs.next())
				{
					
					return true;
					
				}
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return false;
	 
	 }

}

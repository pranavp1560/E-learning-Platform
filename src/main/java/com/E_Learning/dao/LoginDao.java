package com.E_Learning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.tomcat.util.digester.SystemPropertySource;

import com.E_Learning.model.LoginBean;
import com.E_Learning.model.RegisteredBean;

public class LoginDao {
private Connection con=null;
private String mobile,password;
private PreparedStatement pst;
private ResultSet rs;

/* LoginBean lb=new LoginBean(); */
public boolean login(RegisteredBean bean) {
	mobile=bean.getMobile();
	password=bean.getPassword();
	ConnectionDao cd =new ConnectionDao();
	
	try {
		con=cd.getConnection();
		String query = "select mobile from registration where mobile=? and pass=?";
		pst=con.prepareStatement(query);
		pst.setString(1, mobile);
		pst.setString(2, password);
		
		rs=pst.executeQuery();
	
		while(rs.next())
		{
			System.out.println(rs.getString("mobile"));
			return true;
			
		}
	 
	
}
	catch(Exception e) {
		
      System.out.println(e);
		
	}
	return false;
}

}

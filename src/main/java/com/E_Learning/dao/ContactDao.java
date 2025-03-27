package com.E_Learning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.E_Learning.model.ContactBean;

public class ContactDao {

	ConnectionDao cd=new ConnectionDao();
	 PreparedStatement pst;
	  public boolean contact(ContactBean bean){
		  Connection con=cd.getConnection();
		  try {
			  pst=con.prepareStatement("insert into contact values(?,?,?,?)");
			  pst.setString(1, bean.getUsername());
			  pst.setString(2, bean.getEmail());
			  pst.setString(3, bean.getSub());
			  pst.setString(4, bean.getMessage());
			  
				int i =pst.executeUpdate();
				if(i!=0)
				{
					System.out.println("hello1");
					return true;
				}
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		return false;
	  }
}

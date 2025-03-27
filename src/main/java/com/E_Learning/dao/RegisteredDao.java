package com.E_Learning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.E_Learning.model.RegisteredBean;

public class RegisteredDao {
      ConnectionDao cd=new ConnectionDao();
      
      PreparedStatement pst;
      
      public boolean register(RegisteredBean bean)
      {
    	  Connection con=cd.getConnection();
    	  try {
			pst=con.prepareStatement("insert into registration values(?,?,?,?,?)");
			pst.setString(1, bean.getUsername());
			pst.setString(2, bean.getMobile());
			pst.setString(3, bean.getEmail());
			pst.setString(4, bean.getPassword());
			pst.setString(5, bean.getCourse());
					
			
			int i =pst.executeUpdate();
			if(i!=0)
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
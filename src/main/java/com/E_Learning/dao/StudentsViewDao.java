package com.E_Learning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.E_Learning.model.AdmissionBean;

public class StudentsViewDao {
	ConnectionDao cd=new ConnectionDao();
	Connection con=cd.getConnection();
    PreparedStatement pst;
    AdmissionBean bean= new AdmissionBean();
    ResultSet rs;   
  public List<AdmissionBean> studentsViewByCourse(String course) {
        List<AdmissionBean> students = new ArrayList<>();
        try {
        	pst=con.prepareStatement("select fee from fees where course=?");
			pst.setString(1, course);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				long fee=rs.getLong("fee");
				bean.setFees(fee);
				//System.out.println(fee);
				//System.out.println("hello");
			}
	
        	
            pst = con.prepareStatement("SELECT * FROM admission WHERE course = ?");
            pst.setString(1, course);
            rs = pst.executeQuery();

            while (rs.next()) {
                
                bean.setFirstName(rs.getString("firstName"));
                bean.setMiddleName(rs.getString("middleName"));
                bean.setLastName(rs.getString("lastName"));
                bean.setAddress(rs.getString("address"));
                bean.setEmail(rs.getString("email"));
                bean.setPhone(rs.getString("phone"));
                bean.setEmergencyPhone(rs.getString("emergencyPhone"));
                bean.setDob(rs.getString("dob"));
                bean.setGender(rs.getString("gender"));
                bean.setBatchMode(rs.getString("batchMode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        students.add(bean);
        return students;
    }
}

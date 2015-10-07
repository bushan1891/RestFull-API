package Resturant.egen.dao;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Resturant.egen.model.Resturant;
import Resturant.egen.util.DBUtils;
import Resturant.egen.exception.AppException;
import Resturant.egen.exception.*;

public class ResturantDAO  {
	
	public List<Resturant> fetchAll() throws AppException {
		
		List<Resturant> ResList = new ArrayList<Resturant>();
		Connection con = DBUtils.getConnection();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			ps = con.prepareStatement("Select * from rest_db.resturant");
			rs = ps.executeQuery();
			
		while(rs.next()){
		Resturant res	= new Resturant();
		
		res.setCON_id(rs.getInt("CON_ID"));
		res.setFirstName(rs.getString("FIRST_NAME"));
		res.setLastName(rs.getString("LAST_NAME"));
		res.setEmail(rs.getString("EMAIL"));
		res.setDate(rs.getTimestamp("RES_DATE"));
		res.setPhone(rs.getString("PHONE"));
		System.out.println(res.getCON_id());
		ResList.add(res);
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" Error in Returant DAO "+ e );
			throw new AppException(e.getMessage(), e.getCause());	
		}
		finally {
			DBUtils.closeResource(ps,rs,con);
		}
		
	 return ResList;
		
	}
	
	
	public Resturant fetchOne(int CON_ID){
		Resturant res = new Resturant();
		
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		try {
			
			ps = con.prepareStatement("select * from resturant where CON_ID =?");
			ps.setLong(1,CON_ID);
			
			rs= ps.executeQuery();
			while(rs.next()){
				
				res.setCON_id(rs.getInt("CON_ID"));
				res.setFirstName(rs.getString("FIRST_NAME"));
				res.setLastName(rs.getString("LAST_NAME"));
				res.setEmail(rs.getString("EMAIL"));
				res.setDate(rs.getTimestamp("RES_DATE"));
				res.setPhone(rs.getString("PHONE"));
				System.out.println(res.getCON_id());	
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
	}

}

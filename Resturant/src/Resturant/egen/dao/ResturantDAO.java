package Resturant.egen.dao;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
	
	
	public Resturant create(Resturant res) throws AppException {
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		System.out.println(res.getFirstName());
		
		try {
			ps = con.prepareStatement("INSERT INTO resturant (FIRST_NAME,LAST_NAME,EMAIL,RES_DATE,PHONE) VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);			
			ps.setString(1, res.getFirstName());
			ps.setString(2, res.getLastName());
			ps.setString(3, res.getEmail());
			ps.setTimestamp(4,res.getDate());
			ps.setString(5, res.getPhone());
			
			
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				//res.setCON_id(rs.getInt(1));
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DBUtils.closeResource(ps, rs, con);
		}

		return res;
	}
	
	
	
	public Resturant update(Integer CON_ID,Resturant res) throws AppException {
		
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			ps = con.prepareStatement("UPDATE rest_db.resturant SET FIRST_NAME=?,LAST_NAME=?,EMAIL=?,RES_DATE=?,PHONE=? WHERE CON_ID=?;", PreparedStatement.RETURN_GENERATED_KEYS);			
			ps.setString(1, res.getFirstName());
			ps.setString(2, res.getLastName());
			ps.setString(3, res.getEmail());
			ps.setTimestamp(4,res.getDate());
			ps.setString(5, res.getPhone());
			ps.setInt(6,CON_ID);
			
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				//res.setCON_id(rs.getInt(1));
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		} finally {
			DBUtils.closeResource(ps, rs, con);
		}

		return res;
		
		
	
	
	}

}
